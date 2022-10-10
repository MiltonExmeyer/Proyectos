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


public class MercadoLibre {
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
		driver.get("https://www.mercadolibre.com.co/");
	}
	
	@Test
	public void iniciarPrueba()
	{
		//CREAR UN OBJETO DE LA PAGINA PRINCIPAL 
		WebElement txtBusqueda = driver.findElement(By.id("cb1-edit"));
		//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
		txtBusqueda.clear();
		//ENVIAR UN VALOR A BUSCAR 
		txtBusqueda.sendKeys("Computador");
		txtBusqueda.submit();
		
		//COOKIES 
		WebElement cookies = driver.findElement(By.xpath("//button[text() = 'Entendido']"));
		cookies.click();
		//UBICACION
		WebElement ubicacion = driver.findElement(By.xpath("//button[@class = 'andes-tooltip-button-close']"));
		ubicacion.click();
		//ELEGIR EL PRIMER ESCRITORIO
		WebElement primerProducto = driver.findElement(By.xpath("//h2[text()='Portatil Computador Lenovo Intel Dual Core Ssd 512gb Ram8gb']"));
		primerProducto.click();
		
		
		//AGREGAR AL CARRITO
		WebElement agregarCarrito = driver.findElement(By.xpath("//span[text()='Agregar al carrito']"));
		agregarCarrito.click();
		
		// CREAR CUENTA
		WebElement crearCuenta= driver.findElement(By.xpath("//span[text()='Crear cuenta']"));
		crearCuenta.click();
		
		//AUTORIZACION DE DATOS
		WebElement autorizarDatos= driver.findElement(By.id("terms-and-conds"));
		autorizarDatos.click();	
		
		//BOTON CONTINUAR
		WebElement continuar= driver.findElement(By.xpath("//span[text()='Continuar']"));
		continuar.click();
		
		//SELECCIONAR VALIDAR CON EMAIL
		WebElement validarEmail= driver.findElement(By.xpath("//span[text()='Validar']"));
		validarEmail.click();
		
		//LLENAR CAMPO EMAIL
		WebElement ingresoEmail= driver.findElement(By.xpath("//input[@class='andes-form-control__field']"));
		ingresoEmail.clear();
		ingresoEmail.sendKeys("jajajajjaja@gmail.com");
		
	
	}	
	
	@After
	public void cerrarNavegador()
	{
		driver.close();
		driver.quit();
	}

}
