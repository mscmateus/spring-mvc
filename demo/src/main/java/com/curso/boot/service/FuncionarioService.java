package com.curso.boot.service;

import java.util.List;

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

	public List<Funcionario> findAll() {
		// TODO Auto-generated method stub
		return funcionarioRepository.findAll();
	}

	public Funcionario findById(Long id) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findById(id);
	}

	public void update(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionarioRepository.update(funcionario);
	}
}
