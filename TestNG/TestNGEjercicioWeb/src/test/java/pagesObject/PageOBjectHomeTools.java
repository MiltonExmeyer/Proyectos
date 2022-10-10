package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectHomeToolsQA;

public class PageOBjectHomeTools extends MapObjectHomeToolsQA
{

	public PageOBjectHomeTools(WebDriver driver) 
	{
		super(driver);
		
	}

	//METODO INICIAL CON DATA EXCEL
		public void url(String url) throws IOException
		{
			driver.get(url);
			
		}
		
		public void buttonAlert(File rutaCarpeta, String evidencia) throws Exception, InterruptedException, IOException
		{
			
		scrollDown(200, 1);
		
		//METODO PARA INGRESAR A LA SECCION ALERTS
		tiempoEspera(1000);
		clickTools(btnHomeAlerts,rutaCarpeta, evidencia);
		tiempoEspera(1000);
		}
		
		public void buttonDate(File rutaCarpeta, String evidencia) throws Exception, InterruptedException, IOException
		{
			
		scrollDown(200, 1);
		//METODO PARA INGRESAR A LA SECCION WIDGETS
		tiempoEspera(1000);
		clickTools(btnHomeWidgets,rutaCarpeta, evidencia);
		tiempoEspera(1000);
		}
	}
	


