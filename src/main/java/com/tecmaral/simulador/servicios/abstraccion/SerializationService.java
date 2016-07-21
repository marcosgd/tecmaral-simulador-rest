package com.tecmaral.simulador.servicios.abstraccion;


/**
 * 
 * @author mgonzalezdi
 *
 */
public interface SerializationService
{
	public String toXml(Object o);
	
	public Object toObject(Class classType, String xml);
}
