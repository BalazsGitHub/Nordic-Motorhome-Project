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

@Controller
public class MotorhomeController {

    @Autowired
    MotorhomeService motorhomeService;
    @Autowired
    BrandService brandService;

    @RequestMapping("/motorhome/add")
    public String addMotorhome(Model model) {
        List<Brand> brandList = brandService.getAllBrands();
        model.addAttribute("brands", brandList);
        model.addAttribute("motorhome", new Motorhome());

        return "motorhomes/motorhomeForm";
    }

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

    @RequestMapping("/repairshop/repair/{id}")
    public String repairMotorhome(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Motorhome motorhome = motorhomeService.getMotorhome(id);
            model.addAttribute("motorhome", motorhome);

            return "repairShop/repairShopForm";
        } catch (MotorhomeNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");
            return "redirect:/managepepairshop";
        }
    }

    @PostMapping("/repairshop/save")
    public String saveMotorhomeRepair(Motorhome motorhome) {
        motorhome.setBeingRepaired(true);
        motorhomeService.saveMotorhome(motorhome);

        return "repairShop/manageRepairShop";
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


}