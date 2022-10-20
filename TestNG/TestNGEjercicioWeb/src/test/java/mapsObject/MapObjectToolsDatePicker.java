package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectToolsDatePicker extends ClaseBase {

	public MapObjectToolsDatePicker(WebDriver driver) {
		super(driver);
	}

	// ELEMENTOS DE LA PAG PRINCIPAL
	// BTN SECCION DATE
	protected By btnDatePicker = By.xpath("//*[text()='Date Picker']");
	// CUADRO DE TEXTO FECHA
	protected By txtSelectDate = By.id("datePickerMonthYearInput");//
	// CUADRO DE TEXTO FECHA Y HORA
	protected By txtDataAndTime = By.id("dateAndTimePickerInput");//
	// ELEMENTO PARA REALIZAR CLICK Y VISUALIZAR DATA EN REPORTE
	protected By textDataAndTime = By.xpath("(//div[@class='col-md-3 col-sm-12'])[2]");//

}
