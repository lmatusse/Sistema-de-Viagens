package com.comercial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/acessos")
public class AcessoController {
	@GetMapping("/login")
public String login() {
	return "acesso/login";
}
}
