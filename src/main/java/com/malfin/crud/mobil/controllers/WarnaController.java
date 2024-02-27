package com.malfin.crud.mobil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.malfin.crud.mobil.entity.Warna;
import com.malfin.crud.mobil.service.WarnaService;

@Controller
@RequestMapping("/warna")
public class WarnaController {

  @Autowired
  private WarnaService warnaService;

  @RequestMapping("/view")
  public ModelAndView view() {
    ModelAndView modelAndView = new ModelAndView("warna/warnaView");
    modelAndView.addObject("warnas", warnaService.findAll());
    return modelAndView;
  }

  @GetMapping("/add")
  public ModelAndView add() {
    ModelAndView modelAndView = new ModelAndView("warna/warnaAdd");
    modelAndView.addObject("warna", new Warna());
    return modelAndView;
  }

  @PostMapping("/save")
  public ModelAndView save(Warna warna, RedirectAttributes redirectAttributes) {
    if (warnaService.existsBynamaWarna(warna.getNamaWarna())) {
      ModelAndView modelAndView = new ModelAndView("redirect:/warna/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Warna dengan nama yang sama sudah ada!"
      );
      return modelAndView;
    } else {
      warnaService.addWarna(warna);
      ModelAndView modelAndView = new ModelAndView("redirect:/warna/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Warna berhasil ditambahkan!"
      );
      return modelAndView;
    }
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(
    @PathVariable("id") int id,
    RedirectAttributes redirectAttributes
  ) {
    warnaService.deleteById(id);
    ModelAndView modelAndView = new ModelAndView("redirect:/warna/view");
    redirectAttributes.addFlashAttribute(
      "deleteMessage",
      "Data Warna berhasil dihapus!"
    );
    return modelAndView;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable("id") int id, Model model) {
    ModelAndView modelAndView = new ModelAndView("warna/warnaEdit");
    modelAndView.addObject("warna", warnaService.findById(id));
    return modelAndView;
  }

  @PostMapping("/update")
  public ModelAndView update(
    Warna warna,
    RedirectAttributes redirectAttributes
  ) {
    if (
      warnaService.existsById(warna.getId()) &&
      warnaService.existsBynamaWarna(warna.getNamaWarna())
    ) {
      ModelAndView modelAndView = new ModelAndView("redirect:/warna/view");
      redirectAttributes.addFlashAttribute(
        "errorMessage",
        "Warna dengan nama yang sama sudah ada!"
      );
      return modelAndView;
    } else {
      warnaService.updateWarna(warna);
      ModelAndView modelAndView = new ModelAndView("redirect:/warna/view");
      redirectAttributes.addFlashAttribute(
        "successMessage",
        "Data Warna berhasil diupdate!"
      );
      return modelAndView;
    }
  }
}
