package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectHomeToolsQA extends ClaseBase
{

	public MapObjectHomeToolsQA(WebDriver driver) 
	{
		super(driver);	
	}
	//ELEMENTOS DE LA PAG PRINCIPAL
	protected By btnHomeAlerts=By.xpath("//*[text()='Alerts, Frame & Windows']");
	protected By btnHomeWidgets=By.xpath("//*[text()='Widgets']");

}
