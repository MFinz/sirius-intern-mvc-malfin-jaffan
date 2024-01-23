package com.malfin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.DetailMobil;
import com.malfin.entity.Mobil;
import com.malfin.service.DetailMobilService;
import com.malfin.service.MobilService;


@Controller
@RequestMapping("")

public class MobilController {
    
    @Autowired
    private MobilService mobilService;

    @Autowired
    private DetailMobilService detailmobil;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("mobils",mobilService.findAll()); 
        model.addAttribute("detailmobils", detailmobil.findAll());
        return "mobil/index";
    }

    @GetMapping("/{id}")
    public String showDetailMobil(@PathVariable Integer id, Model model) {
        Optional<Mobil> mobil = mobilService.findById(id);
        List<DetailMobil> detailMobils = detailmobil.findByMobilId(id);

        model.addAttribute("mobil", mobil.orElse(new Mobil())); // gunakan orElse untuk menghindari NPE
        model.addAttribute("detailMobils", detailMobils);

        return "mobil/detail"; // hanya mengembalikan bagian yang diinginkan dari HTML
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("mobil",new Mobil());
        return "mobil/add";
    }

    @PostMapping("/save")
    public String save(Mobil mobil, Model model) {
        mobilService.addMobil(mobil);
        return "redirect:/"; // Jadi kembali ke halaman awal
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
       mobilService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("mobil",mobilService.findById(id));
        return "mobil/edit";
    }

    @PostMapping("/update")
    public String update(Mobil mobil, Model model) {
      mobilService.updateMobil(mobil);
        return "redirect:/"; // Jadi kembali ke halaman awal
    }
    
}


