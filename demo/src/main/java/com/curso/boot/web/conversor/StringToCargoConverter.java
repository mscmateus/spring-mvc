package com.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.curso.boot.model.Cargo;
import com.curso.boot.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo> {
	@Autowired
	private CargoService cargoService;

	@Override
	public Cargo convert(String source) {
		if(source.isEmpty())
			return null;
		Long id = Long.valueOf(source);
		return cargoService.findById(id);
	}

}
