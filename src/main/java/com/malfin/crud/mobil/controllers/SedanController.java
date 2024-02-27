package com.malfin.crud.mobil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.malfin.crud.mobil.entity.Sedan;
import com.malfin.crud.mobil.service.MobilService;
import com.malfin.crud.mobil.service.SedanService;

@Controller
@RequestMapping("/sedan")
public class SedanController {

  @Autowired
  private SedanService sedanService;

  @Autowired
  private MobilService mobilService;

  @RequestMapping("/view")
  public ModelAndView view() {
    ModelAndView modelAndView = new ModelAndView("sedan/sedanView");
    modelAndView.addObject("sedans", sedanService.findAll());
    return modelAndView;
  }

  @RequestMapping("/add")
  public ModelAndView add() {
    ModelAndView modelAndView = new ModelAndView("sedan/sedanAdd");
    modelAndView.addObject("sedan", new Sedan());
    modelAndView.addObject("mobils", mobilService.findAll());
    return modelAndView;
  }

  @PostMapping("/save")
  public ModelAndView save(Sedan sedan, RedirectAttributes redirectAttributes) {
    if (sedanService.existsByMobil(sedan.getMobil())) {
      ModelAndView modelAndView = new ModelAndView("redirect:/sedan/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Data Mobil sudah ada!"
      );
      return modelAndView;
    } else {
      sedanService.addSedan(sedan);
      ModelAndView modelAndView = new ModelAndView("redirect:/sedan/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Sedan berhasil ditambahkan!"
      );
      return modelAndView;
    }
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(
    @PathVariable("id") int id,
    RedirectAttributes redirectAttributes
  ) {
    sedanService.deleteById(id);
    ModelAndView modelAndView = new ModelAndView("redirect:/sedan/view");
    redirectAttributes.addFlashAttribute(
      "deleteMessage",
      "Data Sedan berhasil dihapus!"
    );
    return modelAndView;
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") int id) {
    ModelAndView modelAndView = new ModelAndView("sedan/sedanEdit");
    modelAndView.addObject("sedan", sedanService.findById(id));
    modelAndView.addObject("mobils", mobilService.findAll());
    return modelAndView;
  }

  @PostMapping("/update")
  public ModelAndView update(
    Sedan sedan,
    RedirectAttributes redirectAttributes
  ) {
    Sedan existingSedan = sedanService.findById(sedan.getId());

    // Cek apakah entitas dengan ID yang sama sudah ada di database dan ID mobilnya sama
    if (
      existingSedan != null &&
      existingSedan.getMobil().getId() == sedan.getMobil().getId()
    ) {
      sedanService.updateSedan(sedan);
      ModelAndView modelAndView = new ModelAndView("redirect:/sedan/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Sedan berhasil diupdate!"
      );
      return modelAndView;
    } else {
      ModelAndView modelAndView = new ModelAndView("redirect:/sedan/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Data Sedan sudah ada!"
      );
      return modelAndView;
    }
  }
}
