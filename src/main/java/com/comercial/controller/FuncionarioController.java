package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Funcionario;
import com.comercial.domain.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController 
{
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Funcionario funcionario)
	{
		return new ModelAndView("funcionarios/cadastro");
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Funcionario funcionario, RedirectAttributes attributes)
	{
		funcionarioService.salvar(funcionario);
		attributes.addFlashAttribute("mensagem", "Funcionario cadastrado com sucesso");
		return new ModelAndView("redirect:/funcionarios/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("funcionarios/pesquisa").addObject("funcionarios", funcionarioService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Funcionario funcionario, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("funcionario", funcionario);
		return new ModelAndView("redirect:/funcionarios/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		funcionarioService.remover(codigo);
		return new ModelAndView("redirect:/funcionarios");
	}

}


