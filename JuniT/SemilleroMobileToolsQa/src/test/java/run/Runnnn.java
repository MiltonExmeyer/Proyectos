package run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;


import pagesObjects.PageObjectGoogleChrome;
import pagesObjects.PageObjectQaAlerts;
import pagesObjects.PageObjectQaWidgets;
import utilidades.MyScreenRecorder;
import utilidades.ReadExcelFile;
import utilidades.WriteExcelFile;

public class Runnnn {

	//CREAR OBJETO TIPO DRIVER
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	
	PageObjectGoogleChrome google;
	PageObjectQaWidgets QaWidgets;
	PageObjectQaAlerts QaAlerts;
	
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClaseBase claseBase;
	
	//CREAR ANOTACIONES JUNIT
	@Before
	public void sepUp() throws IOException
	{
	
	//INSTANCIAR LA CLASE PAGSOBJECTS
		propiedades = new Properties();
	//INSTANCIAR CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		
	//CREAR VARIABLE TIPO INPUT STRING
		InputStream entrada = null;
	//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/propiedadesData");
			propiedades.load(entrada);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	

@SuppressWarnings("unchecked")
@Test
//INGRESAR GOOGLE APP, IR A DEMO QA Y REALIZAR TODAS LAS ALERTS
	public void demoQaAlerts() throws Exception 
	{
		driver=ClaseBase.appiumDriverConnetion(propiedades, leer, "capability", 1, 1);
		if (leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "test", 1, 1).equals("Si"))
		{
		claseBase = new ClaseBase (driver);
		google =new PageObjectGoogleChrome(driver);
		QaAlerts= new PageObjectQaAlerts (driver);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		
		//INICIAR GRABACION EN VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		google.buscador(propiedades, leer, rutaCarpeta);
		QaAlerts.alertas(propiedades, leer, rutaCarpeta);
		
		//FINALIZAR GRABACION DE VIDEO
		MyScreenRecorder.stopRecording();
		
		
		}
		else {
			System.out.println("La automatizacion no se ejecutara para Alerts, revise los valores del excel... ");
		}
	} 


@SuppressWarnings("unchecked")
@Test
//INGRESAR GOOGLE APP, DEMOQA E INGRESAR DATA EN EL AREA DE WIDGETS
public void demoQaWidgets() throws Exception 
{
	driver=ClaseBase.appiumDriverConnetion(propiedades, leer, "capability", 1, 1);
	if (leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "test", 2, 1).equals("Si"))
	{
	claseBase = new ClaseBase (driver);
	google =new PageObjectGoogleChrome(driver);
	QaWidgets = new PageObjectQaWidgets(driver);
	//OBTENER EL NOMBRE DEL METODO A EJECUTAR
	String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
	//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
	File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
	
	//INICIAR GRABACION EN VIDEO
	MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
	//ACCEDER AL METODO DE PRUEBA INICIAL
	google.buscador(propiedades, leer, rutaCarpeta);
	QaWidgets.Widgets(propiedades, leer, rutaCarpeta);
	//FINALIZAR GRABACION DE VIDEO
	MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
	
	}
	else {
		System.out.println("La automatizacion no se ejecutara para Widgets, revise los valores del excel...");
	}
} 



@After
	public void cerrar()
	{
	//CERRAR PROCESO
	driver.quit();
	}

}
