package Test.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTheInternetTests {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		FirefoxProfile profile = new FirefoxProfile();
		// preferintele au fost setate pentru a functiona testele pe setup-ul de lucru
		profile.setPreference("network.proxy.type", 4);
		profile.setPreference("network.proxy.autoconfig_url", "http://wpad.intel.com/wpad.dat");
		driver= new FirefoxDriver(profile);
	}
	
	@Test
	public void getAllFilesFromFileDownloadSection(){
		MainPageTheInternet main = new MainPageTheInternet(driver).get();
		main.accessFileDownloadSection();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
