package com.malfin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malfin.entity.DetailMobil;
import com.malfin.entity.Mobil;
import com.malfin.entity.MobilAdapter;
import com.malfin.service.DetailMobilService;
import com.malfin.service.MobilService;
import com.malfin.service.WarnaService;


@Controller
@RequestMapping("")

public class MobilController {

    @Autowired
    private DetailMobilService detailmobilService;
    
    @Autowired
    private MobilService mobilService;

    @Autowired
    private WarnaService warnaService;

    @GetMapping
    public String Welcome(Model model)
    {
        // Melakukan sesuatu 
        model.addAttribute("mobils",mobilService.findAll()); 
        return "mobil/index";
    }

    @GetMapping("/{id}")
    public String showDetailMobil(@PathVariable Integer id, Model model) {
        Optional<Mobil> mobil = mobilService.findById(id);
        List<DetailMobil> detailMobils = detailmobilService.findByMobilId(id);

        model.addAttribute("mobil", mobil.orElse(new Mobil())); // gunakan orElse untuk menghindari NPE
        model.addAttribute("detailMobils", detailMobils);

        return "mobil/detail"; // hanya mengembalikan bagian yang diinginkan dari HTML
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("mobil",new Mobil());
        model.addAttribute("warnas",warnaService.findAll()); 
        model.addAttribute("detailmobil", new DetailMobil());
        return "mobil/add";
    }

    @PostMapping("/save")
    public String save(Mobil mobil, DetailMobil detailmobil) {
        mobilService.addMobil(mobil);
        detailmobil.setMobil(mobil);
        detailmobilService.addDetailMobil(detailmobil);
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
        Optional<Mobil> mobil = mobilService.findById(id);
        List<DetailMobil> detailMobils = detailmobilService.findByMobilId(id);
        MobilAdapter mobilAdapter = new MobilAdapter(mobil.orElse(new Mobil()), detailMobils);
        model.addAttribute("mobilAdapter", mobilAdapter);

        model.addAttribute("warnas",warnaService.findAll()); 
        model.addAttribute("detailmobil",detailmobilService.findById(id));
        detailmobilService.deleteById(id);

        return "mobil/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("mobilAdapter") MobilAdapter mobilAdapter, Model model) {
        Mobil mobil = mobilAdapter.getMobil();
        mobilService.updateMobil(mobil);
    return "redirect:/";
}
    
}


