package Test.TheInternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPageTheInternet extends LoadableComponent<LoginPageTheInternet> {

	private WebDriver driver;
	private final String usernameCorrectString="tomsmith";
	private final String passwordCorrectString="SuperSecretPassword!";
	
	@FindBy(css="#username")
	WebElement usernameTextField;
	
	@FindBy(css="#password")
	WebElement passwordTextField;
	
	@FindBy(css="button")
	WebElement loginBtn;
	
	
	public LoginPageTheInternet(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		String url="http://the-internet.herokuapp.com/login";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));
		assertTrue("Username text field is not displayed", usernameTextField.isDisplayed());
		assertTrue("Password text field is not displayed", passwordTextField.isDisplayed());
		assertTrue("Login button is not displayed", loginBtn.isDisplayed());
		
	}
	
	public SecureAreaTheInternet loginSuccessfully(){
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(loginBtn));
		usernameTextField.sendKeys(usernameCorrectString);
		passwordTextField.sendKeys(passwordCorrectString);
		loginBtn.click();
		
		return new SecureAreaTheInternet(driver);
		
	}
	
	

}
