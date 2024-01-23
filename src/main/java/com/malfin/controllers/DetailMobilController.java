package com.malfin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.service.DetailMobilService;


@Controller
@RequestMapping("/detailmobil")
public class DetailMobilController {
    @Autowired
    private DetailMobilService detailmobil;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("detailmobils",detailmobil.findAll()); 
        return "detailmobil/index";
    }
    
}
