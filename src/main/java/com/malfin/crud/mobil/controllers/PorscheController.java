package com.malfin.crud.mobil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.malfin.crud.mobil.entity.Porsche;
import com.malfin.crud.mobil.service.MobilService;
import com.malfin.crud.mobil.service.PorscheService;

@Controller
@RequestMapping("porsche")
public class PorscheController {

  @Autowired
  private PorscheService porscheService;

  @Autowired
  private MobilService mobilService;

  @RequestMapping("/view")
  public ModelAndView view() {
    ModelAndView modelAndView = new ModelAndView("porsche/porscheView");
    modelAndView.addObject("porsches", porscheService.findAll());
    return modelAndView;
  }

  @GetMapping("/add")
  public ModelAndView add() {
    ModelAndView modelAndView = new ModelAndView("porsche/porscheAdd");
    modelAndView.addObject("porsche", new Porsche());
    modelAndView.addObject("mobils", mobilService.findAll());
    return modelAndView;
  }

  @PostMapping("/save")
  public ModelAndView save(
    Porsche porsche,
    RedirectAttributes redirectAttributes
  ) {
    if (porscheService.existsByMobil(porsche.getMobil())) {
      ModelAndView modelAndView = new ModelAndView("redirect:/porsche/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Data Mobil sudah ada!"
      );
      return modelAndView;
    } else {
      porscheService.addPorsche(porsche);
      ModelAndView modelAndView = new ModelAndView("redirect:/porsche/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Porsche berhasil ditambahkan!"
      );
      return modelAndView; // Jadi kembali ke halaman awal
    }
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(
    @PathVariable("id") int id,
    RedirectAttributes redirectAttributes
  ) {
    porscheService.deleteById(id);
    ModelAndView modelAndView = new ModelAndView("redirect:/porsche/view");
    redirectAttributes.addFlashAttribute(
      "deleteMessage",
      "Data Porsche berhasil dihapus!"
    );
    return modelAndView;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") int id) {
    ModelAndView modelAndView = new ModelAndView("porsche/porscheEdit");
    modelAndView.addObject("porsche", porscheService.findById(id));
    modelAndView.addObject("mobils", mobilService.findAll());
    return modelAndView;
  }

  @PostMapping("/update")
  public ModelAndView update(
    Porsche porsche,
    RedirectAttributes redirectAttributes
  ) {
    Porsche existingPorsche = porscheService.findById(porsche.getId());

    if (
      existingPorsche != null &&
      existingPorsche.getMobil().getId() == porsche.getMobil().getId()
    ) {
      porscheService.updatePorsche(porsche);
      ModelAndView modelAndView = new ModelAndView("redirect:/porsche/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Porsche berhasil diupdate!"
      );
      return modelAndView; // Jadi kembali ke halaman awal
    } else {
      ModelAndView modelAndView = new ModelAndView("redirect:/porsche/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Data Porsche sudah ada!"
      );
      return modelAndView;
    }
  }
}
