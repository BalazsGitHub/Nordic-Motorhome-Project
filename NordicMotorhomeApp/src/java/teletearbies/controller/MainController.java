package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import teletearbies.entity.Booking;
import teletearbies.entity.Motorhome;
import teletearbies.service.BookingService;
import teletearbies.service.MotorhomeService;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private MotorhomeService motorhomeService;

    @Autowired
    private BookingService bookingService;

    @RequestMapping("/")
    public String index() {
        return "mainPage/mainPage";
    }

    @RequestMapping("/teampage")
    public String teamPage() {
        return "team/teamPage";
    }

    @RequestMapping("/managemotorhomes")
    public String manageMotorhomes(Model model) {
        List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();
        model.addAttribute("motorhomeList", motorhomeList);
        return "motorhomes/manageMotorhomes";
    }

    @RequestMapping("/managebookings")
    public String manageBookings(Model model) {
        List<Booking> bookingList = bookingService.getAllBookings();
        model.addAttribute("bookingList", bookingList);
        return "bookings/manageBookings";
    }

    @RequestMapping("/manageusers")
    public String manageUsers() {
        return "users/manageUsers";
    }
}