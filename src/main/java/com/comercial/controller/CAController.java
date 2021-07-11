package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.CompanhiaAerea;
import com.comercial.domain.service.CompanhiaAereaService;
import com.comercial.domain.service.NacionalidadeService;




@Controller
@RequestMapping("/companhiaAereas")
public class CAController {
	@Autowired
	private CompanhiaAereaService companhiaAereaService;
	
	@Autowired
	private NacionalidadeService nacionalidadeService;
	
	@GetMapping("/novo")
	public ModelAndView novo(CompanhiaAerea companhiaAerea)
	{
		return new ModelAndView("companhiaAereas/cadastro").addObject("nacionalidades",nacionalidadeService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(CompanhiaAerea companhiaAerea, RedirectAttributes attributes)
	{
		companhiaAereaService.salvar(companhiaAerea);
		attributes.addFlashAttribute("mensagem", String.format("Companhia Aerea de nome %s cadastrado com sucesso", companhiaAerea.getNome()));
		return new ModelAndView("redirect:/companhiaAereas/novo");
	}
	@GetMapping("/pesquisarCa")
	public ModelAndView getCA(String nomePesquisa)
	{
		ModelAndView mv=new ModelAndView("companhiaAereas/pesquisa");
		mv.addObject("companhiaAereas", companhiaAereaService.pesquisarNome(nomePesquisa));
		return mv;
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("companhiaAereas/pesquisa").addObject("companhiaAereas", companhiaAereaService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") CompanhiaAerea companhiaAerea, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("companhiaAerea", companhiaAerea);
		return new ModelAndView("redirect:/companhiaAereas/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		companhiaAereaService.remove(codigo);
		return new ModelAndView("redirect:/companhiaAereas");
	}
	
	

}


