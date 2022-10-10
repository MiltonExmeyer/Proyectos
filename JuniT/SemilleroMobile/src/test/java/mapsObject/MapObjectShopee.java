package mapsObject;

import org.openqa.selenium.By;

import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectShopee extends ClaseBase
{

	public MapObjectShopee(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}
	
	//ELEMENTOS DE LA PAG PRINCIPAL
	//BOTON YO
	protected By btnI=By.xpath("(//android.widget.ImageView[@resource-id='com.shopee.co:id/tab_animation_icon'])[4]");
	//BOTON INICIAR SESION
	protected By btnIniciarSesion= By.xpath("//android.widget.TextView[@text='Iniciar sesión']");
	//CAMPO USERNAME
	protected By txtUser=By.xpath("(//android.widget.EditText)[1]");
	//CAMPO PASSWORD
	protected By txtPassword=By.xpath("(//android.widget.EditText)[2]");
	//BOTON INICIAR SESION
	protected By btnIniciarSesionDos= By.xpath("(//android.widget.TextView[@text='Inicia sesión'])[2]");
	//BOTON HOME
	protected By btnHome=By.xpath("(//android.widget.ImageView[@resource-id='com.shopee.co:id/tab_animation_icon'])[1]");
	//CAMPO BUSCAR
	protected By txtBuscar=By.xpath("(//android.widget.TextView)[1]");
	
	protected By btnAtrasUno=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
	protected By btnAtrasDos= By.xpath("//android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView");

}
