package com.curso.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.model.Funcionario;
import com.curso.boot.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public void save(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionarioRepository.save(funcionario);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return funcionarioRepository.findAll();
	}
}
