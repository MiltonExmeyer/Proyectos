package mapsObject;

import org.openqa.selenium.By;

import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMercadoLibreHome extends ClaseBase
{

	public MapObjectMercadoLibreHome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	//ELEMENTOS DE LA PAG
	//protected By txtBusqueda=By.xpath("//android.widget.EditText[@text='']");
	protected By txtBusqueda=By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
	
	protected By imgPrimerElemento=By.xpath("(//android.widget.TextView)[6]");
	protected By btnComprarAhora=By.xpath("//android.widget.Button[@text='Comprar ahora']");
	
}
