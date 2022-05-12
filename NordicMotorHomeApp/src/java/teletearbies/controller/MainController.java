package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import teletearbies.entity.Motorhome;
import teletearbies.service.MotorhomeService;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private MotorhomeService motorhomeService;

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
        List <Motorhome> motorhomeList = motorhomeService.getAll();
        model.addAttribute("motorhomeList", motorhomeList);
        return "motorhomes/manageMotorhomes";
    }

    @RequestMapping("/managebookings")
    public String manageBookings() {
        return "bookings/manageBookings";
    }

    @RequestMapping("/manageusers")
    public String manageUsers() {
        return "users/manageUsers";
    }
}