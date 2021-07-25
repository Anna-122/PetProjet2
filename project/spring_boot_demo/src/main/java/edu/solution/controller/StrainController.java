package edu.solution.controller;

import edu.solution.model.Strain;
import edu.solution.service.StrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StrainController {

    private final StrainService strainService;

    @Autowired
    public StrainController(StrainService strainService) {
        this.strainService = strainService;
    }


//    @GetMapping("/admin/admin")
//    public String admin(){
//        return "/admin/admin";
//    }

    @GetMapping("/user/strains")
    public String findAll(Model model){
        List<Strain> strains = strainService.findAll();
        model.addAttribute("strains", strains);
        return "user/strain-list";
    }

    @GetMapping("/user/strain-create")
    public String createStrainForm(Strain strain){
        return "user/strain-create";
    }

    @PostMapping("/user/strain-create")
    public String createStrain(Strain strain){
        strainService.saveStrain(strain);
        return "redirect:/user/strains";
    }

    @GetMapping("/user/strain-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        strainService.deleteById(id);
        return "redirect:/user/strains";
    }

    @GetMapping("/user/strain-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Strain strain = strainService.findById(id);
        model.addAttribute("strain", strain);
        return "user/strain-update";
    }

    @PostMapping("/user/strain-update")
    public String updateUser(Strain strain){
        strainService.saveStrain(strain);
        return "redirect:/user/strains";
    }

}
