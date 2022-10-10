package run;

import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;
import claseBase.ClaseBase;
import pagesObject.PagObjectMercuryTours;
import pagesObject.PageOBjectHomeTools;
import pagesObject.PageObjectAlertWindowsTools;
import pagesObject.PageObjectMercadoLibreCuenta;
import pagesObject.PageObjectMercadoLibreHome;
import pagesObject.PageObjectToolsDatePicker;


public class Run {

	WebDriver driver;
	
	PageObjectMercadoLibreHome home;
	PageObjectMercadoLibreCuenta cuenta;
	PageOBjectHomeTools homeTools;
	PageObjectAlertWindowsTools alertsTools;
	PageObjectToolsDatePicker dateTools;
	PagObjectMercuryTours mercury;
	ClaseBase claseBase;
	GenerarReportePdf generarReportePdf;
	String imagenMercadoLibre;
	String imagenReporteTools;
	String imagenReporteMercury;
	
	@BeforeClass
	
	@Parameters({"url","rutaImagenReporteMercLibre","rutaImagenReporteTools","rutaImagenReporteMercury","rutaOutput"})
	  public void beforeClass(@Optional("default") String url,
			  					@Optional("default") String rutaImagenReporteMercLibre,
			  					@Optional("default") String rutaImagenReporteTools,
			  					@Optional("default") String rutaImagenReporteMercury,
	  							@Optional("default") String rutaOutput) throws IOException
	  
