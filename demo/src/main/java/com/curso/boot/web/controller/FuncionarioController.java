package com.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/funcionarios")
public class FuncionarioController {
	@RequestMapping(path="/listar")
	public String list() {
		return "/funcionario/lista";
	}
	
	@RequestMapping(path="/cadastrar")
	public String register() {
		return "/funcionario/cadastro";
	}
}
