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
import pagesObjects.PageOBjectCalculadoraOperaciones;
import pagesObjects.PageOBjectShopee;
import pagesObjects.PageObjectGoogleChrome;
import pagesObjects.PageObjectMercadoLibreCrearCuenta;
import pagesObjects.PageObjectMercadoLibreHome;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class Runnnn {

	//CREAR OBJETO TIPO DRIVER
	@SuppressWarnings("rawtypes")
	private AppiumDriver driver;
	PageOBjectCalculadoraOperaciones operaciones;
	PageOBjectShopee shopee;
	PageObjectGoogleChrome google;
	PageObjectMercadoLibreHome mercadoLibreHome;
	PageObjectMercadoLibreCrearCuenta meradoLibreCrearCuenta;
	
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
		
		//ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		/*
		driver=ClaseBase.appiumDriverConnetion(propiedades, leer, null, 0, 0);
		claseBase = new ClaseBase (driver);
		operaciones =new PageOBjectCalculadoraOperaciones(driver);
		*/
	}
	
/*
@Test
//INGRESAR A CALCULADORA Y OPERAR CON VALORES QUEMADOS
	public void suma() throws Exception 
	{
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		operaciones.suma(propiedades, rutaCarpeta);
	} 
	*/
/*	
@Test
//INGRESAR A CALCULADORA CON TAMAÑO DE UN NUMERO DESDE EXCEL
	public void generic() throws Exception 
	{
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		operaciones.generic(leer, propiedades, rutaCarpeta);
		
	} 
*/
	

@SuppressWarnings("unchecked")
@Test
//INGRESAR A CALCULADORA CON N TAMAÑO DE NUMEROS DESDE EXCEL
	public void excel() throws Exception 
	{
		driver=ClaseBase.appiumDriverConnetion(propiedades, leer, "capability", 1, 2);
		if (leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "capability", 1, 1).equals("Si"))
		{
		claseBase = new ClaseBase (driver);
		operaciones =new PageOBjectCalculadoraOperaciones(driver);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		operaciones.excelVarVar(leer, propiedades, rutaCarpeta);	
		}
		else {
			System.out.println("La automatizacion no se ejecutara, revise los valores del excel... para la calculadora");
		}
	} 	

/*
@SuppressWarnings("unchecked")
@Test
//INGRESAR A SHOPEE APP Y COMPRAR UN PRODUCTO
	public void shopee() throws Exception 
	{
		driver=ClaseBase.appiumDriverConnetion(propiedades, leer, "capability", 2, 2);
		if (leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "capability", 2, 1).equals("Si"))
		{
		claseBase = new ClaseBase (driver);
		shopee =new PageOBjectShopee(driver);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		shopee.shopee(leer, propiedades, rutaCarpeta);	
		}
		else {
			System.out.println("La automatizacion no se ejecutara, revise los valores del excel... para shopee");
		}
	} 
	*/
	
@SuppressWarnings("unchecked")
@Test
//INGRESAR GOOGLE APP Y REALIZAR UNA COMPRA EN MERCADO LIBRE
	public void googleMercadoLibre() throws Exception 
	{
		driver=ClaseBase.appiumDriverConnetion(propiedades, leer, "capability", 3, 2);
		if (leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "capability", 3, 1).equals("Si"))
		{
		claseBase = new ClaseBase (driver);
		google =new PageObjectGoogleChrome(driver);
		mercadoLibreHome = new PageObjectMercadoLibreHome(driver);
		meradoLibreCrearCuenta = new PageObjectMercadoLibreCrearCuenta (driver);
		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		google.buscador(propiedades, leer, rutaCarpeta);
		mercadoLibreHome.home(propiedades, leer, rutaCarpeta);
		meradoLibreCrearCuenta.formulario(propiedades, leer, rutaCarpeta);
		
		}
		else {
			System.out.println("La automatizacion no se ejecutara, revise los valores del excel... para shopee");
		}
	} 



@After
	public void cerrar()
	{
	//CERRAR PROCESO
	driver.quit();
	}

}
