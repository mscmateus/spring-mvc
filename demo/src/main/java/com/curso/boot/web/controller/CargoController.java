package com.curso.boot.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.boot.model.Cargo;
import com.curso.boot.model.Departamento;
import com.curso.boot.service.CargoService;
import com.curso.boot.service.DepartamentoService;
import com.curso.boot.util.PaginacaoUtil;

@Controller
@RequestMapping(path="/cargos")
public class CargoController {
	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;
	
	@RequestMapping(path="/listar")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		int paginaAutual = page.orElse(1);
		
		PaginacaoUtil<Cargo> pageCargo = cargoService.buscaPorPagina(paginaAutual);
		
		model.addAttribute("pageCargo", pageCargo);
		return "/cargo/lista";
	}
	
	@RequestMapping(path="/cadastrar")
	public String register(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String save(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "cargo/cadastro";
		
		cargoService.save(cargo);
		attr.addFlashAttribute("success", "Cargo cadastrado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.findById(id));
		return "cargo/cadastro";
	}
	
	@RequestMapping(path="/atualizar", method=RequestMethod.POST)
	public String update(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "cargo/cadastro";
		
		cargoService.update(cargo);
		attr.addFlashAttribute("success", "Cargo atualizado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
	@RequestMapping(path="/excluir/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		if(cargoService.hasFuncionarios(id))
			model.addAttribute("fail", "Não é possível remover este Cargo!");
		else {
			cargoService.delete(id);
			model.addAttribute("success", "Cargo removido com sucesso!");
		}
		
		return "cargo/lista";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listDepartamentos() {
		return departamentoService.findAll();
	}
}