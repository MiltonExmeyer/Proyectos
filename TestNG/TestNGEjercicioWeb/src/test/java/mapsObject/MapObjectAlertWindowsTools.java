package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectAlertWindowsTools extends ClaseBase
{

	public MapObjectAlertWindowsTools(WebDriver driver) 
	{
		super(driver);
	}
	
	// ELEMENTOS DE LA SECCION ALERT
	protected By btnAlertsInicial = By.xpath("//*[text()='Alerts']");
	// ALERT 1
	protected By btnAlerts = By.id("alertButton");
	// ALERT 2
	protected By btnAlertsTimer = By.id("timerAlertButton");
	// ALERT 3
	protected By btnAlertsConfirm = By.id("confirmButton");
	// ALERT 4
	protected By btnAlertsPromt= By.id("promtButton");

}
