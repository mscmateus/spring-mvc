package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.boot.repository.DepartamentoRepository;
import com.curso.boot.model.Departamento;

@Service
public class DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
}
