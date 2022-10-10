package claseBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClaseBase 
{		
	protected static WebDriver driver;
	
	//CONSTRUCTOR DE CLASE
	public ClaseBase (WebDriver driver)
	{
		super();
	}
	
	//METODO DE NAVEGADOR
	public static WebDriver chomeDriverConnetion()
	{
		//SETEAR LAS OPCIONES DEL NAVEGADOR 
		//DEFINIR ESTRATEGIA DE CARGA DE LA PAG
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//SETEAR PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//MAXIMIZAR VENTANA DEL NAVEGADOR
		driver.manage().window().maximize();
		
		return driver;
	}
	//InterruptedException
	//METODO CLICK 
	public void click(By locator, File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).click();
		tiempoEspera(1000);
		captureScreen(rutaCarpeta);
	}
	
	//METODO BORRAR
	public void borrar (By locator, File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}
	
	//METODO ENVIAR TEXTO
	public void sendKey(String string, By locator, File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).sendKeys(string);
		captureScreen(rutaCarpeta);
	}
	
	
	//METODO ENTER SUBMIT
	public void submit(By locator,  File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).submit();
		tiempoEspera(1000);
		captureScreen(rutaCarpeta);
	}
	
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException
	{
		Thread.sleep(tiempo);
	}
	
	
	//MENSAJE CONSOLA
	public void imprimirConsola(Exception mensaje) throws InterruptedException
	{
		System.out.println("e");
	}
	
	/*
	//METODO PARA UN SELECT 
	public void select(By locator, ReadExcelFile leer, Properties propiedades) throws Exception
		{
		Select pais = new Select(driver.findElement(locator));
		pais.selectByValue(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercury", 9, 2));
		}
	*/
	
	// TOMA DE EVIDENCIAS CON SCREENSHOT
	
	public void captureScreen(File rutaCarpeta) throws Exception
	{
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
	}
	
	public File crearCarpeta(Properties propiedades, String nomTest)
	{
		//ALMECENAMOS LA FECHA DEL SISTEMA 
		String fecha = fechaHora();
		//CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR 
		File directorio = new File("./output/"+nomCarpeta);
		//CREAMOS LA CARPETA ./Properties/output
		directorio.mkdir();
		return directorio;
	}
	
	public String  fechaHora() 
	{
		//TOMAR LA FECHA DEL SISTEMA 
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SISTEMA 
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha; 
	}
	
	public String HoraSistema ()
	{
		//TOMAR LA HORA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	
}