	{	
		// INSTANCIAR LA CLASE PAGSOBJECTS
		driver = ClaseBase.chomeDriverConnetion();
		claseBase = new ClaseBase(driver);
		home = new PageObjectMercadoLibreHome(driver);
		cuenta = new PageObjectMercadoLibreCuenta(driver);
		homeTools = new PageOBjectHomeTools(driver);
		alertsTools = new PageObjectAlertWindowsTools(driver);
		dateTools = new PageObjectToolsDatePicker(driver);
		mercury = new PagObjectMercuryTours (driver);
		
		generarReportePdf =new GenerarReportePdf();
		imagenMercadoLibre = rutaImagenReporteMercLibre;
		imagenReporteTools = rutaImagenReporteTools;
		imagenReporteMercury = rutaImagenReporteMercury;
	}	

	
	@DataProvider(name = "datosMercLibrePro")
	public Object[][] datosMercLibrePro() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "compraProducto");
		return arreglo;
	}

	@Test(dataProvider = "datosMercLibrePro", priority = 1 )
	//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	
	public void seleccionarPrimerProducto(String url, String ejecutar, String evidencia, String producto, String email) throws Exception 
	{
		if (ejecutar.equals("Si")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si"))
			{
				generarReportePdf.setRutaImagen(imagenMercadoLibre);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				home.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				home.busquedaInicial(producto, rutaCarpeta, evidencia);
				cuenta.crearCuenta(email, rutaCarpeta, evidencia);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				//driver.close();
			}else 
			{
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				home.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				home.busquedaInicial(producto, rutaCarpeta, evidencia);
				cuenta.crearCuenta(email, rutaCarpeta, evidencia);
				
			}
			
		} else 
		{
			System.out.println("La automatizacion no se ejecutara para Mercado libre comprar producto...");
		}
	}
	

	
	@DataProvider(name = "datosMercLibreCuenta")
	public Object[][] datosMercLibreCuenta() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "crearCuenta");
		return arreglo;
	}
	
	@Test(dataProvider = "datosMercLibreCuenta", priority = 2)
	//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	public void crearCuenta(String url, String ejecutar, String evidencia, String email) throws Exception 
	{
		if (ejecutar.equals("Si")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si"))
			{
				generarReportePdf.setRutaImagen(imagenMercadoLibre);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				home.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				home.crearCuentaBtn(rutaCarpeta, evidencia);
				cuenta.crearCuenta(email, rutaCarpeta, evidencia);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				//driver.close();
			}else 
			{
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				home.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				home.crearCuentaBtn(rutaCarpeta, evidencia);
				cuenta.crearCuenta(email, rutaCarpeta, evidencia);
				//driver.close();
			}
			
		} else 
		{
			System.out.println("La automatizacion no se ejecutara para Mercado libre crear cuenta...");
		}
	}
	
	
	
	@DataProvider(name = "datosToolsAlerts")
	public Object[][] datosToolsAlerts() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "alertsTools");
		return arreglo;
	}
	
	@Test(dataProvider = "datosToolsAlerts", priority = 3)
	//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	
	public void alertsTools(String url, String ejecutar, String evidencia, String input) throws Exception 
	{
		if (ejecutar.equals("Si")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si"))
			{
				generarReportePdf.setRutaImagen(imagenReporteTools);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				homeTools.url(url);///
				// ACCEDER AL METODO DE PRUEBA INICIAL
				homeTools.buttonAlert(rutaCarpeta, evidencia);///
				alertsTools.alertas(input, evidencia, rutaCarpeta);///
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				//driver.close();
			}else 
			{
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				homeTools.url(url);///
				// ACCEDER AL METODO DE PRUEBA INICIAL
				homeTools.buttonAlert(rutaCarpeta, evidencia);///
				alertsTools.alertas(input, evidencia, rutaCarpeta);///
				//driver.close();
			}
			
		} else 
		{
			System.out.println("La automatizacion no se ejecutara para Tools QA Alerts...");
		}
	}
	
	
	@DataProvider(name = "datosToolsDate")
	public Object[][] datosToolsDate() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "dateTools");
		return arreglo;
	}
	
	@Test(dataProvider = "datosToolsDate", priority = 4)
	//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	
	public void dateTools(String url, String ejecutar, String evidencia) throws Exception 
	{
		if (ejecutar.equals("Si")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si"))
			{
				generarReportePdf.setRutaImagen(imagenReporteTools);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				homeTools.url(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				homeTools.buttonDate(rutaCarpeta, evidencia);
				dateTools.sistemaDate(rutaCarpeta, evidencia);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				//driver.close();
			}else 
			{
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				homeTools.url(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				homeTools.buttonDate(rutaCarpeta, evidencia);
				dateTools.sistemaDate(rutaCarpeta, evidencia);
				//driver.close();
			}
			
		} else 
		{
			System.out.println("La automatizacion no se ejecutara para Tools QA Date...");
		}
	}
	
	
	@DataProvider(name = "datosMercury")
	public Object[][] datosMercury() throws Exception {
		Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/data.xlsx", "mercuryTours");
		return arreglo;
	}
	
	@Test(dataProvider = "datosMercury", priority = 5)
	//INGRESAR A MERCADOLIBRE BUSCAR UN PRODUCTO, SELECCIONAR EL PRIMERO Y GREAR UNA CUENTA
	public void mercuryTours(String url, String ejecutar, String evidencia,  String firstName, String lastName, 
			String phone, String email, String address, String city, String stateProvince, 
			String postalCode, String country, String userName, String password, String confirmPassword) throws Exception 
	{
		if (ejecutar.equals("Si")) 
		{
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPERTA PARA ALMECENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			//VALIDAR SI SE GENERA EVIDENCIA
			if (evidencia.equals("Si"))
			{
				generarReportePdf.setRutaImagen(imagenReporteMercury);
				// INICIAR GRABACION EN VIDEO
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				// INICIA CREACION DE REPORTE PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);
				// ACCEDER AL METODO DE ABRIR LA PAGINA CON EXCEL
				mercury.urlAcceso(url);
				// ACCEDER AL METODO DE PRUEBA INICIAL
				mercury.homeMercury(rutaCarpeta, evidencia);
				mercury.formulario(rutaCarpeta, evidencia, firstName, lastName, phone, email, address, city, stateProvince,
						postalCode, country, userName, password, confirmPassword);
				// FINALIZAR GRABACION DE VIDEO
				MyScreenRecorder.stopRecording();
				// FINALILZAR CREACION DEL REPORTE PDF
				generarReportePdf.cerrarPlantilla();
				//driver.close();
			}else 
			{
				// ACCEDER AL METODO DE PRUEBA INICIAL
				mercury.homeMercury(rutaCarpeta, evidencia);
				mercury.formulario(rutaCarpeta, evidencia, firstName, lastName, phone, email, address, city, stateProvince,
						postalCode, country, userName, password, confirmPassword);
				//driver.close();
			}
			
		} else 
		{
			System.out.println("La automatizacion no se ejecutara para Tools QA Date...");
		}
	}
	
	
	
	
	
	@AfterClass
	public void afterClass() 
	{
		
		driver.quit();
	}
}
