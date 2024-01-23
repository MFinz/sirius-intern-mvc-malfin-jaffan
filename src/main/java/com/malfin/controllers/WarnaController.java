package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.Warna;
import com.malfin.service.WarnaService;

@Controller
@RequestMapping("/warna")
public class WarnaController {
    @Autowired
    private WarnaService warnaService;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("warnas",warnaService.findAll()); 
        return "warna/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("warna",new Warna());
        return "warna/add";
    }

    @PostMapping("/save")
    public String save(Warna warna, Model model) {
        warnaService.addWarna(warna);
        return "redirect:/warna"; // Jadi kembali ke halaman awal
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
       warnaService.deleteById(id);
        return "redirect:/warna";
    }

     @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("warna",warnaService.findById(id));
        return "warna/edit";
    }

    @PostMapping("/update")
    public String update(Warna warna, Model model) {
      warnaService.updateWarna(warna);
        return "redirect:/warna"; // Jadi kembali ke halaman awal
    }
}
