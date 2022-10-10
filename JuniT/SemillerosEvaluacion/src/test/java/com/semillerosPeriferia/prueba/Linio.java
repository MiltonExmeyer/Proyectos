package com.semillerosPeriferia.prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

//MILTON EXMEYER NIÑO GUZMAN


public class Linio {
	// CREACION OBJETO TIPO WEBDRIVER
	private WebDriver driver;
	
	//CREAR ANOTACIONES JUNIT
	@Before
	public void navegadorChrome()
	{
			
		//SETEAR LAS PROPIEDADES DEL EJECUTABLE DE CHROME
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		
		//DECLARAR EL OBJETO DRIVER TIPO CHROMEDRIVER
		driver = new ChromeDriver();
			
		//DEFINIR ESTRATEGIA DE CARGA DE LA PAG
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
		//MAXIMIZAR VENTANA DEL NAVEGADOR
		driver.manage().window().maximize();
			
		//INGRESAR LA URL DE PAGINA DE ACCESO 
		driver.get("https://www.linio.com.co");
	}
	
	@Test
	public void iniciarPrueba()
	{
		//CREAR UN OBJETO DE LA PAGINA PRINCIPAL 
		WebElement txtBusqueda = driver.findElement(By.xpath("//input[@class='form-control']"));
		//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
		txtBusqueda.clear();
		//ENVIAR UN VALOR A BUSCAR 
		txtBusqueda.sendKeys("Escritorios para computador");
		txtBusqueda.submit();
		
		//ELEGIR EL PRIMER ESCRITORIO
		WebElement primerProducto = driver.findElement(By.xpath("//*[text() ='Escritorio Astana Rovere 73,5 X 120 X 45...']"));
		primerProducto.click();
		
		
		//AGREGAR AL CARRITO
		WebElement agregarCarrito = driver.findElement(By.id("buy-now"));
		agregarCarrito.click();
		
		// IR AL CARRITO
		WebElement irCarrito= driver.findElement(By.xpath("//a[@class ='btn btn-sm btn-go-to-cart added-product']"));
		irCarrito.click();
		
		//PROCESAR COMPRA
		WebElement procesarCompra = driver.findElement(By.xpath("//a[@class ='btn btn-lg btn-primary summary-btn-process-pay col-md-12']"));
		procesarCompra.click();	
		
		//CREAR CUENTA
		WebElement crearCuenta= driver.findElement(By.xpath("//li/a[@href='#register-form']"));
		crearCuenta.click();
		
		//LLENAR CAMPO NOMBRE
		WebElement nombre= driver.findElement(By.id("registration_firstName"));
		nombre.clear();
		nombre.sendKeys("Milton");
		
		//LLENAR CAMPO APELLIDO
		WebElement apellido= driver.findElement(By.id("registration_lastName"));
		apellido.clear();
		apellido.sendKeys("Niño Guzman");
		
		//LLENAR CAMPO EMAIL
		WebElement email= driver.findElement(By.id("registration_email"));
		email.clear();
		email.sendKeys("mn.niguz@gmail.com");
		
		//LLENAR CAMPO CONTRASEÑA
		WebElement contraseña= driver.findElement(By.id("registration_password"));
		contraseña.clear();
		contraseña.sendKeys("periferia");
		
		//LLENAR CAMPO CEDULA
		WebElement cedula= driver.findElement(By.id("registration_nationalRegistrationNumber"));
		cedula.clear();
		cedula.sendKeys("1019116046");
		
		//CHEQUEAR AUTORIZACION DE DATOS
		WebElement autorizacionDatos= driver.findElement(By.xpath("//label[@for='registration_acceptTerms']"));
		autorizacionDatos.click();
				
		//CHEQUEAR ACUMULACION DE PUNTOS
		WebElement acumulacionPuntos= driver.findElement(By.xpath("//label[@for='registration_cmrPointsAcceptedSubscription']"));
		acumulacionPuntos.click();
	
	}	
	
	@After
	public void cerrarNavegador()
	{
		driver.close();
		driver.quit();
	}

}
