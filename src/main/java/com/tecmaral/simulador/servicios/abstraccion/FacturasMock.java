package com.tecmaral.simulador.servicios.abstraccion;

import java.util.ArrayList;
import java.util.List;

import com.tecmaral.simulador.excepciones.ApplicationException;
import com.tecmaral.simulador.servicios.model.facturas.Factura;

public  final  class FacturasMock {


private static final List<Factura> DUMMY_FACTURAS = new ArrayList<Factura>();
	
	static {
		DUMMY_FACTURAS.add(new Factura("1d", "100", "01201501"));
		DUMMY_FACTURAS.add(new Factura("2d", "200", "02201501"));
		DUMMY_FACTURAS.add(new Factura("3d", "300", "03201501"));
		DUMMY_FACTURAS.add(new Factura("4d", "400", "04201501"));
		DUMMY_FACTURAS.add(new Factura("5d", "500", "05201501"));
		DUMMY_FACTURAS.add(new Factura("6d", "600", "06201501"));
		DUMMY_FACTURAS.add(new Factura("7d", "700", "07201501"));
		DUMMY_FACTURAS.add(new Factura("8d", "800", "08201501"));
		DUMMY_FACTURAS.add(new Factura("9d", "900", "09201501"));
		DUMMY_FACTURAS.add(new Factura("10d","100","10201501"));
		DUMMY_FACTURAS.add(new Factura("11d","110","11201501"));
		DUMMY_FACTURAS.add(new Factura("12d","120","12201501"));
	}
	
	


	
	public static List<Factura> getFacturas() throws ApplicationException {
		
		return DUMMY_FACTURAS;
		
	}

	public static String obtenerDocumento(String documentId, String usuario,
				String password, String buzon) throws ApplicationException {

	 return "documentoId";
	 
	}
}
