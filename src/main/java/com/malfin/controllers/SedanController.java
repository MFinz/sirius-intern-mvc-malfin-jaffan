package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.Sedan;
import com.malfin.entity.Mobil;
import com.malfin.service.SedanService;
import com.malfin.service.MobilService;

@Controller
@RequestMapping("/sedan")

public class SedanController {
    @Autowired
    private SedanService sedanService;

    @Autowired
    private MobilService mobilService;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("sedans",sedanService.findAll()); 
        model.addAttribute("mobil",new Mobil()); 
        return "sedan/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("sedan",new Sedan());
        model.addAttribute("mobils",mobilService.findAll()); 
        return "sedan/add";
    }

    @PostMapping("/save")
    public String save(Sedan sedan, Model model) {
        sedanService.addSedan(sedan);
        return "redirect:/sedan"; // Jadi kembali ke halaman awal
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
       sedanService.deleteById(id);
        return "redirect:/sedan";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("sedan",sedanService.findById(id));
        model.addAttribute("mobils",mobilService.findAll()); 
        return "sedan/edit";
    }

    @PostMapping("/update")
    public String update(Sedan sedan, Model model) {
      sedanService.updateSedan(sedan);
        return "redirect:/sedan"; // Jadi kembali ke halaman awal
    }
    
}
