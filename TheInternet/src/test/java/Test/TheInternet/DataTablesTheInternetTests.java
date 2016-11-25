package Test.TheInternet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class DataTablesTheInternetTests {

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
	public void sortTable2() {
		MainPageTheInternet main = new MainPageTheInternet(driver).get();
		DataTablesTheInternet data = main.accessTablesSection();
		assertTrue("Sortable Data Tables section was not displayed properly", data.table2.isDisplayed());
		data.firstNamefieldNoSorting.click();
		assertTrue("Sorting by First Name was not performed properly",
				data.firstNamefieldSortDown_alphabetically.isDisplayed());

		// extra checking
		assertTrue("Table is not ordered alphabetically after First Name",
				data.areFirstNamesOrderedAlphabetically());

	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
