package com.comercial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Voo;
import com.comercial.domain.service.CompanhiaAereaService;
import com.comercial.domain.service.VooService;



@Controller
@RequestMapping("/voos")
public class VooController 
{
	@Autowired
	private VooService vooService;
	@Autowired
	private CompanhiaAereaService aeronaveService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Voo voo)
	{
		return new ModelAndView("voos/cadastro").addObject("aeronaves",aeronaveService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Voo voo, RedirectAttributes attributes)
	{
		vooService.salvar(voo);
		attributes.addFlashAttribute("mensagem", String.format("Voo da data %s cadastrado com sucesso", voo.getData()));
		return new ModelAndView("redirect:/voos/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("voos/pesquisa").addObject("voos", vooService.listar());
		
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Voo voo, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("voo", voo);
		return new ModelAndView("redirect:/voos/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		vooService.remove(codigo);
		return new ModelAndView("redirect:/voos");
	}
	
	

}

