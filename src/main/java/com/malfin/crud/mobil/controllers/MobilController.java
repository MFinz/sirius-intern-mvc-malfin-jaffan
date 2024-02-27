package com.malfin.crud.mobil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.malfin.crud.mobil.entity.DetailMobil;
import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.MobilAdapter;
import com.malfin.crud.mobil.service.DetailMobilService;
import com.malfin.crud.mobil.service.MobilService;
import com.malfin.crud.mobil.service.WarnaService;

@Controller
@RequestMapping("/mobil")
public class MobilController {

  @Autowired
  private DetailMobilService detailmobilService;

  @Autowired
  private MobilService mobilService;

  @Autowired
  private WarnaService warnaService;

  @RequestMapping("/view")
  public ModelAndView view() {
    ModelAndView modelAndView = new ModelAndView("mobil/mobilView");
    modelAndView.addObject("mobils", mobilService.findAll());
    return modelAndView;
  }

  @GetMapping("/view/{id}")
  public ModelAndView showDetailMobil(@PathVariable Integer id) {
    ModelAndView modelAndView = new ModelAndView("mobil/mobilDetail");
    Mobil mobil = mobilService.findById(id);
    List<DetailMobil> detailMobils = detailmobilService.findByMobilId(id);

    modelAndView.addObject("mobil", mobil);
    modelAndView.addObject("detailMobils", detailMobils);

    return modelAndView;
  }

  @GetMapping("/add")
  public ModelAndView add() {
    ModelAndView modelAndView = new ModelAndView("mobil/mobilAdd");
    modelAndView.addObject("mobilAdapter", new MobilAdapter());
    modelAndView.addObject("warnas", warnaService.findAll());
    modelAndView.addObject("detailmobil", new DetailMobil());
    return modelAndView;
  }

  @PostMapping("/save")
  public ModelAndView save(
    @ModelAttribute("mobilAdapter") MobilAdapter mobilAdapter,
    RedirectAttributes redirectAttributes
  ) throws Exception {
    try {
      mobilService.addMobil(mobilAdapter);
    } 
    catch (Exception e) {
      ModelAndView modelAndView = new ModelAndView("mobil/mobilAdd");
      modelAndView.addObject("error", e.getMessage());
      return modelAndView;
    }

    redirectAttributes.addFlashAttribute(
      "successMessage",
      "Data Mobil berhasil ditambahkan!"
    );
    ModelAndView modelAndView = new ModelAndView("redirect:/mobil/view");
    return modelAndView; // Jadi kembali ke halaman awal
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(
    @PathVariable("id") int id,
    RedirectAttributes redirectAttributes
  ) {
    mobilService.deleteById(id);
    ModelAndView modelAndView = new ModelAndView("redirect:/mobil/view");
    redirectAttributes.addFlashAttribute(
      "deleteMessage",
      "Data Mobil berhasil dihapus!"
    );
    return modelAndView;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") int id) {
    ModelAndView modelAndView = new ModelAndView("mobil/mobilEdit");

    Mobil mobil = mobilService.findById(id);
    MobilAdapter mobilAdapter = new MobilAdapter(mobil);
    modelAndView.addObject("mobilAdapter", mobilAdapter);
    modelAndView.addObject("warnas", warnaService.findAll());

    return modelAndView;
  }

  @PostMapping("/update")
  public ModelAndView update(
    @ModelAttribute("mobilAdapter") MobilAdapter mobilAdapter,
    Model model,
    RedirectAttributes redirectAttributes
  ) throws Exception {
    try {
      mobilService.updateMobil(mobilAdapter);
    } catch (Exception e) {
      ModelAndView modelAndView = new ModelAndView("mobil/mobilEdit");
      modelAndView.addObject("error", e.getMessage());
      return modelAndView;
    }

    redirectAttributes.addFlashAttribute(
      "successMessage",
      "Data Mobil berhasil diupdate!"
    );
    ModelAndView modelAndView = new ModelAndView("redirect:/mobil/view");
    return modelAndView;
  }
}
