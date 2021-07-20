package com.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/departamentos")
public class DepartamentoController {

	@RequestMapping(path="/listar")
	public String list() {
		return "/departamento/lista";
	}
	
	@RequestMapping(path="/cadastrar") 
	public String register() {
		return "/departamento/cadastro";
	}
}
