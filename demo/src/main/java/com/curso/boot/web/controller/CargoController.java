package com.curso.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/cargos")
public class CargoController {
	
	@RequestMapping(path="/listar")
	public String list() {
		return "/cargo/lista";
	}
	
	@RequestMapping(path="/cadastrar")
	public String register() {
		return "/cargo/cadastro";
	}
}