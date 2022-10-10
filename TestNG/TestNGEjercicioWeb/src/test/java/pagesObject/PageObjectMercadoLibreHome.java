package pagesObject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import mapsObject.MapObjectMercadoLibreHome;

public class PageObjectMercadoLibreHome extends MapObjectMercadoLibreHome {
  public PageObjectMercadoLibreHome(WebDriver driver) 
  {
		super(driver);
  }
  
//METODO INICIAL CON DATA EXCEL
public void urlAcceso(String url) throws Exception
{
	driver.get(url);	
}

//METODO PRIMERA PRUEBA 
public void busquedaInicial(String producto, File rutaCarpeta, String evidencia) throws Exception, InterruptedException, IOException

{
	// INGRESAR ACCIONES
	//LIMPIAR CUADRO DE TEXTO
	borrar(txtBusqueda, rutaCarpeta, evidencia);
	//ENVIAR PRODUCTO DESDE EL EXCEL
	sendKey(producto, txtBusqueda, rutaCarpeta, evidencia);
	//SUMIT PARA BUSCAR EL PRODUCTO
	submit(txtBusqueda, rutaCarpeta, evidencia);
	//ACEPTAR COOKIES
	validacion(cookies, rutaCarpeta, evidencia);
	// GESTIONAR UBICACION
	validacion(ubicacion, rutaCarpeta, evidencia);
	//ELEGIR PRIMER EXCRITORIO
	click(primerProducto, rutaCarpeta, evidencia);
	//AGREGAR AL CARRITO
	click(agregarCarrito, rutaCarpeta, evidencia);	
	//CREAR CUENTA
	click(crearCuenta, rutaCarpeta, evidencia);
	
}

public void crearCuentaBtn(File rutaCarpeta, String evidencia) throws Exception
{		
	//CLICKEAR BOTON CREA TU CUENTA
	click(crearCuentaButton, rutaCarpeta, evidencia);
	//ACEPTAR COOKIES
	validacion(cookies, rutaCarpeta, evidencia);
	
}
  
}
