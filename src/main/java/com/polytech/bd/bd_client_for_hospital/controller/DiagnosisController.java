package com.polytech.bd.bd_client_for_hospital.controller;

import com.polytech.bd.bd_client_for_hospital.entity.Diagnosis;
import com.polytech.bd.bd_client_for_hospital.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping("/diagnoses")
    public String showDiagnosis(Model model) {
        List<Diagnosis> diagnosisList = diagnosisService.getAllDiagnosis();
        model.addAttribute("diagnosisList", diagnosisList);
        return "diagnoses";
    }

    @PostMapping(value = "/diagnoses/addDiagnosis")
    public String addDiagnosis(@ModelAttribute Diagnosis diagnosis) {
        diagnosisService.add(diagnosis);

        return "redirect:/diagnoses";
    }

    @GetMapping("/diagnosis")
    public String getById(@RequestParam("id") Long id, Model model) {
        Diagnosis diagnosis = diagnosisService.getById(id);
        model.addAttribute("diagnosis", diagnosis);

        return "diagnosis";
    }

    @PostMapping(value = "/diagnosis/editDiagnosis", params = "action=edit")
    public String editDiagnosis(@RequestParam("id") Long id, @ModelAttribute Diagnosis diagnosis) {
        diagnosisService.edit(id, diagnosis);

        return "redirect:/diagnoses";
    }

    @PostMapping(value = "/diagnosis/editDiagnosis", params = "action=delete")
    public String deleteDiagnosis(@RequestParam("id") Long id, @ModelAttribute Diagnosis diagnosis) {
        diagnosisService.delete(id);

        return "redirect:/diagnoses";
    }
}
