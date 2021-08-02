package com.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.curso.boot.model.Departamento;
import com.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping(path="/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;	

	@RequestMapping(path="/listar")
	public String list() {
		return "/departamento/lista";
	}
	
	@RequestMapping(path="/cadastrar") 
	public String register(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String save(Departamento departamento) {
		departamentoService.save(departamento);
		return "redirect:/departamentos/cadastro";
	}
}
