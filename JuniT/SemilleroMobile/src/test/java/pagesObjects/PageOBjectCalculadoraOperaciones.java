package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import mapsObject.MapObjectCalculadoraSuma;
import utilidadesExcel.ReadExcelFile;


public class PageOBjectCalculadoraOperaciones extends MapObjectCalculadoraSuma 
{

	public PageOBjectCalculadoraOperaciones(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		this.driver = (AppiumDriver<MobileElement>)driver;
	}
	
	public void suma(Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//PRIMER NUMERO

		click(btnNumero7, rutaCarpeta);
		//OPERACION 
		click(btnSuma, rutaCarpeta);
		//SEGUNDO NUMERO
		click(btnNumero2, rutaCarpeta);
		//RESULTADO
		click(btnResult, rutaCarpeta);
	}
	public void generic(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//PRIMER NUMERO
		//fileImputStream
		click(localizadorVariableXpath(btnNumeros,leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "calculadora", 1, 1)), rutaCarpeta);
		//OPERACION 
		click(localizadorVariableXpath(btnOperaciones,leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "calculadora", 1, 0)), rutaCarpeta);
		//SEGUNDO NUMERO
		click(localizadorVariableXpath(btnNumeros,leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "calculadora", 1, 2)), rutaCarpeta);
		//RESULTADO
		click(btnResult, rutaCarpeta);
	}
	
	
	/*
	//INTENTO DE ENVIAR TEXTO
	public void excelVarInt(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ENVIAR PRIMER NUMERO
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 2, 1), txtImput, rutaCarpeta);
		//OPERACION 
		click(localizadorVariableXpath(btnOperaciones,leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "calculadora", 1, 0)), rutaCarpeta);
		//ENVIAR SEGUNDO NUMERO
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 2, 2), txtImput, rutaCarpeta);
		//RESULTADO
		click(btnResult, rutaCarpeta);
	}
	*/
	
	//ENVIAR NUMEROS DE N TAMAÑO INT
	public void excelVarVar(ReadExcelFile leer,Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		//ENVIAR PRIMER NUMERO
		crearArray(leer, propiedades, btnNumeros, rutaCarpeta, 2, 1);
		//OPERACION 
		click(localizadorVariableXpath(btnOperaciones,leer.getCellValue(propiedades.getProperty("fileImputStreamData"), "calculadora", 2, 0)), rutaCarpeta);
		//ENVIAR SEGUNDO NUMERO
		crearArray(leer, propiedades, btnNumeros, rutaCarpeta, 2, 2);
		//RESULTADO
		click(btnResult, rutaCarpeta);
		tiempoEspera(2000);
	}
	
	
	
}
