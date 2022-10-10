package pagesObject;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectCalculadora;

public class PageOBjectCalculadora extends MapObjectCalculadora {

	public PageOBjectCalculadora(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}

	// ENVIAR NUMEROS DE N TAMAÑO INT
	public void operaciones(String valorUno,String valorDos, String resultadoEsperado,File rutaCarpeta, String operacion,String evidencia)
			throws Exception, InterruptedException, IOException {
		// ENVIAR PRIMER NUMERO
		crearArray(valorUno, btnNumeros, rutaCarpeta, evidencia);
		// OPERACION
		click(localizadorVariableXpath(btnOperaciones, operacion), rutaCarpeta, evidencia, "Click en el el boton " + operacion);
		// ENVIAR SEGUNDO NUMERO
		crearArray(valorDos, btnNumeros, rutaCarpeta,evidencia);
		// RESULTADO
		click(btnResult, rutaCarpeta, evidencia, "Se seleciona igual ");
		tiempoEspera(1000);
		//Assert.assertEquals((localizadorVariableXpath(txtResultado, resultadoEsperado).toString().contains(resultadoEsperado)), resultadoEsperado);
		//Assert.assertEquals((textoXpath(txtResultado)), resultadoEsperado, "El resultado es diferente al esperado");
		//tiempoEspera(1000);
	}
	
}
