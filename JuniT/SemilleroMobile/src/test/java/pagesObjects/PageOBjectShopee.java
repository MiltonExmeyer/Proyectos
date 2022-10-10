package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectShopee;
import utilidadesExcel.ReadExcelFile;

public class PageOBjectShopee extends MapObjectShopee
{

	public PageOBjectShopee(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	//ENVIAR NUMEROS DE N TAMAÑO INT
		public void shopee(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
		{
			//BOTON YO
			click(btnI, rutaCarpeta);
			click(btnIniciarSesion, rutaCarpeta);
			//TOCAR CAMPO DE USUARIO
			click(txtUser, rutaCarpeta);
			//ENVIAR TEXTO USUARIO DEL EXCEL
			sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "shopee", 1, 0), txtUser, rutaCarpeta);
			tiempoEspera(1000);
			sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "shopee", 1, 2), txtPassword, rutaCarpeta);
			tiempoEspera(1000);
			//BTN2 INICIAR SESION 
			click(btnIniciarSesionDos, rutaCarpeta);
			click(btnHome, rutaCarpeta);
			//TOUCH CAMPO BUSCAR 
			click(txtBuscar, rutaCarpeta);
			//ENVIAR PRODUCTO
			sendKey(leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "shopee", 1, 3), txtUser, rutaCarpeta);
			tiempoEspera(1000);
			//BUSCAR
			tocarPantalla(670, 1400);
			tiempoEspera(1000);
			//SELECCIONAR EL PRIMER PRODUCTO
			tocarPantalla(130, 510);
			tiempoEspera(1000);
			//AGREGAR CARRITO
			tocarPantalla(280, 1410);
			// SELECCIONAR CARACTERISTICA DEL PRODUCTO
			
			// BOTON ATRAS 
			// BOTON ATRAS 
			// BOTON YO
			// BOTON CONFIGURACIONES
			// ESCROLL VERTICAL AL FINAL 
			// BOTON CERRAR SESION 
			// BOTON SI, PARA CONFIRMAR SALIDA 
			
			
			
		}
}
