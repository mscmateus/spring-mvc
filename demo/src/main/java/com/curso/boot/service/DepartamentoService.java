package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.repository.DepartamentoRepository;
import com.curso.boot.model.Departamento;

@Service
@Transactional
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;

	public void save(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoRepository.save(departamento);
	}

	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return departamentoRepository.findAll();
	}
}
