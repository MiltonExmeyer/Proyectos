package mapsObject;
import org.openqa.selenium.By;
import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectCalculadoraSuma extends ClaseBase 
{
	//CONSTRUCTOR DE LA CLASE 
	public MapObjectCalculadoraSuma(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}

	//ELEMENTOS DE LA PAG PRINCIPAL
	//BTN OPERACIONA BASICAS
	protected By btnOperaciones =By.xpath("//android.widget.ImageButton[@content-desc='{0}']");
	
	protected By btnSuma=By.id("com.google.android.calculator:id/op_add");
	//RESULTADO
	protected By btnResult = By.id("com.google.android.calculator:id/eq");
	
	//BTN NUMEROS
	protected By btnNumeros= By.xpath("//android.widget.ImageButton[@content-desc='{0}']");
	
	protected By btnNumero7= By.id("com.google.android.calculator:id/digit_7");
	protected By btnNumero2= By.id("com.google.android.calculator:id/digit_2");
	
}
