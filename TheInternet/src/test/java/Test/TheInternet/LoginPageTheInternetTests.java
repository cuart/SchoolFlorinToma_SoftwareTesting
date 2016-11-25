package Test.TheInternet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import static org.junit.Assert.assertTrue;

public class LoginPageTheInternetTests {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		FirefoxProfile profile = new FirefoxProfile();
		// preferintele au fost setate pentru a functiona testele pe setup-ul de lucru
		profile.setPreference("network.proxy.type", 4);
		profile.setPreference("network.proxy.autoconfig_url", "http://wpad.intel.com/wpad.dat");
		driver= new FirefoxDriver(profile);
	}
	
	@Test
	public void loginSuccessully(){
		MainPageTheInternet main = new MainPageTheInternet(driver).get();
		main.accessFormAuthentication();
		LoginPageTheInternet login = new LoginPageTheInternet(driver).get();
		assertTrue("Login Button from login page is displayed", login.loginBtn.isDisplayed());
		SecureAreaTheInternet secure = login.loginSuccessfully();
		assertTrue("Login action was not successfully performed / LogoutBtn is not displayed", secure.logoutBtn.isDisplayed());
		secure.logoutAction();
		assertTrue("Logout action was not successfully performed ", login.loginBtn.isDisplayed());
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
