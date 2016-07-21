package com.tecmaral.simulador.servicios.model.facturas;

/*
 * Clase enumerada para describir los distintos subtipos de Factura
 * 
 * 
 */

public enum SubtipoFacturaEnum
{
	FACTURA(2, "Factura"), 
	FACTURA_CORTESIA(7, "Facturas de Cortesia") ;
	
	private int codigo;
	private String descripcion;

	private SubtipoFacturaEnum(int codigo, String descripcion)
	{
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
		
	public int getCodigo()
	{
		return this.codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getDescripcion()
	{
		return this.descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public static SubtipoFacturaEnum getSubtipoByCodigo(int codigo)
	{
		for (SubtipoFacturaEnum subtipo : SubtipoFacturaEnum.values())
		{
			if (subtipo.getCodigo() == codigo)
			{
				return subtipo;
			}
		}
		return null;
	}

	public static String getDescripcionByCodigo(int codigo)
	{
		SubtipoFacturaEnum subtipo = SubtipoFacturaEnum.getSubtipoByCodigo(codigo);
		return subtipo == null ? "" : subtipo.getDescripcion();
	}
	
	public boolean isFactura()
	{
		return this.codigo == SubtipoFacturaEnum.FACTURA.getCodigo();
	}


	
	/**
	 * Metodo de conveniencia definido para su uso en JSPs para la recuperacion
	 * de los literales de descripcion del subtipo.
	 * Esos literales se corresponden con el codigo del subtipo.
	 * 
	 * @return
	 */
	public String getCodigoString()
	{
		return String.valueOf(this.codigo);
	}
}
