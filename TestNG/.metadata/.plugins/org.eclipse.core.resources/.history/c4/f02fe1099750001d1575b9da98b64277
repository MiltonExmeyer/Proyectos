package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjemploTestNG {
	
	WebDriver driver;
	By txtBusquedaGoogle=By.name("q");
	
	@BeforeClass
	public void beforeClass() 
	{
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		//MAXIMIZAR EL NAVEGADOR
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
	}	
	
	@Test
	public void pruebaInicialTestNG() 
	{
		driver.findElement(txtBusquedaGoogle).sendKeys("peroferia-it");  
	}


	@AfterClass
	public void afterClass() 
	{
		driver.close();
	}

}
