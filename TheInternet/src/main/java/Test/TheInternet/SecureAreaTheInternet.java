package Test.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class SecureAreaTheInternet extends LoadableComponent<SecureAreaTheInternet> {

	private WebDriver driver;
	
	public SecureAreaTheInternet(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".icon-signout")
	WebElement logoutBtn;
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		String url="http://the-internet.herokuapp.com/secure";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));
		assertTrue("Logout button is not displayed", logoutBtn.isDisplayed());
		
	}
	
	public LoginPageTheInternet logoutAction(){
		//WebElement logout = driver.findElement(By.l"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(logoutBtn)).click();
		return new LoginPageTheInternet(driver).get();
		
		//.icon-signout  .button.secondary.radius
	}
	


}
