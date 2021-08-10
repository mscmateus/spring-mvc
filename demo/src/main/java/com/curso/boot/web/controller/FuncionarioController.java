package com.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.boot.model.Cargo;
import com.curso.boot.model.Funcionario;
import com.curso.boot.model.UF;
import com.curso.boot.service.CargoService;
import com.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping(path="/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private CargoService cargoService;
	
	@RequestMapping(path="/listar", method=RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findAll());
		return "/funcionario/lista";
	}
	
	@RequestMapping(path="/cadastrar")
	public String register(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@RequestMapping(path="/salvar", method = RequestMethod.POST)
	public String save(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.save(funcionario);
		attr.addFlashAttribute("success", "Funcionario cadastrado com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.findById(id));
		return "funcionario/cadastro";
	}
	
	@RequestMapping(path="/atualizar", method=RequestMethod.POST)
	public String updtate(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.update(funcionario);
		attr.addFlashAttribute("success", "Funcionario atualizado com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listCargos(){
		return cargoService.findAll();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
