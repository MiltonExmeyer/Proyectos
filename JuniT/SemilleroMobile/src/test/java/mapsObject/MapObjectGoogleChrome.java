package mapsObject;

import org.openqa.selenium.By;

import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectGoogleChrome extends ClaseBase
{

	public MapObjectGoogleChrome(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		
	}
	
	//ELEMENTOS DE LA PAG PRINCIPAL
		//BOTON YO
		protected By btnOpciones=By.id("com.android.chrome:id/menu_button");
		protected By btnNuevaPestaña=By.xpath("//android.widget.TextView[@text='Nueva pestaña']");
		protected By txtBuscar = By.id("com.android.chrome:id/search_box_text");
		//com.android.chrome:id/url_bar
		protected By txtBuscarDos = By.id("com.android.chrome:id/url_bar");
}
