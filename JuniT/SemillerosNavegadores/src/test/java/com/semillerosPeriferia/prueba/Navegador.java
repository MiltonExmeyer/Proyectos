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
// MILTON EXMEYER NIÑO GUZMAN
public class Navegador {
	
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
		driver.get("https://www.google.com/?hl=es");
	}
	
	
	@Test
	public void iniciarPrueba()
	{
		//CREAR UN OBJETO DE LA PAGINA PRINCIPAL 
		WebElement txtBusqueda = driver.findElement(By.name("q"));
		//LIMPIAR LA CAJA DE TEXTO DE BUSQUEDA
		txtBusqueda.clear();
		//ENVIAR UN VALOR A BUSCAR 
		txtBusqueda.sendKeys("periferia it");
		txtBusqueda.submit();
		
		String titulo = driver.getTitle();
		System.out.println(titulo);
		
		//INGRESAR AL SITIO WEB DE PERIFERIA
		WebElement linkPeriferia = driver.findElement(By.xpath("//*[text()='Periferia IT Group – Somos innovación en tecnología y ...']"));
		linkPeriferia.click();
		
		//INGRESAR EN TRABAJA CON NOSOTROS
		WebElement trabajaNosotros = driver.findElement(By.cssSelector("#menu-item-3373"));
		trabajaNosotros.click();
		
		// SELECCIONAR VACANTE
		WebElement seleccionarVacante = driver.findElement(By.xpath("//span[@title='INGENIERO DESARROLLO MOBILE IOS']"));
		seleccionarVacante.click();
		
		//ACEPTAR COOKIES
		WebElement aceptarCookies = driver.findElement(By.id("tt-cookie-alert__accept-all"));
		aceptarCookies.click();	
		
		//APLICAR A LA OFERTA SELECCIONADA
		WebElement aplicarVacante = driver.findElement(By.xpath("//button/div/span[text()='Aplicar a la oferta']"));
		aplicarVacante.click();
		//Thread.sleep(2000);
	}	
	
	@After 
	
	public void cerrarNavegador()
	{
		driver.close();
		driver.quit();
	}

}
