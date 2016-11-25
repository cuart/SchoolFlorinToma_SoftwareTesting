package Test.TheInternet;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class FileDownloadPage extends LoadableComponent<FileDownloadPage>{

	private WebDriver driver;
	
	@FindBy(css="a[href='download/some-file.txt\"]")
	WebElement someTxtFile;
	
	
	public FileDownloadPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void isLoaded() throws Error {
		String url="http://the-internet.herokuapp.com/download";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));
		
	}
	
	public void downloadAllFiles(){
		List<WebElement> listDownloads = new ArrayList<WebElement>();
		listDownloads = driver.findElements(By.cssSelector("#content>.example>a"));
		for(WebElement e:listDownloads){
			e.click();
		}
		
		// to complete //http://sqa.stackexchange.com/questions/2197/how-to-download-a-file-using-seleniums-webdriver
		
	}

}

