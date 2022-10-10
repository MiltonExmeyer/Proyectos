package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectQaWidgets;
import utilidades.ReadExcelFile;

public class PageObjectQaWidgets extends MapObjectQaWidgets{

	public PageObjectQaWidgets(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void Widgets(Properties propiedades,ReadExcelFile leer, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//SCROLL A BTN WINDGETS
		scrollVertical(rutaCarpeta, 361, 1219, 400, 3);
		tiempoEspera(1000);
		//BTN WIDGETS
		clickTime(btnWidgets, rutaCarpeta, 1);
		//BTN DATA
		clickTime(btnDate,rutaCarpeta,1);

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
		
		//BORRAR EL CONTENIDO TXT
		borrartxt(txtFecha, rutaCarpeta);
		tiempoEspera(1000);
		//ENVIAR PRIMER IMPUT
		sendKey(fechaMenor,txtFecha, rutaCarpeta);
		tiempoEspera(2000);
		
		//BORRAR CONTENIDO DEL TXT
		borrartxt(txtFechaData,rutaCarpeta);
		//ENVIAR SEGUNDO IMPUT
		sendKey(fechaMenorHora,txtFechaData, rutaCarpeta);
		tiempoEspera(3000);
		
	}
}
