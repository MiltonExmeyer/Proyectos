package mapsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectHome extends ClaseBase 
{
	//CONSTRUCTOR DE LA CLASE 
	public MapObjectHome(WebDriver driver) 
	{
		super(driver);
	}

	//ELEMENTOS DE LA PAG PRINCIPAL
	protected By btnHomeAlerts=By.xpath("//*[text()='Alerts, Frame & Windows']");
	protected By btnHomeWidgets=By.xpath("//*[text()='Widgets']");
	
	
}
