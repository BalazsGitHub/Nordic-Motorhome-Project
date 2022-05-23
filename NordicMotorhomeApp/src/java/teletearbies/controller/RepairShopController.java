package teletearbies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import teletearbies.entity.Motorhome;
import teletearbies.service.BrandService;
import teletearbies.service.MotorhomeNotFoundException;
import teletearbies.service.MotorhomeService;

import java.util.List;

@Controller
public class RepairShopController {

    @Autowired
    private MotorhomeService motorhomeService;

    @Autowired
    private BrandService brandService;

    @PostMapping("/repairshop/save")
    public String saveRepair(Motorhome motorhome, RedirectAttributes redirectAttributes) {
        motorhome.setRepaired(true);
        motorhomeService.saveMotorhome(motorhome);
        redirectAttributes.addFlashAttribute("message", "Repair update was saved!");

        return "redirect:/repairshop";
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

            return "redirect:/repairshop";
        }
    }

}
