package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.DarazHomePage;
import pages.DarazLoginPage;
import utilities.DriverSetUp;
import utilities.Drivers;

public class HomePageTest extends DriverSetUp{
	DarazHomePage darazHomePage = new DarazHomePage();
	DarazLoginPage darazLoginPage = new DarazLoginPage();
	@Test
	public void HomePageTitle() throws InterruptedException {	
		getDriver().get("https://www.daraz.com.bd/");
		assertEquals(getDriver().getTitle(), darazHomePage.HOME_PAGE_TITLE);
		// WebElement loginButton = darazHomePage.getElement(darazHomePage.SIGNUP_LOGIN_BUTTON); // withOut method click part
		// loginButton.click();
		
		// get element text
		System.out.println(darazHomePage.getElementText(darazHomePage.SIGNUP_LOGIN_BUTTON));
		
		// clickOnMehtod called
		darazHomePage.clickOnElement(darazHomePage.SIGNUP_LOGIN_BUTTON);
		
		darazLoginPage.doLogin("0111111111","password");
		
	}
}