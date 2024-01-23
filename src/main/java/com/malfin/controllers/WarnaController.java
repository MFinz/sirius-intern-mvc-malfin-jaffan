package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
