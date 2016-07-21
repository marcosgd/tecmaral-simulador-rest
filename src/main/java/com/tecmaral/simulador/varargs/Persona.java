package com.tecmaral.simulador.varargs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persona {
	private String nombre;
	private List<Factura> facturas= new ArrayList();
	public String getNombre() {
	return nombre;
	}
	 
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	 
	
	public void addFactura(Factura ... variasFacturas){
//	for(Factura f:variasFacturas) {
//		facturas.add(f);
//		}
	
	  Collections.addAll(facturas, variasFacturas);
	}

	@Override
	public String toString() {
		StringBuffer sb= new StringBuffer();
		for(Factura f:facturas) {
			sb.append("(Numero:"+f.getNumero()+")");
		}
	
		return "Persona [nombre=" + nombre + ", facturas=" + sb.toString() + "]";
	}
	
	
}
