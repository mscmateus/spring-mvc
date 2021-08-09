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

	public Departamento findById(Long id) {
		// TODO Auto-generated method stub
		return departamentoRepository.findById(id);
	}

	public void update(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoRepository.update(departamento);
	}

	public boolean hasCargos(Long id) {
		if(findById(id).getCargos().isEmpty())
			return false;
		return true;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		departamentoRepository.delete(id);
	}
}
