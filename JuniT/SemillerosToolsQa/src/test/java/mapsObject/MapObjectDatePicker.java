package mapsObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import claseBase.ClaseBase;

public class MapObjectDatePicker extends ClaseBase{

	public MapObjectDatePicker(WebDriver driver) 
	{
		super(driver);
	}
	//ELEMENTOS DE LA PAG PRINCIPAL
	
		protected By btnDatePicker = By.xpath("//*[text()='Date Picker']");
		protected By txtSelectDate= By.id("datePickerMonthYearInput");
		protected By meses = By.xpath("//select [@class='react-datepicker__month-select']");
		protected By diaUno = By.xpath("(//div[@class='react-datepicker__week']//*[text()='9'])[1]");
		protected By diaDos = By.xpath("(//div[@class='react-datepicker__week']//*[text()='8'])[1]");
		protected By año = By.xpath("//select[@class='react-datepicker__year-select']");
		
		protected By txtDataAndTime = By.id("dateAndTimePickerInput");
		protected By mesDos = By.xpath("//span [@class='react-datepicker__month-read-view--selected-month']");
		protected By hora =By.xpath("//*[text()='09:30']");
		
		protected By textSelectData= By.xpath("(//div[@class='col-md-3 col-sm-12'])[1]");
		protected By textDataAndTime= By.xpath("(//div[@class='col-md-3 col-sm-12'])[2]");
}