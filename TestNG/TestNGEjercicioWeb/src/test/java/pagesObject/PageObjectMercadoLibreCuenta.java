package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectMercadoLibreCuenta;


public class PageObjectMercadoLibreCuenta extends MapObjectMercadoLibreCuenta {

	public PageObjectMercadoLibreCuenta(WebDriver driver) 
	{
		super(driver);
	}

	public void crearCuenta(String email, File rutaCarpeta, String evidencia) throws Exception, IOException,InterruptedException
	{
	
			//AUTORIZAR DATOS
			click(autorizarDatos, rutaCarpeta, evidencia);
			//CONTINUAR
			click(continuar, rutaCarpeta, evidencia);
			//VALIDACION CON EMAIL
			click(validarEmail, rutaCarpeta, evidencia);
			//LIMPIAR CUADRO DE TEXTO PARA EMAIL
			borrar(ingresoEmail, rutaCarpeta, evidencia);
			// INGRESAR EMAIL
			sendKey(email,ingresoEmail, rutaCarpeta, evidencia);
			tiempoEspera(5000);
	}
	
	}
	

