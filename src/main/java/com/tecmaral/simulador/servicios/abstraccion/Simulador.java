package com.tecmaral.simulador.servicios.abstraccion;

import java.util.HashMap;
import java.util.Map;

public class Simulador {

	 private static final Map<String,Class> simuladores = new HashMap<String, Class>();

	 private static Simulador simulador= null;
	 private Simulador(){}
		
		 
	 
	 public Simulador getInstace(){
		 
		 if (this.simulador == null){
			 
			 this.simulador = new Simulador();
			 
		 }
		 
		 return this.simulador;
	 }
}
