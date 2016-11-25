package Test.TheInternet;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DynamicLoadingTheInternetTests {
	private WebDriver driver;

	@Before
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		// preferintele au fost setate pentru a functiona testele pe setup-ul de
		// lucru
		profile.setPreference("network.proxy.type", 4);
		profile.setPreference("network.proxy.autoconfig_url", "http://wpad.intel.com/wpad.dat");
		driver = new FirefoxDriver(profile);
	}

	@Test
	public void dynamicLoadingOutput() {
		MainPageTheInternet main = new MainPageTheInternet(driver).get();
		DynamicLoadingTheInternet dynamic = main.accessDynamicLoadingSection();
		WebElement dynamicOutput = dynamic.clickOnExample2();
		assertTrue("Hello World! message is not displayed properly", dynamicOutput.getText().equals("Hello World!"));

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
