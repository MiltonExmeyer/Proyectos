package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectMercuryTours extends ClaseBase
{

	public MapObjectMercuryTours(WebDriver driver) 
	{
		super(driver);	
	}

		//ELEMENTOS DE LA PAG PRINCIPAL
		protected By btnRegister=By.xpath("//*[text()='REGISTER']");
		
		// ELEMENTOS DEL FORMULARIO DE INSCRIPCION
		protected By txtName = By.name("firstName");
		protected By txtLastName = By.name("lastName");
		protected By txtPhone = By.name("phone");
		protected By txtEmail = By.id("userName");
		protected By txtAddress = By.name("address1");
		protected By txtCity = By.name("city");
		protected By txtState = By.name("state");
		protected By txtPostalCode = By.name("postalCode");

		// BUSCAR COMO SELECCIONAR UN ELEMENTO EN UN DROP LIST
		protected By selectCountry = By.xpath("//select[@name='country']");

		protected By txtEmailUser = By.id("email");
		protected By txtPassword = By.name("password");
		protected By txtConfirmPassword = By.name("confirmPassword");
		protected By btnSubmit = By.name("submit");
	
	
}
