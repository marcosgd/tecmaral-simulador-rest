package com.tecmaral.simulador.servicios.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecmaral.simulador.servicios.model.movies.Film;

public interface FilmsService {

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Film> getFilms() ;
	
	@RequestMapping(method = RequestMethod.POST)
	public void addFilm(@RequestBody @Valid Film film);
	
	
	
}