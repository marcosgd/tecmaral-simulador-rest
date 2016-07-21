package com.tecmaral.simulador.servicios.abstraccion;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SerializationServiceJAXB implements SerializationService
{
	private static final Logger LOG = LoggerFactory.getLogger(SerializationServiceJAXB.class);
	
	//Reutilizamos los marshaller y unmarshaller
	private Map<String,Marshaller> marshallerMap = new Hashtable<String,Marshaller>();
	private Map<String,Unmarshaller> unmarshallerMap = new Hashtable<String,Unmarshaller>();
	
	@Override
	public String toXml(Object o)
	{
		String xml = null;
		try
		{
			String key = o.getClass().getName();
			Marshaller marshaller = marshallerMap.get(key);
			if(marshaller==null)
			{
				JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
				marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshallerMap.put(key, marshaller);
			}
			
			StringWriter out = new StringWriter();			
			marshaller.marshal(o, out);
			xml = out.getBuffer().toString();
		}
		catch (Exception e)
		{
			LOG.error("SerializationServiceJAXB:toXml: Error en al convertir el objeto en xml", e);
		}	 
		return xml;
	}

	@Override
	public Object toObject(Class classType, String xml)
	{
		Object o = null;
		try
		{
			String key = classType.getName();
			Unmarshaller unmarshaller = unmarshallerMap.get(key);
			if(unmarshaller==null)
			{
				JAXBContext jaxbContext = JAXBContext.newInstance(classType);
				unmarshaller = jaxbContext.createUnmarshaller();
				unmarshallerMap.put(key, unmarshaller);
			}
			
			StringReader reader = new StringReader(xml);
			o = unmarshaller.unmarshal(reader);
		}
		catch(Exception e)
		{
			LOG.error("SerializationServiceJAXB:toObject: Error en al convertir el xml en un objeto", e);
		}
		return o;
	}
	
//	private static Object toObject(SerializationService service, String xml) throws Exception
//	{	
//		Object o = service.toObject(com.indra.vodafone.common.domain.amdocs.login.tibco.criticalflow.b2c.response.Peticion.class, xml);
//		com.indra.vodafone.common.domain.amdocs.login.tibco.criticalflow.b2c.response.Peticion peticion = (com.indra.vodafone.common.domain.amdocs.login.tibco.criticalflow.b2c.response.Peticion)o;
//		return peticion;
//	}
	
	private static String toXml(SerializationService service, Object o)
	{
		String xml = service.toXml(o);
		return xml;
	}
	
	
}
