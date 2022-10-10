package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import mapsObject.MapObjectMercuryTours;

public class PagObjectMercuryTours extends MapObjectMercuryTours {

	public PagObjectMercuryTours(WebDriver driver) {
		super(driver);
	}

	// METODO INICIAL CON DATA EXCEL
	public void urlAcceso(String url) throws IOException {
		driver.get(url);
	}

	// METODO PRIMERA PRUEBA
	public void homeMercury(File rutaCarpeta, String evidencia) throws Exception, InterruptedException, IOException

	{
		// INGRESAR ACCIONES
		// BOTON REGISTER
		tiempoEspera(1000);
		click(btnRegister, rutaCarpeta, evidencia);
		tiempoEspera(1000);
	}

	// METODO PARA UN SELECT
	public void select(By locator, File rutaCarpeta ,String evidencia,String country) throws Exception {
		Select paisList = new Select(driver.findElement(locator));
		paisList.selectByValue(country);

	}

	// METODO PRIMERA PRUEBA
	public void formulario(File rutaCarpeta, String evidencia, String firstName, String lastName, String phone,
			String email, String address, String city, String stateProvince, String postalCode, String country,
			String userName, String password, String confirmPassword)
			throws Exception, InterruptedException, IOException

	{
		// INGRESAR ACCIONES

		// BORRAR
		borrar(txtName, rutaCarpeta, evidencia);
		// ENVIAR TEXTO NOMBRE
		sendKey(firstName, txtName, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtLastName, rutaCarpeta, evidencia);
		// ENVIAR TEXTO APELLIDO
		sendKey(lastName, txtLastName, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtPhone, rutaCarpeta, evidencia);
		// ENVIAR TEXTO NUMERO DE CELULAR
		sendKey(phone, txtPhone, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtEmail, rutaCarpeta, evidencia);
		// ENVIAR TEXTO EMAIL
		sendKey(email, txtEmail, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtAddress, rutaCarpeta, evidencia);
		// ENVIAR TEXTO DIRECCION
		sendKey(address, txtAddress, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtCity, rutaCarpeta, evidencia);
		// ENVIAR TEXTO CIUDAD
		sendKey(city, txtCity, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtState, rutaCarpeta, evidencia);
		// ENVIAR TEXTO ESTADO
		sendKey(stateProvince, txtState, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtPostalCode, rutaCarpeta, evidencia);
		// ENVIAR TEXTO CODIGO POSTAL
		sendKey(postalCode, txtPostalCode, rutaCarpeta, evidencia);

		// SELECCIONAR EL PAIS
		// ENVIAR TEXTO
		select(selectCountry, rutaCarpeta, evidencia, country);

		// BORRAR
		borrar(txtEmailUser, rutaCarpeta, evidencia);
		// ENVIAR TEXTO USUARIO
		sendKey(userName, txtEmailUser, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtPassword, rutaCarpeta, evidencia);
		// ENVIAR TEXTO CONTRASEÑA
		sendKey(password, txtPassword, rutaCarpeta, evidencia);

		// BORRAR
		borrar(txtConfirmPassword, rutaCarpeta, evidencia);
		// ENVIAR TEXTO CONFIRMAR CONTRASEÑA
		sendKey(confirmPassword, txtConfirmPassword, rutaCarpeta, evidencia);
		tiempoEspera(2000);
		// CLICK BOTON ENVIAR
		click(btnSubmit, rutaCarpeta, evidencia);
		tiempoEspera(2000);
		// click(btnSubmit, rutaCarpeta);
		// tiempoEspera(2000);

	}
}
