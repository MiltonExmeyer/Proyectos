package pagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import mapsObjects.MapObjectRegisterMercury;
import utilidadesExcel.ReadExcelFile;

public class PageObjectRegisterMercury extends MapObjectRegisterMercury
{

	public PageObjectRegisterMercury(WebDriver driver) 
	{
		super(driver);
	}
	
	//METODO PARA UN SELECT 
	public void select(By locator, ReadExcelFile leer, Properties propiedades) throws Exception
	{
		Select pais = new Select(driver.findElement(locator));
		pais.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 10));
	}
	
	
	
	//METODO PRIMERA PRUEBA 
	public void formulario(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException

	{
		// INGRESAR ACCIONES

		//BORRAR
		borrar(txtName, rutaCarpeta);
		//ENVIAR TEXTO NOMBRE
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 2), txtName, rutaCarpeta);
		
		//BORRAR
		borrar(txtLastName, rutaCarpeta);
		//ENVIAR TEXTO APELLIDO
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 3), txtLastName, rutaCarpeta);
		
		//BORRAR
		borrar(txtPhone, rutaCarpeta);
		//ENVIAR TEXTO NUMERO DE CELULAR		
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 4), txtPhone, rutaCarpeta);
		
		//BORRAR
		borrar(txtEmail, rutaCarpeta);
		//ENVIAR TEXTO EMAIL
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 5), txtEmail, rutaCarpeta);
		
		//BORRAR
		borrar(txtAddress, rutaCarpeta);
		//ENVIAR TEXTO DIRECCION
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 6), txtAddress, rutaCarpeta);
		
		//BORRAR
		borrar(txtCity, rutaCarpeta);
		//ENVIAR TEXTO CIUDAD
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 7), txtCity, rutaCarpeta);
		
		//BORRAR
		borrar(txtState, rutaCarpeta);
		//ENVIAR TEXTO ESTADO
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 8), txtState, rutaCarpeta);
		
		//BORRAR
		borrar(txtPostalCode, rutaCarpeta);
		//ENVIAR TEXTO CODIGO POSTAL
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 9), txtPostalCode, rutaCarpeta);
		
		//SELECCIONAR EL PAIS
		//ENVIAR TEXTO
		select(selectCountry, leer, propiedades);
		
		//BORRAR
		borrar(txtEmailUser, rutaCarpeta);
		//ENVIAR TEXTO USUARIO 
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 11), txtEmailUser, rutaCarpeta);
		
		//BORRAR
		borrar(txtPassword, rutaCarpeta);
		//ENVIAR TEXTO CONTRASEÑA
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 12), txtPassword, rutaCarpeta);
		
		//BORRAR
		borrar(txtConfirmPassword, rutaCarpeta);
		//ENVIAR TEXTO CONFIRMAR CONTRASEÑA
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 1, 12), txtConfirmPassword, rutaCarpeta);
		tiempoEspera(2000);
		//CLICK BOTON ENVIAR 
		click(btnSubmit, rutaCarpeta);
		tiempoEspera(2000);
		//click(btnSubmit, rutaCarpeta);
		//tiempoEspera(2000);
		
	}

}
