package semilleros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PagObjet.PagsObjet_Calculadora;
import io.appium.java_client.AppiumDriver;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;


public class runPrueba 
{
	@SuppressWarnings("rawtypes")
	//CRAR VALIABLES GLOBALES
	private AppiumDriver driver;
	PagsObjet_Calculadora calculadora;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	ClasesBase claseBase;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws IOException  
	{	
			 
		//INSTACIAR LA CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
		
		//INSTANCIAR LAS CLASES DE EXCEL
		leer = new ReadExcelFile();
		escribir= new WriteExcelFile();
		
		
		//CEREAR VARIBLE TIPO INPUTSTRING
		InputStream entrada = null;
		
		//VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try 
		{
			entrada= new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println(e);
		}	
		driver =ClasesBase.appiumDriverConnetion(propiedades);
		claseBase = new ClasesBase(driver);
		calculadora = new PagsObjet_Calculadora(driver);
				
	}		

	@Test
	public void calculadoraOperaciones() throws Exception 
	{		
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		//CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaFile = claseBase.crearCarpeta(propiedades,nomTest); 
		
		calculadora.calculadora(leer, rutaFile, propiedades, nomTest);
	}	
	
	
	@After
	public void cerrar()
	{
		//CERRAR PROCESO
		driver.quit();
	}
}
