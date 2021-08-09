package com.curso.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.model.Cargo;
import com.curso.boot.repository.CargoRepository;

@Service
@Transactional
public class CargoService {
	@Autowired
	private CargoRepository cargoRepository;

	public void save(Cargo cargo) {
		// TODO Auto-generated method stub
		cargoRepository.save(cargo);
	}

	public Object findAll() {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}
}
