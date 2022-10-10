package claseBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilidadesExcel.GenerarReportePdf;

public class ClaseBase 
{
	protected static WebDriver driver;
	
	// CONSTRUCTOR DE LA CLASE 
	public ClaseBase(WebDriver driver) 
	{
		super();
	}
	
	//METODO DEL NAVEGADOR
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
			captureScreen(rutaCarpeta, locator, "Si");
			driver.findElement(locator).click();
			tiempoEspera(1000);
			//captureScreen(rutaCarpeta);
		}
		
		//METODO BORRAR
		public void borrar (By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).clear();
			captureScreen(rutaCarpeta, locator, "Si");
		}
		
		//METODO BORRAR
		public void borrartxt (By locator, File rutaCarpeta) throws Exception
			{
				driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				captureScreen(rutaCarpeta, locator, "Si");
			}
		
		//METODO ENVIAR TEXTO
		public void sendKey(String string, By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(string);
			captureScreen(rutaCarpeta, locator, "Si");
		}
		
		//METODO REEMPLAZAR VALORES
		public void sendKeyValue(String string, By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"), string);
			captureScreen(rutaCarpeta, locator, "Si");
		}
		
		//METODO ENTER SUBMIT
		public void submit(By locator,  File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).submit();
			tiempoEspera(500);
			captureScreen(rutaCarpeta, locator, "Si" );
		}
		
		//METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			Thread.sleep(tiempo);
		}
		
		// SCROLL DOWN  200 PIXEL VERTICAL
		public void scrollDown(int y, int numMovimiento) throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int i=0; i<= numMovimiento; i++) {
			js.executeScript("window.scrollBy(0,"+y+")");
			}
		}
		
		//METODO TIEMPO DE ESPERA
		public void imprimirConsola(Exception mensaje) throws InterruptedException
		{
			System.out.println("e");
		}
		
		// TOMA DE EVIDENCIAS CON SCREENSHOT
		
		public void captureScreenBasic(File rutaCarpeta) throws Exception
		{
			//tiempoEspera(1000);
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
		}
		
		public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia) throws Exception
		{
			if(generarEvidencia.equals("Si"))
			{
			String hora = HoraSistema();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
			String rutaImagen = new File(rutaCarpeta+"\\"+hora+".png").toString();
			
			//INSTANCIAR CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			//SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearBody(locator, rutaImagen);
			
			//ELIMINAR IMAGEN CREADA
			eliminarArchivo(rutaImagen);
			}
		}
		
		public File crearCarpeta(Properties propiedades, String nomTest)
		{
			//ALMECENAMOS LA FECHA DEL SISTEMA 
			String fecha = fechaHora();
			//CREAMOS EL NOMBRE DE LA CARPETA
			String nomCarpeta = nomTest+"-"+fecha;
			//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR 
			File directorio = new File("./output/"+nomCarpeta);
			//C:\Users\HP\eclipse-workspace\SemilleroToolsQa\output
			//CREAMOS LA CARPETA ./Properties/output
			directorio.mkdir();
			return directorio;
		}
		
		
		public static String  fechaHora() 
		{
			//TOMAR LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
			//DAR FORMATO A LA FECHA DEL SISTEMA 
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
			
		}
		
		public static String  fechaHoraDos() 
		{
			//TOMAR LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistema = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA 
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
			
		}
		
		public void eliminarArchivo(String rutaImagen)
		{
			File fichero = new File(rutaImagen);
			fichero.delete();
		}
		
		
		public String  fechaHoraToolsQa() 
		{
			//TOMAR LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistemaToolsQa = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			DateTimeFormatter fechaToolQa = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");
			//DAR FORMATO A LA FECHA DEL SISTEMA 
			String formatFechaToolsQa = fechaToolQa.format(fechaSistemaToolsQa);
			return formatFechaToolsQa;
			
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
