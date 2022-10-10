package pagesObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObjects.MapObjectCrearCuenta;
import utilidadesExcel.ReadExcelFile;

public class PageObjectCrearCuenta extends MapObjectCrearCuenta{
	
	
	public PageObjectCrearCuenta(WebDriver driver)
	{
		super(driver);
	}
	
	public void crearCuenta(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception, IOException,InterruptedException
	{
	
	//INSTANCIAR CLASES PROPIEDADES
	propiedades = new Properties ();
	//CREAR VARIABLE TIPO INPUT STRING
	InputStream entrada = null;
	//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
	try {
		entrada = new FileInputStream("./Properties/propiedadesData");
		propiedades.load(entrada);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.out.println(e);
	}
	
	{
		try {
			//AUTORIZAR DATOS
			click(autorizarDatos, rutaCarpeta);
			//CONTINUAR
			click(continuar, rutaCarpeta);
			//VALIDACION CON EMAIL
			click(validarEmail, rutaCarpeta);
			// INGRESAR EMAIL
			borrar(ingresoEmail, rutaCarpeta);
			//sendKey("jajajajajaj@gmial.com",ingresoEmail);	
			//sendKey(propiedades.getProperty("email"),ingresoEmail);
			sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 2, 2),ingresoEmail, rutaCarpeta);
			//sendKey(email,ingresoEmail);
			tiempoEspera(2000);
			
		} catch (Exception e) {
			imprimirConsola(e);
		}
		
	}
	
	}
}

