package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.Country;
import net.proselyte.springbootdemo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


@Controller
public class CountryController {


    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/admin/countries")
    public String findAll(Model model){
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "/admin/country-list";
    }

    @GetMapping("/admin/country-create")
    public String createCountryForm(Country country){
        return "/admin/country-create";
    }
//
//    @PostMapping("/admin/country-create")
//    public String createCountry(Country country){
//        countryService.saveCountry(country);
//        return "redirect:/admin/countries";
//    }
//

    @PostMapping("/admin/country-create")
    public String createCountry(String country){
        Country countryEntity = new Country(null,country);
        countryService.saveCountry( countryEntity);
        return "redirect:/admin/countries";
    }


    @GetMapping("/admin/country-delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id){
        countryService.deleteById(id);
        return "redirect:/admin/countries";
    }


    @GetMapping("/admin/country-update/{id}") //countryId
    public String updateCountryForm(@PathVariable("id") Long id, Model model){ //countryId
        Country country = countryService.findById(id);
        model.addAttribute("country", country);
        return "/admin/country-update";
    }

    @PostMapping("/admin/country-update")
    public String updateCountry(Country country){
        countryService.saveCountry(country);
        return "redirect:/admin/countries";
    }

}
