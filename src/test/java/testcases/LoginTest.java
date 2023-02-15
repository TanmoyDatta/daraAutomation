package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.DarazLoginPage;
import utilities.Dataset;
import utilities.DriverSetUp;

public class LoginTest extends DriverSetUp{
	DarazLoginPage darazLoginPage = new DarazLoginPage();
	
	@Test
	public void testLoginWithInValidCredentials() {
		getDriver().get(darazLoginPage.LOGIN_PAGE_URL);
		darazLoginPage.doLogin("0111111111","password");
		assertEquals(darazLoginPage.getErrorMassage(), darazLoginPage.LOGIN_ERORR_MASSAGE);
	}
	
	@Test
	public void testLoginWithValidPhnInValidpasswordCredentials() {
		getDriver().get(darazLoginPage.LOGIN_PAGE_URL);
		darazLoginPage.doLogin("01378154154","password");
		assertEquals(darazLoginPage.getErrorMassage(), darazLoginPage.LOGIN_ERORR_MASSAGE2);
	}
	
	@Test(dataProvider = "InvalidCredensial",dataProviderClass = Dataset.class)
	public void testLogInWithInvalidCredentialsUsingDataprovider(String username, String password, String massage) {
		getDriver().get(darazLoginPage.LOGIN_PAGE_URL);
		darazLoginPage.doLogin(username,password);
		assertEquals(darazLoginPage.getErrorMassage(),massage);
		
	}

}
