package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectQaAlerts;
import utilidades.ReadExcelFile;

public class PageObjectQaAlerts extends MapObjectQaAlerts{

	public PageObjectQaAlerts(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void alertas(Properties propiedades,ReadExcelFile leer, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//SCROLL A BTN ALERTS
		scrollVertical(rutaCarpeta, 361, 1219, 400, 2);
		tiempoEspera(1000);
		//BTN ALERTS AND FRAME Y WINDOWS
		clickTime(btnAlertsFrame, rutaCarpeta, 1);
		//BTN ALERTS 
		clickTime(btnAlertsIni,rutaCarpeta,1);
		
		//SELECCIONAR PRIMER ALERT
		clickTime(btnAlerts, rutaCarpeta,0);
		clickTime(btnAceptar, rutaCarpeta, 1);
		
		//SELECCIONAR SEGUNDO ALERT
		clickTime(btnAlertsTimer, rutaCarpeta,6);
		clickTime(btnAceptar, rutaCarpeta, 1);
		
		//SELECCIONAR TERCER ALERT
		clickTime(btnAlertsConfirm, rutaCarpeta,1);
		//OPCION CANCELAR
		clickTime(btnCancelar, rutaCarpeta, 2);
		//SELECCIONAR TERCER ALERT
		clickTime(btnAlertsConfirm, rutaCarpeta,1);
		//OPCION ACEPTAR
		clickTime(btnAceptar, rutaCarpeta, 2);
		
		//SELECCIONAR CUARTO ALERT
		clickTime(btnAlertsName, rutaCarpeta,1);
		//ENVIAR IMPUT DESDE EL EXCEL
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"dataAlerts",2,0), txtName, rutaCarpeta);
		//OPCION ACEPTAR
		clickTime(btnAceptar, rutaCarpeta, 2);	
		
	}
}
