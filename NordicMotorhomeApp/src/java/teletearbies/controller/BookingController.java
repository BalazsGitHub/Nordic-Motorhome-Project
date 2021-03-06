package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teletearbies.entity.*;
import teletearbies.service.*;

import java.util.List;

//The @controller annotation indicated that a particular class serves the role of a controller.
//The controller class is responsible for processing incoming HTTP requests, preparing a model,
//and returning the view to be rendered as a response.
@Controller
public class BookingController {

    //enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
    @Autowired
    BookingService bookingService;

    @Autowired
    UserService userService;

    @Autowired
    SeasonService seasonService;

    @Autowired
    MotorhomeService motorhomeService;

    @Autowired
    ExtraService extraService;

    @Autowired
    CancellationService cancellationService;

    //this annotation is used to map HTTP requests onto a specific handler method (can also be a class)
    //the url is the place this specific method will be executed.
    @RequestMapping("/booking/add")
    public String addBooking(Model model, Booking booking) {
        //In Spring MVC, the model interface is a container that contains data(objects, info from db, etc..)
        //it puts together our frontend, and backend.
        //The view(html, etc) visualizes the data that the model contains.

        List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();
        //it connects a for loop and an if statement, if motorhome not repaired it is removed from this temporary list
        motorhomeList.removeIf(motorhome -> !motorhome.isRepaired());
        //gives this list to the model container/object. Model hands it to the form.
        model.addAttribute("motorhomeList", motorhomeList);

        List<Extra> extraList = extraService.getAllExtras();
        model.addAttribute("extraList", extraList);

        List<Cancellation> cancellationList = cancellationService.getAllCancellations();
        model.addAttribute("cancellationList", cancellationList);

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        List<Season> seasonList = seasonService.getAllSeasons();
        model.addAttribute("seasonList", seasonList);

        model.addAttribute("fuelHalf", booking.isFuelBelowHalf());

        model.addAttribute("consentToTerms", booking.isConsentToTerms());

        model.addAttribute("booking", new Booking());
        //loads the address of an HTML
        return "bookings/bookingForm";
    }

// handles the HTTP POST request matched with the given URL expression
    @PostMapping("/booking/save")
    public String saveBooking(Booking booking, RedirectAttributes redirectAttributes) {

        booking.setNumberOfDays(booking.calculateDay());
        booking.setFinalPrice(booking.calculatePrice());

        bookingService.saveBooking(booking);
        redirectAttributes.addFlashAttribute("message", "Booking has been saved!");

        return "redirect:/managebookings";
    }

    @RequestMapping("/booking/edit/{id}")
    //@PathVariable is used to fetch a value from URL. It is used to identify, in this case, the specific id from the booking.
    public String editBooking(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Booking booking = bookingService.getBooking(id);
            //Get the booking, by specifying the id, accordingly to @PathVariable id
            model.addAttribute("booking", booking);

            List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();
            //Calls the getAllMotorhomes method which returns a list of users
            // then we set it to a user list, that is passed into the model
            model.addAttribute("motorhomeList", motorhomeList);

            List<Extra> extraList = extraService.getAllExtras();
            //Calls the getAllExtras method which returns a list of users
            // then we set it to a user list, that is passed into the model
            model.addAttribute("extraList", extraList);

            List<Cancellation> cancellationList = cancellationService.getAllCancellations();
            //Calls the getAllCancellations method which returns a list of users
            // then we set it to a user list, that is passed into the model
            model.addAttribute("cancellationList", cancellationList);

            List<User> userList = userService.getAllUsers();
            //Calls the getAllUsers method which returns a list of users
            // then we set it to a user list, that is passed into the model
            model.addAttribute("userList", userList);

            List<Season> seasonList = seasonService.getAllSeasons();
            //Calls the getAllSeasons method which returns a list of users
            // then we set it to a user list, that is passed into the model
            model.addAttribute("seasonList", seasonList);

            model.addAttribute("fuelHalf", booking.isFuelBelowHalf());
            //the boolean method is called from the booking, then is passed into the model attribute

            model.addAttribute("consentToTerms", booking.isConsentToTerms());
            //the boolean method is called from the booking, then is passed into the model attribute

            //once the bookingform, html page is returned,
            // the save method within it will be invoked (the form contain an action, which has a method "post", so when press save, you post/"send"/update the new info on the db
            return "bookings/bookingForm";

        } catch (BookingNotFoundException e) {
            //in case of an error/ exception we display a customized message that is passed into our booking exception method
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");
            //redirect loads a URL
            return "redirect:/managebookings";
        }
    }

    @RequestMapping("/booking/delete/{id}")
    public String deleteBooking(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        //@PathVariable is used to fetch a value from URL. It is used to identify, in this case, the specific id from the booking.
        try {

            Booking booking = bookingService.getBooking(id);
            Motorhome motorhome = booking.getMotorhome();
            motorhome.setRepairedFalse();
            motorhomeService.saveMotorhome(motorhome);
            bookingService.deleteBooking(id);
            redirectAttributes.addFlashAttribute("message", "Booking has been deleted!");
        } catch (BookingNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/managebookings";
    }

    @RequestMapping("booking/receipt/{id}")
    public String viewReceipt (Model model, @PathVariable("id") Integer id) throws BookingNotFoundException {
        //@PathVariable is used to fetch a value from URL. It is used to identify, in this case, the specific id from the booking.
        int fuelFee = 0;

       Booking booking = bookingService.getBooking(id);

        if(booking.isFuelBelowHalf()){
            fuelFee = 70;
        }

        double deliveryFee = booking.getDistanceFromNMR() * 0.7;

        model.addAttribute("extraList", booking.getExtras());
        model.addAttribute("booking", booking);
        model.addAttribute("fuelFee", fuelFee);
        model.addAttribute("deliveryFee", deliveryFee);

        return "bookings/receipt";
    }

    @RequestMapping("/terms")
    public String showTerms() {
        return "bookings/termsandconditions";
    }
}