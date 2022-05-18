package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teletearbies.entity.Booking;
import teletearbies.entity.Brand;
import teletearbies.entity.Motorhome;
import teletearbies.service.BookingNotFoundException;
import teletearbies.service.BookingService;
import teletearbies.service.MotorhomeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class BookingController {

    @Autowired
    BookingService bookingService;


    @PostMapping("/booking/save")
    public String saveBooking(Booking booking, RedirectAttributes redirectAttributes) {
        bookingService.saveBooking(booking);
        redirectAttributes.addFlashAttribute("message", "Booking was saved!");
        return "redirect:/managebookings";
    }

    @RequestMapping("/booking/edit/{id}")
    public String editBooking(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Booking booking = bookingService.getBooking(id);
            model.addAttribute("booking", booking);
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
            bookingService.deleteBooking(id);
            redirectAttributes.addFlashAttribute("message", "Booking was deleted!");
        } catch (BookingNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/managebookings";

    }

   /* @RequestMapping( "/booking/add")
    public String carDropDown(Model model) {
        List<String> cars = new ArrayList<>();
        cars.add("Ymir");
        cars.add("Heimdal");
        cars.add("Odin");
        cars.add("Thor");
        cars.add("Vidar");
        cars.add("Freja");
        cars.add("Tyr");
        cars.add("Loki");
        cars.add("Hela");
        cars.add("Idun");
        model.addAttribute("cars", cars);
        return "bookings/bookingForm";
    }*/

  /*  @RequestMapping("/booking/add")
    public String addBooking(Model model) {
        model.addAttribute("booking", new Booking());

        List<Brand> brandList = brandService.getAllBrands();

        model.addAttribute("brands", brandList );

        return "motorhomes/motorhomeForm";
    }*/
}