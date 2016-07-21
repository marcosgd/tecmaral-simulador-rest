package com.tecmaral.simulador.servicios.model.facturas;

import java.io.Serializable;
import java.util.Date;

import com.tecmaral.simulador.servicios.model.facturas.SubtipoFacturaEnum;


public class Factura  implements Serializable
{
	
	/** */
	private static final long serialVersionUID = -4416835631926549780L;
	
	private String docId;
	private String importe;
	private SubtipoFacturaEnum subtipo;
	private Date fechaEmision;
	private Date fechaInicioFactura;
	private Date fechaFinFactura;
	private String numeroFactura;
	private String nombreContrato;
	private String fechaEmisionString;
	
	//2013-04-26 itorrev
	// se anyade un nuevo campo, tipo donde se almacena el formato del fichero
	// para su recuperacion ya que debido a la inclusion de contratos y facturas
	// de terminales ahora aparte de pdf tambien pueden ser mp3 o tiff

	public Factura(){// default constructor
	};
	
    
	/**
	 * obten una factura
	 * @param docId
	 * @param importe
	 * @param numeroFactura
	 */
	public Factura(String docId,String importe,String numeroFactura){
    	this.docId=docId;
    	this.importe=importe;
    	this.numeroFactura=numeroFactura;
    } 
	private String formatoFichero;

	public String getDocId()
	{
		return this.docId;
	}

	public void setDocId(String docId)
	{
		this.docId = docId;
	}

	public String getImporte()
	{
		return this.importe;
	}

	public void setImporte(String importe)
	{
		this.importe = importe;
	}

	public SubtipoFacturaEnum getSubtipo()
	{
		return this.subtipo;
	}

	public void setSubtipo(SubtipoFacturaEnum subtipo)
	{
		this.subtipo = subtipo;
	}

	public Date getFechaEmision()
	{
		return this.fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision)
	{
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaInicioFactura()
	{
		return this.fechaInicioFactura;
	}

	public void setFechaInicioFactura(Date fechaInicioFactura)
	{
		this.fechaInicioFactura = fechaInicioFactura;
	}

	public Date getFechaFinFactura()
	{
		return this.fechaFinFactura;
	}

	public void setFechaFinFactura(Date fechaFinFactura)
	{
		this.fechaFinFactura = fechaFinFactura;
	}

	public String getNumeroFactura()
	{
		return this.numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura)
	{
		this.numeroFactura = numeroFactura;
	}

	public String getFormatoFichero()
	{
		return this.formatoFichero;
	}

	public void setFormatoFichero(String formatoFichero)
	{
		this.formatoFichero = formatoFichero;
	}

	public String getNombreContrato()
	{
		return nombreContrato;
	}

	public void setNombreContrato(String nombreContrato)
	{
		this.nombreContrato = nombreContrato;
	}

	public void setFechaEmisionString(String fechaEmisionString)
	{
		this.fechaEmisionString = fechaEmisionString;
	}

	public String getFechaEmisionString()
	{
		return fechaEmisionString;
	}


	@Override
	public String toString() {
		return "[Factura:docId=" + docId + ", importe=" + importe
				+ ", subtipo=" + subtipo + ", fechaEmision=" + fechaEmision
				+ ", fechaInicioFactura=" + fechaInicioFactura
				+ ", fechaFinFactura=" + fechaFinFactura + ", numeroFactura="
				+ numeroFactura + ", nombreContrato=" + nombreContrato
				+ ", fechaEmisionString=" + fechaEmisionString
				+ ", formatoFichero=" + formatoFichero + "]";
	}
	
	
}