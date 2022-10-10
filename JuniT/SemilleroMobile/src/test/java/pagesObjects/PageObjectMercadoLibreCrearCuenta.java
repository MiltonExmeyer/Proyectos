package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectMercadoLibreCrearCuenta;
import utilidadesExcel.ReadExcelFile;

public class PageObjectMercadoLibreCrearCuenta extends MapObjectMercadoLibreCrearCuenta{

	public PageObjectMercadoLibreCrearCuenta(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void formulario(Properties propiedades,ReadExcelFile leer, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//BOTON CREAR CUENTA
		click(btnCrearCuenta, rutaCarpeta);
		tiempoEspera(2000);
		//INGRESAR DATOS DEL FORMULARIO
		click(txtNombre,rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"mercadoLibre",1,2), txtNombre, rutaCarpeta);
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"mercadoLibre",1,3), txtApellido, rutaCarpeta);
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"mercadoLibre",1,4), txtDocumento, rutaCarpeta);
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"mercadoLibre",1,5), txtEmail, rutaCarpeta);
		tocarPantalla(50, 280);
		tiempoEspera(500);
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"mercadoLibre",1,6), txtClave, rutaCarpeta);
		tocarPantalla(50, 280);
		tiempoEspera(500);
		
		//SCROLL VERTICAL
		scrollVertical(rutaCarpeta, 328,1100, 600, 1);
		tiempoEspera(2000);
		click(checkboxAceptarTerm, rutaCarpeta);
		tiempoEspera(500);
		click(btnCatcha, rutaCarpeta);
		tiempoEspera(2000);
		
	}
}
