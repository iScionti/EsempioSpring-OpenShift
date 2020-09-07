package com.academy.contatti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academy.contatti.model.Contatto;
import com.academy.contatti.service.ContattiService;
import com.academy.contatti.service.StatService;

@Controller
public class ContattiController {
	@Autowired
	private ContattiService contattiService;
	
	@Autowired
	private StatService statservice;
	
	@RequestMapping(value="/",method= RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		List<Contatto> listaContatti = contattiService.getAll();
		mv.addObject("listaContatti",listaContatti);
		mv.addObject("contatto",new Contatto());
		return mv;
	}
	
	@RequestMapping(value="/",method= RequestMethod.POST)
	public ModelAndView save(@Validated Contatto c, BindingResult br) {
		contattiService.saveContatto(c);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/edit/{id}",method= RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit_contatto");
		mv.addObject("contatto",contattiService.findById(id));
		return mv;
	}
	
	@RequestMapping(value="/deletetemp/{id}",method= RequestMethod.GET)
	public ModelAndView deleteTemp(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete_contatto");
		Optional<Contatto> contatto = contattiService.findById(id);
		mv.addObject("contatto", contatto.get());
		return mv;
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	public ModelAndView delete(@Validated Contatto c, BindingResult br) {
		contattiService.deleteContatto(c.getId());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/stat", method= RequestMethod.GET)
	public ModelAndView generaStat(@RequestParam String username) {
		Long conteggio = statservice.conteggioContatti();
		List<Contatto> listaContatti = statservice.findByUsername("%"+username+"%");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stat");
		mv.addObject("listaContatti", listaContatti);
		mv.addObject("conteggio", conteggio);
		return mv;
	}
}

