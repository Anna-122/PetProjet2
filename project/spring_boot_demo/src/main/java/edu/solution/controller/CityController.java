package edu.solution.controller;


import edu.solution.model.City;
import edu.solution.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


@Controller
public class CityController {


    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/admin/cities")
    public String findAll(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "/admin/city-list.html";
    }

    @GetMapping("/admin/city-create")
    public String createCityForm(City city){
        return "/admin/city-create";
    }

    @PostMapping("/admin/city-create")
    public String createCity(City city){
        cityService.saveCity(city);
        return "redirect:/cities";
    }

    @GetMapping("/admin/city-delete/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        cityService.deleteById(id);
        return "redirect:/admin/cities";
    }


    @GetMapping("/admin/city-update/{id}")
    public String updateCountryForm(@PathVariable("id") Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "/admin/city-update";
    }

    @PostMapping("/admin/city-update")
    public String updateCity(City city){
        cityService.saveCity(city);
        return "redirect:/admin/cities";
    }
}
