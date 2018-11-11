package com.polytech.bd.bd_client_for_hospital.controller;

import com.polytech.bd.bd_client_for_hospital.entity.Ward;
import com.polytech.bd.bd_client_for_hospital.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WardController {

    @Autowired
    private WardService wardService;

    @GetMapping("/wards")
    public String showWards(Model model) {
        List<Ward> wardList = wardService.getAllWards();
        model.addAttribute("wardList", wardList);
        return "wards";
    }

    @PostMapping(value = "/wards/addWard")
    public String addWard(@ModelAttribute Ward ward) {
        wardService.add(ward);

        return "redirect:/wards";
    }

    @GetMapping("/ward")
    public String getById(@RequestParam("id") Long id, Model model) {
        Ward ward = wardService.getById(id);
        model.addAttribute("ward", ward);

        return "ward";
    }

    @PostMapping(value = "/ward/editWard", params = "action=edit")
    public String editWard(@RequestParam("id") Long id, @ModelAttribute Ward ward) {
        wardService.edit(id, ward);

        return "redirect:/wards";
    }

    @PostMapping(value = "/ward/editWard", params = "action=delete")
    public String deleteWard(@RequestParam("id") Long id, @ModelAttribute Ward ward) {
        wardService.delete(id);

        return "redirect:/wards";
    }
}
