package Test.TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class DynamicLoadingTheInternet extends LoadableComponent<DynamicLoadingTheInternet> {

	private WebDriver driver;
	
	@FindBy(css = "div.example a:last-of-type")
	WebElement dynamicLoading2Link;
	@FindBy(css = "a[href='/dynamic_loading/1']")
	WebElement dynamicLoading1Link;

	// visible only in dynamic_loading/2 page
	@FindBy(css = "#start>button")
	WebElement startButton;
	@FindBy(css = "#finish")
	WebElement finishElement;

	public DynamicLoadingTheInternet(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, 20);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		String url = "http://the-internet.herokuapp.com/dynamic_loading";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));
		assertTrue("Example 2 NOT",driver.findElement(By.linkText("Example 2: Element rendered after the fact")).isDisplayed());
	}

	public WebElement clickOnExample2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Example 2: Element rendered after the fact"))).click();
		
		//nu vede corect butonul de start
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Start"))).click();
//		wait.until(ExpectedConditions.visibilityOf(startButton));
//		startButton.click();
		return wait.until(ExpectedConditions.visibilityOf(finishElement));
	}

}
