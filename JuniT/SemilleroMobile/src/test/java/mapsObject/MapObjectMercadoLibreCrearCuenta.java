package mapsObject;

import org.openqa.selenium.By;

import claseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectMercadoLibreCrearCuenta extends ClaseBase
{

	public MapObjectMercadoLibreCrearCuenta(AppiumDriver<MobileElement> driver) 
	{
		super(driver);
		
	}

	//ELEMENTOS DE LA PAG
		protected By btnCrearCuenta=By.xpath("//android.view.View[@content-desc='Crear cuenta']");
		protected By txtNombre=By.xpath("(//android.widget.EditText)[1]");
		protected By txtApellido=By.xpath("(//android.widget.EditText)[2]");
		protected By txtDocumento=By.xpath("(//android.widget.EditText)[3]");
		protected By txtEmail=By.xpath("(//android.widget.EditText)[4]");
		protected By txtClave=By.xpath("(//android.widget.EditText)[5]");
		
		protected By checkboxAceptarTerm=By.xpath("//android.widget.CheckBox[@text='Acepto los Términos y condiciones (abrirá una nueva ventana) y autorizo el uso de mis datos de acuerdo a la Declaración de Privacidad (abrirá una nueva ventana) .']");
		protected By btnCatcha=By.xpath("//android.widget.CheckBox[@text='No soy un robot']");
}
