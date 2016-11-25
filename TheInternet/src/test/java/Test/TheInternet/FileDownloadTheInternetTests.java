package Test.TheInternet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class FileDownloadTheInternetTests {
	private WebDriver driver;
	
		
	//[href='download/some-file.txt']
	
	@Before
	public void setUp(){
		FirefoxProfile profile = new FirefoxProfile();
		
		// /* to be able to download a file as soon as a click is performed
		profile.setPreference("browser.download.folderList",2);
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("browser.download.dir","C:\\Users\\ftoma\\Desktop\\FileDownload");
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/txt, image/png");
		
		
		//networking and proxy settings
		profile.setPreference("network.proxy.type", 4);
		profile.setPreference("network.proxy.autoconfig_url", "http://wpad.intel.com/wpad.dat");
		
		driver=new FirefoxDriver(profile);
	}
	
	@Test
	public void downloadFiles(){
		MainPageTheInternet main=new MainPageTheInternet(driver).get();
		FileDownloadPage file=main.accessFileDownloadSection();
		assertTrue("File Download Section was not accessed/opened properly", file.someTxtFile.isDisplayed());
		file.downloadAllFiles();
		
		// !!!!!!Da click pe linkuri insa nu DL-eaza
		
		//check if th files were actually downloaded...assert-uri
		
		
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
}
