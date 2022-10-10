package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import mapsObject.MapObjectDatePicker;
import utilidadesExcel.ReadExcelFile;

public class PageObjectDatePicker extends MapObjectDatePicker{

	public PageObjectDatePicker(WebDriver driver) 
	{
		super(driver);
	}
	
	public void sistemaDate(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//METODO FECHA DEL SISTEMA
		//REALIZAR SCROLL DOWN	
		scrollDown(210, 1);
		//INGRESAR A LA SECCION DATA PICKER
		click(btnDatePicker, rutaCarpeta);
		
		//LLAMADO FECHA DEL SISTEMA
		String fecha = fechaHoraToolsQa();
		String[] fechaV = fecha.split("-");
		//PARCEO DE VALORES 
		int mes  = Integer.parseInt(fechaV[0]);
		int dia  = Integer.parseInt(fechaV[1]);
		int anno  = Integer.parseInt(fechaV[2]);
		int hora = Integer.parseInt(fechaV[3]);
		int min = Integer.parseInt(fechaV[4]);
		int seg = Integer.parseInt(fechaV[5]);
		
		mes =mes-1;
		dia =dia-1;
		anno = anno-1;
		hora = hora -1;
		
		//CREAR VARIABLES PARA CADA IMPUT
		String fechaMenor = mes+"/"+dia+"/"+anno;
		String fechaMenorHora = mes+"/"+dia+"/"+anno+" "+hora+":"+min+":"+seg;
		
		//ENTRAR AL TXT 
		click(txtSelectDate, rutaCarpeta);
		tiempoEspera(1000);
		//BORRAR CONTENIDO DE SELECT DATA
		borrartxt(txtSelectDate, rutaCarpeta);
		//ENVIAR IMPUT EN SELEC DATA
		sendKey(fechaMenor,txtSelectDate, rutaCarpeta);
		
		// ENTRAR EN DATE AND TIME DIA ANTERIOR Y # HORA ANTERIOR
		click(txtDataAndTime,rutaCarpeta);
		tiempoEspera(1000);
		borrartxt(txtDataAndTime, rutaCarpeta);
		sendKey(fechaMenorHora,txtDataAndTime, rutaCarpeta);
		click(textDataAndTime,rutaCarpeta);
		tiempoEspera(1000);
	}
}
