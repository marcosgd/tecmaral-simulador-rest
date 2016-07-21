package com.tecmaral.simulador.servicios.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecmaral.simulador.servicios.model.movies.Film;

/**
 * @RestController Esta anotación de Spring MVC proporcionará superpoderes REST a la clase
 * @RequestMapping y el verbo HTTP correspondiente (GET, POST) se encargarán de representar los endpoints
 * @author mgonzalezdi
 *
 */

@RestController
@RequestMapping(value = "/films")
public class FilmsController implements FilmsService {

	private static final List<Film> DUMMY_FILMS = new ArrayList<Film>();
	
	static {
		DUMMY_FILMS.add(new Film("12 years a slave", 2013, "Steve McQueen"));
		DUMMY_FILMS.add(new Film("Argo", 2012, "Ben Affleck"));
		DUMMY_FILMS.add(new Film("The Artist", 2011, "Michel Hazanavicius"));
		DUMMY_FILMS.add(new Film("The King's speech", 2010, "Tom Hooper"));
		DUMMY_FILMS.add(new Film("The Hurt Locker", 2009, "Kathryn Bigelow"));
		DUMMY_FILMS.add(new Film("Slumdog Millionaire", 2008, "Danny Boyle"));
		DUMMY_FILMS.add(new Film("No Country for Old Men", 2007, "Joel y Ethan Coen"));
	}
	
	
	public List<Film> getFilms() {
		return DUMMY_FILMS;
	}
	
	//@RequestBody se utiliza para indicar que el objeto film vendrá en el cuerpo de la petición
	//@Valid se utiliza para lanzar las validaciones del estándar JSR 303 Bean Validation.
	public void addFilm(@RequestBody @Valid Film film) {
		DUMMY_FILMS.add(film);
	}
	
}