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

@Controller
public class BookingController {

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

    @RequestMapping("/booking/add")
    public String addBooking(Model model) {
        List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();

        motorhomeList.removeIf(motorhome -> !motorhome.isRepaired());

        model.addAttribute("motorhomeList", motorhomeList);

        List<Cancellation> cancellationList = cancellationService.getAllCancellations();
        model.addAttribute("cancellationList", cancellationList);

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        List<Season> seasonList = seasonService.getAllSeasons();
        model.addAttribute("seasonList", seasonList);

        model.addAttribute("booking", new Booking());

        return "bookings/bookingForm";
    }

    @PostMapping("/booking/save")
    public String saveBooking(Booking booking, RedirectAttributes redirectAttributes) {

        booking.setNumberOfDays(booking.calculateDay());
        booking.setFinalPrice(booking.calculatePrice());


        bookingService.saveBooking(booking);
        redirectAttributes.addFlashAttribute("message", "Booking was saved!");
        return "redirect:/managebookings";
    }

    @RequestMapping("/booking/edit/{id}")
    public String editBooking(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Booking booking = bookingService.getBooking(id);
            model.addAttribute("booking", booking);

            List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();
            model.addAttribute("motorhomeList", motorhomeList);

            List<Extra> extraList = extraService.getAllExtras();
            model.addAttribute("extraList", extraList);

            List<Cancellation> cancellationList = cancellationService.getAllCancellations();
            model.addAttribute("cancellationList", cancellationList);

            List<User> userList = userService.getAllUsers();
            model.addAttribute("userList", userList);

            List<Season> seasonList = seasonService.getAllSeasons();
            model.addAttribute("seasonList", seasonList);

            return "bookings/bookingForm";

        } catch (BookingNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");

            return "redirect:/managebookings";

        }
    }

    @RequestMapping("/booking/delete/{id}")
    public String deleteBooking(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {

        try {

            Booking booking = bookingService.getBooking(id);
            Motorhome motorhome = booking.getMotorhome();
            motorhome.setRepairedFalse();
            motorhomeService.saveMotorhome(motorhome);

            bookingService.deleteBooking(id);
            redirectAttributes.addFlashAttribute("message", "Booking was deleted!");
        } catch (BookingNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/managebookings";
    }

    @RequestMapping("booking/receipt/{id}")
    public String viewReceipt (Model model, @PathVariable("id") Integer id) throws BookingNotFoundException {

       Booking booking = bookingService.getBooking(id);
        List<Booking> bookingList = bookingService.getAllBookings();

        List<Extra> extraList = extraService.getAllExtras();
        model.addAttribute("extraList", booking.getExtras());
        model.addAttribute("booking", booking);
        return "bookings/receipt";
    }

  /*  @GetMapping("/pdf")
    public ModelAndView exportToPdf() {
        ModelAndView mav = new ModelAndView();
        mav.setView(new InvoicePdfExport());
        //read data from DB
        List<Booking> list= bookingService.getAllBookings();
        //send to pdfImpl class
        mav.addObject("list", list);
        return mav;
    }*/
}