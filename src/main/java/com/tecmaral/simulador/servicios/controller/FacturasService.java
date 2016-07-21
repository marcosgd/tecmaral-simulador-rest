package com.tecmaral.simulador.servicios.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.model.facturas.Factura;


public interface FacturasService {

	
	
	@RequestMapping(method =	RequestMethod.GET,value = "/facturas")
	public List<Factura> getFacturas() throws ApplicationException;
	
	
	@RequestMapping(method =	RequestMethod.GET,value = "/facturas/ultima")
	public Factura getUltimaFactura() throws ApplicationException;

	
	@RequestMapping(value = "/facturas/downloads", method = RequestMethod.GET)
    public void  doDownload(HttpServletRequest request, HttpServletResponse response) throws ApplicationException;
     
			
	
}