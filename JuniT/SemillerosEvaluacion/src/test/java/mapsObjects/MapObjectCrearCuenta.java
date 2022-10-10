package mapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectCrearCuenta extends ClaseBase {
	public MapObjectCrearCuenta(WebDriver driver)
	{
		super(driver);
	}

	protected By crearCuenta =By.xpath("//span[text()='Crear cuenta']");
	protected By autorizarDatos =By.id("terms-and-conds");
	protected By continuar=By.xpath("//span[text()='Continuar']");
	protected By validarEmail=By.xpath("//span[text()='Validar']");
	protected By ingresoEmail=By.xpath("//input[@class='andes-form-control__field']");
}
