package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObjects.MapObjectHomeMercury;
import utilidadesExcel.ReadExcelFile;

public class PageObjectHomeMercury extends MapObjectHomeMercury
{

	public PageObjectHomeMercury(WebDriver driver) 
	{
		super(driver);
	}

	//METODO INICIAL CON DATA EXCEL
	public void urlAcceso(ReadExcelFile leer, Properties propiedades) throws IOException
	{
		driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 0));
		//FILA, COLUMNA
	}

	//METODO PRIMERA PRUEBA 
	public void homeMercury(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException

	{
		// INGRESAR ACCIONES
		//BOTON REGISTER 
		tiempoEspera(1000);
		click(btnRegister, rutaCarpeta);
		tiempoEspera(1000);
		
	}
	
	
}
