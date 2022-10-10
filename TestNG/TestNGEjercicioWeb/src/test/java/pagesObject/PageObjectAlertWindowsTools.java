package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectAlertWindowsTools;

public class PageObjectAlertWindowsTools extends MapObjectAlertWindowsTools {

	public PageObjectAlertWindowsTools(WebDriver driver) 
	{
		super(driver);
	}

	//METODO PRIMERA PRUEBA 
		public void alertas(String input ,String evidencia, File rutaCarpeta ) throws Exception, InterruptedException, IOException
		{
		//ACCIONES
		scrollDown(200, 1);	
			
		//SELECCIONAR ALERTS
		clickTools(btnAlertsInicial, rutaCarpeta, evidencia);
		tiempoEspera(4000);
		
		//SELECCIONAR EL PRIMER ALERT
		clickTools(btnAlerts, rutaCarpeta, evidencia);
		// INICIALIZAR LA VARIABLE alert
		Alert alert = driver.switchTo().alert();
		tiempoEspera(1000);
		// DAR ACEPTAR EN EL POP - UP
		alert.accept();
		tiempoEspera(4000);
		
		//SELECCIONAR EL SEGUNDO ALERT
		clickTools(btnAlertsTimer, rutaCarpeta, evidencia);
		tiempoEspera(5500);
		// INICIALIZAR LA VARIABLE alert
		Alert alert2 = driver.switchTo().alert();
		// DAR ACEPTAR EN EL POP - UP
		alert2.accept();
		tiempoEspera(1000);
		
		//SELECCIONAR EL TERCER ALERT ACEPTAR
		clickTools(btnAlertsConfirm, rutaCarpeta, evidencia);
		tiempoEspera(1000);
		// INICIALIZAR LA VARIABLE alert
		Alert alert3 = driver.switchTo().alert();
		// DAR ACEPTAR EN EL POP - UP
		alert3.accept();
		tiempoEspera(1000);
		
		//SELECCIONAR EL TERCER ALERT RECHAZAR
		clickTools(btnAlertsConfirm, rutaCarpeta, evidencia);
		tiempoEspera(1000);
		// INICIALIZAR LA VARIABLE alert
		Alert alert_32 = driver.switchTo().alert();
		// DAR ACEPTAR EN EL POP - UP
		alert_32.dismiss();
		tiempoEspera(1000);
		
		// SCROLL DOWN  200 PIXEL VERTICAL	
		scrollDown(200, 1);
		
		//SELECCIONAR EL CUARTO ALERT INPUT
		clickTools(btnAlertsPromt, rutaCarpeta, evidencia);
		tiempoEspera(1000);
		// INICIALIZAR LA VARIABLE alert ENVIAR INPUT
		//alert.sendKeys(input);// REVISAR 
		driver.switchTo().alert().sendKeys(input);
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		captureScreen(rutaCarpeta, btnAlertsPromt, evidencia);
		//alert.accept();
		tiempoEspera(2000);
		
		}
}
