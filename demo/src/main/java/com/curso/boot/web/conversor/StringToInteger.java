package com.curso.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		source = source.trim();
		
		if(source.matches("[0-9]+"))
			return Integer.valueOf(source);
		return null;
	}

}