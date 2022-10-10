package mapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectHomeMercury extends ClaseBase
{

	public MapObjectHomeMercury(WebDriver driver) 
	{
		super(driver);
		
	}
	//ELEMENTOS DE LA PAG PRINCIPAL
	protected By btnRegister=By.xpath("//*[text()='REGISTER']");
}
