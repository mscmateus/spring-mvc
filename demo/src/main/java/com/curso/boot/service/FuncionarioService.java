package com.curso.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public void delete(Long id) {
		// TODO Auto-generated method stub
		funcionarioRepository.delete(id);
	}

	public List<Funcionario> findByNome(String nome) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByNome(nome);
	}

	public List<Funcionario> findByCardoId(Long id) {
		// TODO Auto-generated method stub
		return funcionarioRepository.findByCargoId(id);
	}

	public List<Funcionario> findByDatas(LocalDate entrada, LocalDate saida) {
		// TODO Auto-generated method stub
		if(entrada != null && saida != null)
			return funcionarioRepository.findByDataEntradaDataSaida(entrada, saida);
		else if(entrada != null)
			return funcionarioRepository.findByDataEntrada(entrada);
		else if(saida != null)
			return funcionarioRepository.findByDataSaida(saida);
		
		return  new ArrayList<>();
	}
}
