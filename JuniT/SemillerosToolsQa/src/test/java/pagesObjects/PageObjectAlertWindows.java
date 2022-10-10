package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectAlertWindows;
import utilidadesExcel.ReadExcelFile;

public class PageObjectAlertWindows extends MapObjectAlertWindows{

	public PageObjectAlertWindows(WebDriver driver) 
	{
		super(driver);
	}
	
	//METODO PRIMERA PRUEBA 
	public void alertas(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
	//ACCIONES
	scrollDown(200, 1);	
		
	//SELECCIONAR ALERTS
	click(btnAlertsInicial, rutaCarpeta);
	tiempoEspera(2000);
	
	//SELECCIONAR EL PRIMER ALERT
	click(btnAlerts, rutaCarpeta);
	// INICIALIZAR LA VARIABLE alert
	Alert alert = driver.switchTo().alert();
	tiempoEspera(1000);
	// DAR ACEPTAR EN EL POP - UP
	alert.accept();
	tiempoEspera(1000);
	
	//SELECCIONAR EL SEGUNDO ALERT
	click(btnAlertsTimer, rutaCarpeta);
	tiempoEspera(5500);
	// INICIALIZAR LA VARIABLE alert
	Alert alert2 = driver.switchTo().alert();
	// DAR ACEPTAR EN EL POP - UP
	alert2.accept();
	tiempoEspera(1000);
	
	//SELECCIONAR EL TERCER ALERT ACEPTAR
	click(btnAlertsConfirm, rutaCarpeta);
	tiempoEspera(1000);
	// INICIALIZAR LA VARIABLE alert
	Alert alert3 = driver.switchTo().alert();
	// DAR ACEPTAR EN EL POP - UP
	alert3.accept();
	tiempoEspera(1000);
	
	//SELECCIONAR EL TERCER ALERT RECHAZAR
	click(btnAlertsConfirm, rutaCarpeta);
	tiempoEspera(1000);
	// INICIALIZAR LA VARIABLE alert
	Alert alert_32 = driver.switchTo().alert();
	// DAR ACEPTAR EN EL POP - UP
	alert_32.dismiss();
	tiempoEspera(1000);
	
	// SCROLL DOWN  200 PIXEL VERTICAL	
	scrollDown(200, 1);
	
	//SELECCIONAR EL CUARTO ALERT INPUT
	click(btnAlertsPromt, rutaCarpeta);
	tiempoEspera(1000);
	// INICIALIZAR LA VARIABLE alert
	alert.sendKeys((leer.getCellValue(propiedades.getProperty("filePathExcel"),"data", 1, 1)));
	//(leer.getCellValue(propiedades.getProperty("filePathExcel"),"toolsQA", 1, 0))
	tiempoEspera(1000);
	alert.accept();
	captureScreenBasic(rutaCarpeta);
	tiempoEspera(1000);
	
	}
	
	
}
