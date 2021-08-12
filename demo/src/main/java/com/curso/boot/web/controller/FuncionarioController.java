package com.curso.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
	public String save(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "funcionario/cadastro";
		
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
	public String updtate(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors())
			return "funcionario/cadastro";
		
		funcionarioService.update(funcionario);
		attr.addFlashAttribute("success", "Funcionario atualizado com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@RequestMapping(path="/excluir/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		funcionarioService.delete(id);
		model.addAttribute("success", "Funcionario removido com sucesso!");	
		return list(model);
	}
	
	@RequestMapping(path="/buscar/nome", method=RequestMethod.GET)
	public String getByNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByNome(nome));
		return "funcionario/lista";
	}
	
	@RequestMapping(path="/buscar/cargo", method=RequestMethod.GET)
	public String getByCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByCardoId(id));
		return "funcionario/lista";
	}
	
	@RequestMapping(path="/buscar/data", method = RequestMethod.GET)
	public String getByDatas(@RequestParam(name = "entrada", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate entrada,
							@RequestParam(name = "saida", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate saida,
							ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByDatas(entrada, saida));
		return "funcionario/lista";
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
