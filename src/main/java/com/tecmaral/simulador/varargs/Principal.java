package com.tecmaral.simulador.varargs;

public class Principal {

	public static void _main(String[] args) {
		 
		Factura f= new Factura (1);
		Factura f2= new Factura (2);
		Factura f3= new Factura (3);
		Persona p= new Persona(); 
		p.setNombre("Marcos");
		p.addFactura(f,f2,f3);
		System.out.print(p);
		
		}
}
