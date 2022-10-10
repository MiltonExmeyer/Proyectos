package mapsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import claseBase.ClaseBase;

public class MapObjectMercadoLibreCuenta extends  ClaseBase 
{

	public MapObjectMercadoLibreCuenta(WebDriver driver) 
	{
		super(driver);
	}
	//ELEMENTOS DE LA PAG
	protected By crearCuenta =By.xpath("//span[text()='Crear cuenta']");
	protected By autorizarDatos =By.id("terms-and-conds");
	protected By continuar=By.xpath("//span[text()='Continuar']");
	protected By validarEmail=By.xpath("//span[text()='Validar']");
	protected By ingresoEmail=By.xpath("//input[@class='andes-form-control__field']");
}
