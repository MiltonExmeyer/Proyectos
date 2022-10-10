package pagesObjects;

import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import mapsObjects.MapsObjectsPagPrincipal;
import utilidadesExcel.ReadExcelFile;

public class PagesObjectsPagPrincipal extends MapsObjectsPagPrincipal
{
	//String producto = null;
	
	public PagesObjectsPagPrincipal(WebDriver driver)
	{
		super(driver);
	}

//METODO INICIAL CON DATA EXCEL
public void urlAcceso(ReadExcelFile leer, Properties propiedades) throws IOException
{
	driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 1, 0));
	//FILA, COLUMNA
}

//METODO PRIMERA PRUEBA 
public void busquedaInicial(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception, InterruptedException, IOException

{
	// INGRESAR ACCIONES
	//BORRAR
	borrar(txtBusqueda, rutaCarpeta);
	//ENVIAR TEXTO
	//sendKey("silla",txtBusqueda);
	//sendKey(propiedades.getProperty("producto"),txtBusqueda);
	sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 4, 1), txtBusqueda, rutaCarpeta);
	submit(txtBusqueda, rutaCarpeta);
	//ACEPTAR COOKIES
	click(cookies, rutaCarpeta);
	// GESTIONAR UBICACION
	click(ubicacion, rutaCarpeta);
	//ELEGIR PRIMER EXCRITORIO
	click(primerProducto, rutaCarpeta);
	//AGREGAR AL CARRITO
	click(agregarCarrito, rutaCarpeta);	
	//CREAR CUENTA
	click(crearCuenta, rutaCarpeta);
	
}

public void crearCuentaBtn(Properties propiedades, File rutaCarpeta) throws Exception
{		
	//CLICKEAR BOTON CREA TU CUENTA
	click(crearCuentaButton, rutaCarpeta);
	//ACEPTAR COOKIES
	click(cookies, rutaCarpeta);
	
}

}