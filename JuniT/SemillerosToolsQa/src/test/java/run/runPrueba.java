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
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;
import pagesObjects.PageOBjectHome;
import pagesObjects.PageObjectAlertWindows;
import pagesObjects.PageObjectDatePicker;
import utilidadesExcel.MyScreenRecorder;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;
import utilidadesExcel.GenerarReportePdf;

public class runPrueba {

	//CREAR OBJETO TIPO DRIVER
	private WebDriver driver;
	PageObjectAlertWindows alerts;
	PageObjectDatePicker date;
	PageOBjectHome home;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClaseBase claseBase;
	GenerarReportePdf generarReportePdf;
	
	//CREAR ANOTACIONES JUNIT
@Before

	public void sepUp() throws IOException
	{
	//INSTANCIAR LA CLASE PAGSOBJECTS
		//alerts = new PageObjectAlertWindows(driver);
		//home =new PageOBjectHome(driver);
		//claseBase = new ClaseBase(driver);
		//date = new PageObjectDatePicker(driver);
	//INSTANCIAR CLASE PROPIEDADES 
		propiedades = new Properties();
	//INSTANCIAR LAS CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		
	//CREAR VARIABLE TIPO INPUT STRING
		InputStream entrada = null;
	//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/propiedadesData");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver=ClaseBase.chomeDriverConnetion();
	}
	

@Test
//INGRESAR A TOOLSQA, SECCION ALERTS Y REALIZAR TODAS LAS OPCIONES DE ALERTS
	public void alertToolsQa() throws Exception 
	{	
	
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "ejecucion", 1, 1).equals("Si"))
		{
		claseBase = new ClaseBase(driver);
		home =new PageOBjectHome(driver);
		home.url(leer, propiedades);
		alerts = new PageObjectAlertWindows(driver);
		generarReportePdf =new GenerarReportePdf();
		generarReportePdf.setRutaImagen(propiedades.getProperty("rutaImagenReporte"));
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		
		
		//INICIA CREACION DE REPORTE PDF
		generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
		//INICIAR GRABACION EN VIDEO
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		home.buttonAlert(propiedades, rutaCarpeta);
		alerts.alertas(leer, propiedades, rutaCarpeta);
		//FINALIZAR GRABACION DE VIDEO
		MyScreenRecorder.stopRecording();
		//FINALILZAR CREACION DEL REPORTE PDF
		generarReportePdf.cerrarPlantilla();
		
		}
		else {
			System.out.println("La automatizacion no se ejecutara para Alerts, revise los valores del excel... ");
		}
	} 

@Test
//INGRESAR A TOOLSQA, SECCION DATA PICKER, INGRESAR FECHA CON UN MES DE ANTERIORIDAD, UN DIA DE ANTERIORIDAD Y UNA HORA ANTES
public void DateToolsQaSistem() throws Exception 
{
	driver=ClaseBase.chomeDriverConnetion();
	
	if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "ejecucion", 2, 1).equals("Si"))
	{
	//ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
	claseBase = new ClaseBase(driver);
	home =new PageOBjectHome(driver);
	home.url(leer, propiedades);
	date = new PageObjectDatePicker(driver);
	generarReportePdf.setRutaImagen(propiedades.getProperty("rutaImagenReporte"));
	//OBTENER EL NOMBRE DEL METODO A EJECUTAR
	String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
	//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
	File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
	
	//INICIAR GRABACION EN VIDEO
	MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
	//ACCEDER AL METODO DE PRUEBA INICIAL
	home.buttonDate(propiedades, rutaCarpeta);
	date.sistemaDate(leer, propiedades, rutaCarpeta);
	
	//FINALIZAR GRABACION DE VIDEO
	MyScreenRecorder.stopRecording();
	}
	else {
		System.out.println("La automatizacion no se ejecutara para Widgets, revise los valores del excel... ");
	}
} 
	


@After
	public void cerrar()
	{
	//CERRAR PROCESO
	driver.quit();
	}

}
