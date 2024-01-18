package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.Porsche;
import com.malfin.entity.Mobil;
import com.malfin.service.PorscheService;
import com.malfin.service.MobilService;

@Controller
@RequestMapping("porsche")

public class PorscheController {
    
    @Autowired
    private PorscheService porscheService;

    @Autowired
    private MobilService mobilService;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("porsches",porscheService.findAll()); 
        model.addAttribute("mobil",new Mobil()); 
        return "porsche/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("porsche",new Porsche());
         model.addAttribute("mobils",mobilService.findAll()); 
        return "porsche/add";
    }

    @PostMapping("/save")
    public String save(Porsche porsche, Model model) {
        porscheService.addPorsche(porsche);
        return "redirect:/porsche"; // Jadi kembali ke halaman awal
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
       porscheService.deleteById(id);
        return "redirect:/porsche";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("porsche",porscheService.findById(id));
        model.addAttribute("mobils",mobilService.findAll()); 
        return "porsche/edit";
    }

    @PostMapping("/update")
    public String update(Porsche porsche, Model model) {
      porscheService.updatePorsche(porsche);
        return "redirect:/porsche"; // Jadi kembali ke halaman awal
    }
    
}