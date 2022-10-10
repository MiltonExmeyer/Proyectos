package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectGoogleChrome;
import utilidadesExcel.ReadExcelFile;

public class PageObjectGoogleChrome extends MapObjectGoogleChrome
{

	public PageObjectGoogleChrome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void buscador(Properties propiedades,ReadExcelFile leer, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		click(btnOpciones, rutaCarpeta);
		click(btnNuevaPestaña, rutaCarpeta);
		click(txtBuscar, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "google", 1, 0), txtBuscarDos, rutaCarpeta);
		tiempoEspera(2000);
		tocarPantalla(664, 1401);
		tiempoEspera(2000);
		
		

	}
}
