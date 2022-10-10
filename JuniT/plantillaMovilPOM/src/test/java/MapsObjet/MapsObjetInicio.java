package MapsObjet;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import semilleros.ClasesBase;


public class MapsObjetInicio  extends ClasesBase
{
	
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetInicio( AppiumDriver<MobileElement> driver) 
	{
		super(driver);
	}
	
	//ELEMENTOS PAGINA INICIAL 	
	protected By txtbuscarProducto =By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
	protected By linkmercadolibre =By.xpath("//android.view.View[@text='Mercado Libre Ecuador']");
	protected By txtbuscarProducto1 =By.xpath("//android.widget.EditText[@text='{0}']");
	protected By enter =By.xpath("//android.widget.TextView[@text='Mercado Libre Ecuador - Envíos Gratis en el día']");
	protected By txtBuscadorGoogle =By.id("com.android.chrome:id/search_box_text");
	protected By primerproducto =By.xpath("//android.view.View[@resource-id='root-app']/android.widget.ListView[2]/android.view.View[1]");
	
	protected By comprarAhora =By.xpath("//android.widget.Button[@text='Comprar ahora']");
	}
 