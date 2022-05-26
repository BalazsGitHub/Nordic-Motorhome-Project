package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import teletearbies.entity.Booking;
import teletearbies.entity.Extra;
import teletearbies.entity.Motorhome;
import teletearbies.entity.User;
import teletearbies.service.BookingService;
import teletearbies.service.ExtraService;
import teletearbies.service.MotorhomeService;
import teletearbies.service.UserService;

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


    @GetMapping(value = {"/", "/login"})
    public String showHomePage() {
        return "login/login";
    }

    @RequestMapping("/logUserIn")
    public String getAdminDashboard(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    Model model) {
        User user = userService.getUserByUsername(username);
        if (user.getPassword().equals(password)) {
            model.addAttribute("username", user.getUsername());
            return "mainPage/mainPage";
        } else {
            model.addAttribute("errorMessage", "Wrong username or password!");
            return "login/error";
        }
    }

    @RequestMapping("/mainpage")
    public String backToMainMenu() {
        return "mainPage/mainPage";
    }

    @RequestMapping("/teampage")
    public String teamPage() {
        return "team/teamPage";
    }

    @RequestMapping("/managemotorhomes")
    public String manageMotorhomes(Model model) {
        List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();

        motorhomeList.removeIf(motorhome -> !motorhome.isRepaired());

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


    @GetMapping("/manageusers")
    //Handler method to handle the request to view the users listing page at the given url
    //With the model attribute we acces the MVC's model object
    public String manageUsers(Model model) {
        //calling the service to get the list of users
        List<User> userList = userService.getAllUsers();
        //putting this list to the model with attribute name and value,
        //so we can access this collection in the view to display the user information
        model.addAttribute("userList", userList);
        //return logical view name which is the path to manageUsers.html in the users folder
        return "users/manageUsers";
    }

    @RequestMapping("/repairshop")
    public String manageRepairshop(Model model) {

        List<Motorhome> motorhomeList = motorhomeService.getAllMotorhomes();

        motorhomeList.removeIf(Motorhome::isRepaired);

        model.addAttribute("motorhomeList", motorhomeList);
        return "repairshop/manageRepairShop";
    }
}