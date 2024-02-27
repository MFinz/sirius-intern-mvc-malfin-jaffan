package com.malfin.crud.mobil.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.malfin.crud.mobil.entity.DetailMobil;
import com.malfin.crud.mobil.service.DetailMobilService;

@Controller
// @RequestMapping("/detailmobil")
public class DetailMobilController {

  @Autowired
  private DetailMobilService detailmobilService;

  @GetMapping("/detailmobil/delete/{id}")
  public ModelAndView delete(
    @PathVariable("id") int id,
    RedirectAttributes redirectAttributes
  ) {
    Optional<DetailMobil> optionalDetailMobil = detailmobilService.findById(id);

    if (optionalDetailMobil.isPresent()) {
      DetailMobil detailMobil = optionalDetailMobil.get();

      int mobilId = detailMobil.getMobil().getId();

      detailmobilService.deleteById(id);

      redirectAttributes.addFlashAttribute(
        "deleteMessage",
        "Data Warna berhasil dihapus!"
      );
      ModelAndView modelAndView = new ModelAndView(
        "redirect:/mobil/edit/" + mobilId
      );

      return modelAndView;
    } else {
      ModelAndView modelAndView = new ModelAndView("redirect:/error");
      return modelAndView;
    }
  }
  //  @GetMapping("/detailmobil/edit/{id}")
  // public ModelAndView edit(@PathVariable("id") int id, Model model)
  // {
  //     ModelAndView modelAndView = new ModelAndView("mobil/mobilEdit");
  //     modelAndView.addObject("detailmobil",detailmobilService.findById(id));
  //     modelAndView.addObject("mobils",mobilService.findAll());
  //     modelAndView.addObject("warnas",warnaService.findAll());
  //     return modelAndView;
  // }

  // @PostMapping("/update")
  // public ModelAndView update(int id,DetailMobil detailmobil) {
  //     Optional<DetailMobil> optionalDetailMobil = detailmobilService.findById(id);

  //     if (optionalDetailMobil.isPresent()) {
  //         DetailMobil existingDetailMobil = optionalDetailMobil.get();
  //         existingDetailMobil.setMobil(detailmobil.getMobil());
  //         existingDetailMobil.setWarna(detailmobil.getWarna());
  //         existingDetailMobil.setTipeWarna(detailmobil.getTipeWarna());

  //         detailmobilService.updateDetailMobil(existingDetailMobil);
  //     }

  //     else
  //     {
  //         ModelAndView modelAndView = new ModelAndView("redirect:/error");
  //         return modelAndView;
  //     }

  //     ModelAndView modelAndView = new ModelAndView("mobil/mobilView");
  //     return modelAndView;
  // }
}
