package com.curso.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.boot.repository.CargoRepository;

@Service
public class CargoService {
	@Autowired
	private CargoRepository cargoRepository;
}
