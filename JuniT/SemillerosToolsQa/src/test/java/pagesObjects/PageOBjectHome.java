package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectHome;
import utilidadesExcel.ReadExcelFile;

public class PageOBjectHome extends MapObjectHome {

	public PageOBjectHome(WebDriver driver) 
	{
		super(driver);
	}

	//METODO INICIAL CON DATA EXCEL
	public void url(ReadExcelFile leer, Properties propiedades) throws IOException
	{
		driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"),"url", 1, 0));
		//FILA, COLUMNA
	}
	
	public void buttonAlert(Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		
	scrollDown(200, 1);
	
	//METODO PARA INGRESAR A LA SECCION ALERTS
	tiempoEspera(1000);
	click(btnHomeAlerts,rutaCarpeta);
	tiempoEspera(1000);
	}
	
	public void buttonDate(Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException
	{
		
	scrollDown(200, 1);
	//METODO PARA INGRESAR A LA SECCION WIDGETS
	tiempoEspera(1000);
	click(btnHomeWidgets,rutaCarpeta);
	tiempoEspera(1000);
	}
}
