package run;

import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;

import pagesObjects.PageObjectCrearCuenta;
import pagesObjects.PageObjectHomeMercury;
import pagesObjects.PageObjectRegisterMercury;
import pagesObjects.PagesObjectsPagPrincipal;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {
	//CREAR OBJETO TIPO WEB DRIVER
	private WebDriver driver;
	PagesObjectsPagPrincipal paginas;
	PageObjectCrearCuenta crearCuenta;
	PageObjectHomeMercury homeMercury;
	PageObjectRegisterMercury registerMercury;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClaseBase claseBase;
	//CREAR ANOTACIONES JUNIT
@Before
	public void setUp() throws IOException 
	{
	//INSTANCIAR LA CLASE PAGSOBJECTS
	paginas = new PagesObjectsPagPrincipal(driver);
	claseBase = new ClaseBase(driver);
	homeMercury = new PageObjectHomeMercury(driver);
	registerMercury = new PageObjectRegisterMercury(driver);
	//INSTANCIAR CLASE CREAR CUENTA
	crearCuenta = new PageObjectCrearCuenta(driver);
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
	
	
	//ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
	//paginas.urlAcceso(leer, propiedades);
	//homeMercury.urlAcceso(leer, propiedades);
	//ACCEDER AL METODO DE ABRIR LA PAGINA
	//paginas.urlAcceso(propiedades.getProperty("url"));
	
	//ACCEDER AL METODO CREAR CUENTA
	//paginas.busqueda(propiedades.getProperty("producto"));
	
	//ACCEDER AL METODO CREAR CUENTA
	//paginas.correo(propiedades.getProperty("email"));
		
	//ACCEDER AL METODO DE ABRIR LA PAG
	//paginas.urlAcceso("https://www.mercadolibre.com.co/");
	
	}

@Test

//@Order(1)
//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	public void seleccionarPrimerProducto() throws Exception 
	{
		//ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
		paginas.urlAcceso(leer, propiedades);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		paginas.busquedaInicial(leer, propiedades, rutaCarpeta);
		crearCuenta.crearCuenta(leer, propiedades, rutaCarpeta);
	} 


/*
@Test

//@Order(2)
//INGRESAR A MERCADO LIBRE Y CREAR UNA CUENTA DESDE EL BOTON CREAR
	public void crearCuenta() throws Exception
	{
		//ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
		paginas.urlAcceso(leer, propiedades);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		//ACCEDER A LA PAG PRINCIPAL
		paginas.crearCuentaBtn(propiedades, rutaCarpeta);
		crearCuenta.crearCuenta(leer,propiedades, rutaCarpeta);
	}
*/

/*
@Test

//@Order(3)
//INGRESAR A MERCURY TOOLS Y REGISTRAR UNA CUENTA 
	public void registroMercuryTours() throws Exception 
	{
		//ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
		homeMercury.urlAcceso(leer, propiedades);
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades, nomTest);
		//ACCEDER AL METODO DE PRUEBA INICIAL
		homeMercury.homeMercury(leer, propiedades, rutaCarpeta);
		registerMercury.formulario(leer, propiedades, rutaCarpeta);
	} 
*/
@After
	public void cerrar()
	{
	//CERRAR PROCESO
	driver.quit();
	}
	
	
}
