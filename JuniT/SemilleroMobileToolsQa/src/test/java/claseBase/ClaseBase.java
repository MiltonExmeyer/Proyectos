package claseBase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidades.ReadExcelFile;


public class ClaseBase 
{

	@SuppressWarnings("rawtypes")
	protected AppiumDriver driver;
	
	// CONSTRUCTOR DE LA CLASE 
	public ClaseBase( AppiumDriver<MobileElement> driver) 
	{
		super();
	}
	
	//METODO DEL NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades, ReadExcelFile leer, String hoja, int fil, int col)
    {
        AppiumDriver driver = null;
        try
        {
            // CREARLAS CAPABILITYS DEL MOVIL
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName",propiedades.getProperty("plataformName"));
			caps.setCapability("deviceName",propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion",propiedades.getProperty("platformVersion"));		
			caps.setCapability("appPackage",leer.getCellValue(propiedades.getProperty("fileImputStreamData"), ""+hoja+"", fil, col));
			caps.setCapability("appActivity",leer.getCellValue(propiedades.getProperty("fileImputStreamData"), ""+hoja+"", fil, col+1));
			caps.setCapability("noReset",propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions",propiedades.getProperty("autoGrantPermissions"));
            
            //INSTANCIAR APPIUM DRIVER
            try
            {
                printConsola("cargando capability de appium, favor esperar ....");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);                    
                
            }
            catch (MalformedURLException e)
            {
                printConsola(e.getMessage());
            }
        return driver;
        }
        catch (Exception e)
        {
            printConsola(e.getMessage());
        }
        return driver;
    }
	
	
		private static void printConsola(String string) {
		// TODO Auto-generated method stub
	}

		//METODO CLICK 
		public void click(By locator, File rutaCarpeta ) throws Exception
		{
			driver.findElement(locator).click();
			captureScreen(rutaCarpeta);
		}
		//METODO CLICK TIME
		public void clickTime(By locator, File rutaCarpeta, int time ) throws Exception
		{
			driver.findElement(locator).click();
			tiempoEspera(time*1000);
			captureScreen(rutaCarpeta);
		}
		
		//METODO BORRAR
		public void borrar (By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).clear();
			captureScreen(rutaCarpeta);
		}
		
		//METODO BORRAR TEXTO
		public void borrartxt (By locator, File rutaCarpeta) throws Exception
			{
				driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
				captureScreen(rutaCarpeta);
			}
		
		//METODO ENVIAR TEXTO
		public void sendKey(String string, By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(string);
			captureScreen(rutaCarpeta);
		}
		
		//METODO REEMPLAZAR VALORES
		public void sendKeyValue(String string, By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"), string);
			captureScreen(rutaCarpeta);
		}
		
		//METODO ENTER SUBMIT
		public void submit(By locator,  File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).submit();
			tiempoEspera(500);
			captureScreen(rutaCarpeta);
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
		
		//METODO IMPRIMIR CONSOLA
		public void imprimirConsola(Exception mensaje) throws InterruptedException
		{
			System.out.println("e");
		}
		
		//LOCALIZAR VARIABLE
		public By localizadorVariableId(By locator, String valor) throws Exception
		{
			String jj = locator.toString().replace("{0}", valor);
			String kk =jj.replace("By.id:", " ");
			By localizador = By.id(kk);
			return localizador;
		}
		//LOCALIZAR VARIABLE
		public By localizadorVariableXpath(By locator, String valor) throws Exception
		{
			String jj = locator.toString().replace("{0}", valor);
			String kk =jj.replace("By.xpath:", "");
			By localizador = By.xpath(kk);
			return localizador;
				}
		
		
		// TOMA DE EVIDENCIAS CON SCREENSHOT
		
		public void captureScreen(File rutaCarpeta) throws Exception
		{
			//tiempoEspera(1000);
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
			//C:\Users\HP\eclipse-workspace\SemilleroToolsQa\output
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
		
		public String  fechaHoraToolsQa() 
		{
			//TOMAR LA FECHA DEL SISTEMA 
			LocalDateTime fechaSistemaToolsQa = LocalDateTime.now();
			//DEFINIR FORMATO FECHA
			//DateTimeFormatter fechaToolQa = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
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
		
		public void crearArrayMio(String numExcel, ReadExcelFile leer, Properties propiedades, By locator, File rutaCarpeta) throws Exception
		{
			//CAPTURAR VALOR DEL EXCEL 
			String numero = (leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"", 1, 1));
			String [] listNumero = new String[numero.length()];
			for (int i=0; i<listNumero.length; i++)
			{
				listNumero[i]=String.valueOf(numero.charAt(i));
				click(localizadorVariableXpath(locator, listNumero[i]),rutaCarpeta);
			}
		}
		
		public void crearArray(ReadExcelFile leer, Properties propiedades, By locator, File rutaCarpeta, int fila, int columna) throws Exception
		{
			char [] numero = null;
			//CAPTURAR VALOR DEL EXCEL 
			numero = leer.getCellValue(propiedades.getProperty("fileImputStreamData"),"calculadora", fila, columna).toCharArray();
			for (int i=0; i<numero.length; i++)
			{
				String value = String.valueOf(numero[i]);
				click(localizadorVariableXpath(locator, value),rutaCarpeta);
			}
			
		}
		
		 public void tocarPantalla(int x, int y)
		 {
			 @SuppressWarnings("rawtypes")
		     TouchAction touch = new TouchAction(driver);
			 touch.press(PointOption.point(x,y)).release().perform();
		        
		  }
		 
		 public void scrollVertical(File rutaCarpeta, int xini,int yini, int yfinal, int iteraciones) throws Exception
		    {
		        
		        for (int i = 1 ;i<=iteraciones;i++)
		        {
		            @SuppressWarnings("rawtypes")
		            TouchAction touch = new TouchAction(driver);
		            touch.press(PointOption.point(xini,yini))
		            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		            .moveTo(PointOption.point(xini,yfinal))
		            .release().perform();		            
		        }
		        captureScreen(rutaCarpeta);
		    }
		 
		 //METODO ENTER 
		 @SuppressWarnings("unchecked")
		public void enter(File rutaCarpeta)throws Exception
	        {
	            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	            tiempoEspera(2000);
	            captureScreen(rutaCarpeta);
	        }
}
