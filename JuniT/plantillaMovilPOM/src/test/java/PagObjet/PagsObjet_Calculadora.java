package PagObjet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import MapsObjet.MapsObjetInicio;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjet_Calculadora  extends MapsObjetInicio
{


	//CREAR CONSTRUCTOR DE LA CLASE	
	public PagsObjet_Calculadora(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
		//this.driver=driver;
	} 

	
	//METODO PRIMERA PRUEBA 
	public void calculadora(ReadExcelFile leer, File rutaFile,Properties propiedades, String nomTest) throws Exception 
	{
		sendkey( "https://www.mercadolibre.com.ec/", txtBuscadorGoogle,rutaFile, 1);
		click(nomTest, enter, rutaFile, 1);
		tiempoEspera(2);
		//enter(rutaFile, 1);
		//tocarPantalla(2);
		click(nomTest, linkmercadolibre, rutaFile, 3);
		sendkey("cerveza", txtbuscarProducto, rutaFile,1);
		click(nomTest, localizadorVariable(txtbuscarProducto1, "cerveza"), rutaFile, 1);
		enter(rutaFile, 1);
		click(nomTest, primerproducto, rutaFile, 4);
		scrollVertical(rutaFile, 300, 1100, 500, 1);
		click(nomTest, comprarAhora, rutaFile, 2);
		tiempoEspera(2);
	}
	
	
}
