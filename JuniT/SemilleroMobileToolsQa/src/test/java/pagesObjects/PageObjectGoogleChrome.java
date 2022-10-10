package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectGoogleChrome;
import utilidades.ReadExcelFile;

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
		//OPCIONES DEL NAVEGADOR
		click(btnOpciones, rutaCarpeta);
		//BOTON NUEVA PESTAÑA
		click(btnNuevaPestaña, rutaCarpeta);
		//SELECCIONAR EL CUADRO DE TEXTO
		click(txtBuscar, rutaCarpeta);
		//ENVIAR LA URL DESDE EL EXCEL
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "url", 1, 0), txtBuscarDos, rutaCarpeta);
		tiempoEspera(2000);
		//TOUCH PARA ENVIAR EL TEXTO
		tocarPantalla(664, 1401);
		tiempoEspera(2000);
	}
}
