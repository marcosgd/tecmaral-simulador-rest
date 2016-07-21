package com.tecmaral.simulador.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author marcosgd
 * @since noviembre-2012
 */
public class DateUtils
{
	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	private DateUtils() {}
	
	private static SimpleDateFormat DATE_FORMAT_GMT;
	
	static
	{
		DATE_FORMAT_GMT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		DATE_FORMAT_GMT.setTimeZone(TimeZone.getTimeZone("GMT"));
	}
	
	public static String toGMTString(Date date)
	{
		String aux = null;
		if(date!=null) {
			aux = DATE_FORMAT_GMT.format(date);			
		}
		return aux;
	}
	
	public static boolean isInMonthInterval(Date fecha, Integer minusMonth, Integer plusMonth)
	{		
		if(minusMonth!=null || plusMonth!=null)
		{
			Date currentDate = new Date();
			Calendar calendar = Calendar.getInstance();						
			boolean bottomOK = true;
			boolean topOK = true;
			if(minusMonth!=null)
			{
				calendar.setTime(fecha);
				calendar.add(Calendar.MONTH, minusMonth);
				bottomOK = calendar.getTime().after(currentDate);
			}
			if(plusMonth!=null)
			{
				calendar.setTime(currentDate);
				calendar.add(Calendar.MONTH, plusMonth);
				bottomOK = calendar.getTime().after(fecha);
			}
			return bottomOK && topOK;
		}
		
		return true;
	}
	
	public static Date toDate(String fecha, String pattern)
	{
		Date date = null;
		try
		{
			if(fecha!=null && fecha.trim().length()>0 && pattern!=null && pattern.trim().length()>0)
			{
				DateFormat df = new SimpleDateFormat(pattern);
				date = df.parse(fecha);
			}
		}
		catch(Exception e)
		{
			logger.error("Error en el parseo de la fecha " + fecha + " con el patrón " + pattern);
		}
		return date;
	}
	
	public static Date toDate(String fecha, DateFormat df)
	{
		Date date = null;
		try
		{
			if(df!=null && fecha!=null && fecha.trim().length()>0) {
				date = df.parse(fecha);
			}
		}
		catch (Exception e)
		{
			logger.error("Error en el parseo de la fecha " + fecha + " con " + df);
		}
		return date;
	}
	
	public static String toString(Date date, String pattern)
	{
		String fecha = null;
		try
		{
			if(date!=null && pattern!=null && pattern.trim().length()>0)
			{
				DateFormat df = new SimpleDateFormat(pattern);
				fecha = df.format(date);
			}
		}
		catch(Exception e)
		{
			logger.error("Error al dar formato a la fecha: " + date);
		}
		return fecha;
	}
	
	public static String toString(String inDate, String inPattern, String outPattern)
	{
		Date date = toDate(inDate, inPattern);
		String outDate = toString(date, outPattern);
		return outDate;
	}
}
