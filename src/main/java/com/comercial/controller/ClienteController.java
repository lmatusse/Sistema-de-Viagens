package com.comercial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comercial.domain.model.Cliente;
import com.comercial.domain.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController 
{
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Cliente cliente)
	{
		return new ModelAndView("clientes/cadastro");
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Cliente cliente, RedirectAttributes attributes)
	{
		clienteService.salvar(cliente);
		attributes.addFlashAttribute("mensagem", String.format("Cliente de codigo %s cadastrado com sucesso\nGuarde esse codigo para finalizacao da reserva", cliente.getCodigo()));
		return new ModelAndView("redirect:/bilhetes/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("clientes/pesquisa").addObject("clientes", clienteService.listar());
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Cliente cliente, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("cliente", cliente);
		return new ModelAndView("redirect:/clientes/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		clienteService.remover(codigo);
		return new ModelAndView("redirect:/clientes");
	}

}





