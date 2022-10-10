package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectMercadoLibreHome;
import utilidadesExcel.ReadExcelFile;

public class PageObjectMercadoLibreHome extends MapObjectMercadoLibreHome{

	public PageObjectMercadoLibreHome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	public void home(Properties propiedades,ReadExcelFile leer, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ACCIONES
		//CLICKAR CAMPOO BUSCAR
		click(txtBusqueda, rutaCarpeta);
		//ENVIAR PRODUCTO DESDE EL EXCEL
		sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "mercadoLibre", 1, 0), txtBusqueda, rutaCarpeta);
		tiempoEspera(500);
		//CLICKAR EN ENVIAR
		tocarPantalla(664, 1401);
		tiempoEspera(1000);
		//SELECCIONAR EL PRIMER ELEMENTO
		clickTime(imgPrimerElemento, rutaCarpeta, 2);
		//ESCROLL VERTICAL CORTO 
		scrollVertical(rutaCarpeta, 350, 1138, 221, 1);
		tiempoEspera(2000);
		//BOTON COMPRAR AHORA 
		clickTime(btnComprarAhora, rutaCarpeta, 2);		

	}
}
