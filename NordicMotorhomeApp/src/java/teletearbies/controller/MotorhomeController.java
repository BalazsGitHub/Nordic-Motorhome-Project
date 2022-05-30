package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teletearbies.entity.Brand;
import teletearbies.entity.Motorhome;
import teletearbies.service.BrandService;
import teletearbies.service.MotorhomeNotFoundException;
import teletearbies.service.MotorhomeService;

import java.util.List;
//The @controller annotation indicated that a particular class serves the role of a controller.
//The controller class is responsible for processing incoming HTTP requests, preparing a model,
// and returning the view to be rendered as a response.
@Controller
public class MotorhomeController {
    // @Autowired enables us to inject object dependency implicitly. It internally uses setter or constructor injection.
    @Autowired
    MotorhomeService motorhomeService;
    @Autowired
    BrandService brandService;

    //this annotation is used to map HTTP requests onto a specific handler method (can also be a class)
    //the url is the place this specific method will be executed.
    @RequestMapping("/motorhome/add")
    public String addMotorhome(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        model.addAttribute("brands", brandList);
        model.addAttribute("motorhome", new Motorhome());

        return "motorhomes/motorhomeForm";
    }

// handles the HTTP POST request matched with the given URL expression
    @PostMapping("/motorhome/save")
    public String saveMotorhome(Motorhome motorhome, RedirectAttributes redirectAttributes) {
        motorhomeService.saveMotorhome(motorhome);
        redirectAttributes.addFlashAttribute("message", "Motorhome was saved!");

        return "redirect:/managemotorhomes";
    }


    @RequestMapping("/motorhome/edit/{id}")
    public String editMotorhome(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Motorhome motorhome = motorhomeService.getMotorhome(id);
            model.addAttribute("motorhome", motorhome);

            List<Brand> brandList = brandService.getAllBrands();
            model.addAttribute("brands", brandList);

            return "motorhomes/motorhomeForm";

        } catch (MotorhomeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");

            return "redirect:/managemotorhomes";
        }
    }

    @RequestMapping("/motorhome/delete/{id}")
    public String deleteMotorhome(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            motorhomeService.deleteMotorhome(id);
            redirectAttributes.addFlashAttribute("message", "Motorhome was deleted!");

        } catch (MotorhomeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        } catch (Exception exception) {
            redirectAttributes.addFlashAttribute("message", "Can't delete booked motorhome");
        }
        return "redirect:/managemotorhomes";
    }



    @PostMapping("/motorhome/registerRepair")
    public String saveRepair(Motorhome motorhome, RedirectAttributes redirectAttributes) {
        motorhome.setRepairedFalse();
        motorhomeService.saveMotorhome(motorhome);
        redirectAttributes.addFlashAttribute("message", "Motorhome has been sent to the repair shop!");

        return "redirect:/managemotorhomes";
    }

    @RequestMapping("/motorhome/repair/{id}")
    public String editRepair(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Motorhome motorhome = motorhomeService.getMotorhome(id);
            model.addAttribute("motorhome", motorhome);

            List<Brand> brandList = brandService.getAllBrands();
            model.addAttribute("brands", brandList);

            return "motorhomes/registerMotorhomeRepairForm";

        } catch (MotorhomeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");

            return "redirect:/managemotorhomes";
        }
    }
}

