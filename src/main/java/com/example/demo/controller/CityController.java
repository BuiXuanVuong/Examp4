package com.example.demo.controller;


import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping("/create-city")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCustomer(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/cities")
    public ModelAndView listCustomers(){
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("customer", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCustomer(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("city", city);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCustomer(@ModelAttribute("customer") City city){
        cityService.remove(city.getId());
        return "redirect:cities";
    }
}
