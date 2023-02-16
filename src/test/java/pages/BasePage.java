package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;

import static utilities.DriverSetUp.getDriver;

import java.io.ByteArrayInputStream;

public class BasePage {
	
	// find locator
	public WebElement getElement(By locator) {
		return getDriver().findElement(locator);
		
	}
	// click method
	public void clickOnElement(By locator) {
		getElement(locator).click();
		
	}
	//Find  get text
	public String getElementText(By locator) {
	  return getElement(locator).getText();
	  
	}
	// sendkeys write Text
	public void writeTextOnElement(By locator, String text) {
		getElement(locator).sendKeys(text);
		
	}
	public void takeScreenShot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES) ));
	}
}
