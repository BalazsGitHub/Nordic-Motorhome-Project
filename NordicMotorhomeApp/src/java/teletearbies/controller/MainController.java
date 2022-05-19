package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import teletearbies.entity.Booking;
import teletearbies.entity.Extra;
import teletearbies.entity.Motorhome;
import teletearbies.entity.User;
import teletearbies.service.BookingService;
import teletearbies.service.ExtraService;
import teletearbies.service.MotorhomeService;
import teletearbies.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    private MotorhomeService motorhomeService;

    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserService userService;

    @Autowired
    private ExtraService extraService;

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
        List<Extra> extraList = extraService.getAllExtras();
        model.addAttribute("extraList", extraList);
        model.addAttribute("bookingList", bookingList);
        return "bookings/manageBookings";
    }

    @RequestMapping("/manageusers")
    public String manageUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users/manageUsers";
    }


}