package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.DetailMobil;
import com.malfin.service.DetailMobilService;
import com.malfin.service.MobilService;
import com.malfin.service.WarnaService;


@Controller
@RequestMapping("/detailmobil")
public class DetailMobilController {
    @Autowired
    private DetailMobilService DetailMobilService;

    @Autowired
    private MobilService mobilService;

    @Autowired
    private WarnaService warnaService;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("detailmobils",DetailMobilService.findAll()); 
        return "detailmobil/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("detailmobil",new DetailMobil());
        model.addAttribute("mobils",mobilService.findAll()); 
        model.addAttribute("warnas",warnaService.findAll()); 
        return "detailmobil/add";
    }

    @PostMapping("/save")
    public String save(DetailMobil detailmobil, Model model) {
        DetailMobilService.addDetailMobil(detailmobil);
        return "redirect:/detailmobil"; // Jadi kembali ke halaman awal
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        DetailMobilService.deleteById(id);
        return "redirect:/detailmobil";
    }

     @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("detailmobil",DetailMobilService.findById(id));
        model.addAttribute("mobils",mobilService.findAll()); 
        model.addAttribute("warnas",warnaService.findAll()); 
        return "detailmobil/edit";
    }

    @PostMapping("/update")
    public String update(DetailMobil detailmobil, Model model) {
        DetailMobilService.updateDetailMobil(detailmobil);
        return "redirect:/detailmobil"; // Jadi kembali ke halaman awal
    }    
}
