package com.capas.Tarea6LaboCapas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capas.Tarea6LaboCapas.domain.Contribuyente;
import com.capas.Tarea6LaboCapas.domain.Importancia;
import com.capas.Tarea6LaboCapas.service.ContribuyenteService;
import com.capas.Tarea6LaboCapas.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	ContribuyenteService contribuyenteService;
	
	@Autowired
	ImportanciaService importanciaService;
	
	@RequestMapping("/inicio")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente();
		List<Importancia>importancias = null;
		try {
			importancias = importanciaService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("importancias", importancias);
		mav.addObject("contribuyente",contribuyente);
		mav.setViewName("inicio");
		return mav;
	}
	
	@RequestMapping("/formulario")
	public ModelAndView init1(@Valid @ModelAttribute("contribuyentes") Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			List<Importancia> importancias = null;
			try {importancias = importanciaService.findAll();}
			catch(Exception e) {e.printStackTrace();}
			mav.setViewName("inicio");
		}else {
			contribuyenteService.save(contribuyente);
			mav.addObject("listado");
			mav.setViewName("exito");
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView init2() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente>contribuyentes = null;
		try {contribuyentes = contribuyenteService.findAll();}
		catch(Exception e) {e.printStackTrace();}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		return mav;
	}

}
