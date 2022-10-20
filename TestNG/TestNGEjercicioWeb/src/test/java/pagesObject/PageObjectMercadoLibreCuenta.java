package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import mapsObject.MapObjectMercadoLibreCuenta;


public class PageObjectMercadoLibreCuenta extends MapObjectMercadoLibreCuenta {

	public PageObjectMercadoLibreCuenta(WebDriver driver) 
	{
		super(driver);
	}

	public void crearCuenta(String email, File rutaCarpeta, String evidencia) throws Exception, IOException,InterruptedException
	{
	try {
			//AUTORIZAR DATOS
			click(autorizarDatos, rutaCarpeta, evidencia, "Se autoriza el tratamiento de datos");
			//CONTINUAR
			click(continuar, rutaCarpeta, evidencia, "Se le da en el boton continuar");
			//VALIDACION CON EMAIL
			validacion(validarEmail, rutaCarpeta, evidencia, "Se elige la opcion validar con email");
			//VALIDACION CON EMAIL
			validacion(validarEmailDos, rutaCarpeta, evidencia, "Se elige la opcion validar con email");
			//LIMPIAR CUADRO DE TEXTO PARA EMAIL
			borrar(ingresoEmail, rutaCarpeta, evidencia, "Se limpia el cuadro de texto");
			// INGRESAR EMAIL
			sendKey(email,ingresoEmail, rutaCarpeta, evidencia, "Se ingresa el email para el registro");
			Assert.assertEquals(estado(btnValidar), true);
			tiempoEspera(5000);
	} catch (Exception e) {
		System.out.println(e.toString());
		throw new InterruptedException();
	}
	
	}
}
	

