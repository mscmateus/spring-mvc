package com.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.boot.model.Cargo;
import com.curso.boot.model.Departamento;
import com.curso.boot.service.CargoService;
import com.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping(path="/cargos")
public class CargoController {
	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(path="/listar")
	public String list(ModelMap model) {
		model.addAttribute("cargos", cargoService.findAll());
		return "/cargo/lista";
	}
	
	@RequestMapping(path="/cadastrar")
	public String register(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String save(Cargo cargo, RedirectAttributes attr) {
		cargoService.save(cargo);
		attr.addFlashAttribute("success", "Cargo cadastrado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listDepartamentos() {
		return departamentoService.findAll();
	}
}