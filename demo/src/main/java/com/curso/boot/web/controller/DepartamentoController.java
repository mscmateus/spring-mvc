package com.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.curso.boot.model.Departamento;
import com.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping(path="/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;	

	@RequestMapping(path="/listar")
	public String list(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.findAll());
		return "/departamento/lista";
	}
	
	@RequestMapping(path="/cadastrar") 
	public String register(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String save(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "departamento/cadastro";
		
		departamentoService.save(departamento);
		attr.addFlashAttribute("success", "Departamento cadastrado com sucesso!");
		return "redirect:/departamentos/listar";
	}
	
	@RequestMapping(path="/editar/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", departamentoService.findById(id));
		return "/departamento/cadastro";
	}
	
	@RequestMapping(path="/atualizar", method=RequestMethod.POST)
	public String update(@Valid Departamento departamento, BindingResult result ,RedirectAttributes attr) {
		if(result.hasErrors())
			return "departamento/cadastro";
		
		departamentoService.update(departamento);
		attr.addFlashAttribute("success", "Departamento atualizado com sucesso!");
		return "redirect:/departamentos/listar";
	}
	
	@RequestMapping(path="/excluir/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		if(departamentoService.hasCargos(id))
			model.addAttribute("fail", "Departamento não pode ser removido!");
		else {
			departamentoService.delete(id);
			model.addAttribute("success", "Departamento removido com sucesso!");
		}
		return list(model);
	}
}
