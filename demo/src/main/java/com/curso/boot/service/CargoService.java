package com.curso.boot.service;

import java.util.List;

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

	public List<Cargo> findAll() {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}

	public Cargo findById(Long id) {
		// TODO Auto-generated method stub
		return cargoRepository.findById(id);
	}

	public void update(Cargo cargo) {
		// TODO Auto-generated method stub
		cargoRepository.update(cargo);
	}
}
