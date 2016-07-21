package com.tecmaral.simulador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 


@Controller
public class AppController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "index";
    }
	
	
	@RequestMapping(value = "/facturacion", method = RequestMethod.GET)
    String facturacion() {
        return "facturacion";
    }
	
	
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
    String prueba() {
        return "prueba";
    }


	@RequestMapping(value = "/error", method = RequestMethod.GET)
    String error() {
        return "error";
    }
}

