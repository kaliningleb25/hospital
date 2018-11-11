package com.polytech.bd.bd_client_for_hospital.controller;

import com.polytech.bd.bd_client_for_hospital.entity.People;
import com.polytech.bd.bd_client_for_hospital.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/peoples")
    public String showPeoples(Model model) {
        List<People> peopleList = peopleService.getAllPeople();
        model.addAttribute("peopleList", peopleList);
        return "peoples";
    }

    @PostMapping(value = "/peoples/addPeople")
    public String addPeople(@ModelAttribute People people) {
        peopleService.add(people);

        return "redirect:/peoples";
    }

    @GetMapping("/people")
    public String getById(@RequestParam("id") Long id, Model model) {
        People people = peopleService.getById(id);
        model.addAttribute("people", people);

        return "people";
    }

    @PostMapping(value = "/people/editPeople", params = "action=edit")
    public String editPeople(@RequestParam("id") Long id, @ModelAttribute People people) {
        peopleService.edit(id, people);

        return "redirect:/peoples";
    }

    @PostMapping(value = "/people/editPeople", params = "action=delete")
    public String deletePeople(@RequestParam("id") Long id, @ModelAttribute People people) {
        peopleService.delete(id);

        return "redirect:/peoples";
    }


}
