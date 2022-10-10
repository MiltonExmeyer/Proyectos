package semilleros;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.AndroidKey;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class ClasesBase 
{
	private static final Logger log= Logger.getLogger(ClasesBase.class);
	
	protected AppiumDriver<MobileElement> driver;

	//CONSTRUCTOR DE CLASE
	public ClasesBase(WebDriver driver) 
	{
		super(); 
	}

	//METODO DE NAVEGADOR
	
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnetion(Properties propiedades) 
	{
		AppiumDriver driver = null; 
		try
		{
			// CREARLAS CAPABILITYS DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", propiedades.getProperty("platformName"));
			caps.setCapability("deviceName", propiedades.getProperty("deviceName"));
			caps.setCapability("platformVersion", propiedades.getProperty("platformVersion"));
			caps.setCapability("appPackage", propiedades.getProperty("appPackage"));
			caps.setCapability("appActivity", propiedades.getProperty("appActivity"));
			caps.setCapability("noReset", propiedades.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions", propiedades.getProperty("autoGrantPermissions"));
			
			caps.setCapability("unicodeKeyboard", "true");                                     
			caps.setCapability("resetKeyboard", "true");
			
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
	
	public static void printConsola(String texto) 
	{
		System.out.println(texto);
	}

	//METODO CLIK
	public void click(String string, By locator, File rutaFile, int time) throws Exception 
	{
		try 
		{
			driver.findElement(locator).click();
			tiempoEspera(time);
			captureScreen(rutaFile);			
		} 
		catch (Exception e) 
		{
			log.error(e);
		}		
	}
	
	

	//METODO BORRAR
	public void borrar(By locator) throws Exception 
	{
		driver.findElement(locator).clear();
		//captureScreen(rutaCarpeta);
		log.debug("click sobre el objeto: "+locator);
	}

	//METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator, File rutaFile, int time)
	{
		try 
		{
			driver.findElement(locator).sendKeys(inputText);
			
			captureScreen(rutaFile);
			tiempoEspera(time);
			
		} 
		catch (Exception e) 
		{
			log.error(e);
		}
	}
	public void enter(File rutaFile, int time)throws Exception
    {
       // String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        tiempoEspera(time);
        captureScreen(rutaFile);
    }
	
	
	//METODO ENTER SUBMIN
	public void submit(By locator) throws Exception 
	{
		driver.findElement(locator).submit();
		//captureScreen(rutaCarpeta);
	}
	//METODO PARA REEMPLAZAR
	public By localizadorVariable(By locator,String valor) throws Exception 
	{
		String jj = locator.toString().replace("{0}", valor);
		String kk = jj.replace("By.xpath:", "");
		By localizador=By.xpath(kk);
		return localizador;
	}
	
	
	
	//METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException 
	{
		Thread.sleep(tiempo*1000);
	}
	
	public void captureScreen(File rutaCarpeta) throws Exception 
	{
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
	}
	
	public File crearCarpeta(Properties propiedades, String nomTest)
	{
		//ALCACENAMOS LA FECHA DEL SITEMA
		String fecha = fechaHora();
		//CCREARMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		//OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/"+nomCarpeta+"/");
		//CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;		 
	}
	
	public String fechaHora()
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		//DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);		
		return formatFecha;
	}
	
	
	public String HoraSistema()
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		//DAR FORMATO A LA FECHA DEL SITEMA
		String hora = fecha.format(horaSistema);		
		return hora;
	}

	public void scrollVertical(File rutaFile, int xini,int yini, int yfinal, int iteraciones) throws Exception 
	{
		
		for (int i = 1 ;i<=iteraciones;i++) 
		{
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini,yini))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
			.moveTo(PointOption.point(xini,yfinal))
			.release().perform();
			captureScreen(rutaFile);
		}
	}
	
	public void tocarPantalla(int time) throws InterruptedException 
	{
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(109,244)).release().perform();
		tiempoEspera(time);
	}
	
	public boolean elemtoPresente(By locator) 
	{
		boolean estado = driver.findElement(locator).isDisplayed();
		return estado;
	}
	
	
	
}
