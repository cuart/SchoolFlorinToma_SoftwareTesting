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

import java.util.ArrayList;
import java.util.List;

public class MainPageTheInternet extends LoadableComponent<MainPageTheInternet> {

	private WebDriver driver;

	public MainPageTheInternet(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "div>#content>.heading")
	WebElement mainPageHeading;

	@Override
	protected void load() {
		driver.get("http://the-internet.herokuapp.com/");
	}

	@Override
	protected void isLoaded() throws Error {
		List<WebElement> list = new ArrayList<WebElement>();
		String url = "http://the-internet.herokuapp.com/";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));

		assertTrue("Main Page title is not displayed as it should be: \"The Internet\"",
				driver.getTitle().equals("The Internet"));
		assertTrue("Main Page head is not displayed as it should be:\"Welcome to the Internet\"",
				mainPageHeading.getText().equals("Welcome to the Internet"));

		list = this.getMenus();
		assertTrue("\"File Download\" option is not present on the main page",
				list.get(13).getText().equals("File Download"));
		assertTrue("\"Form Authentication\" option is not present on the main page",
				list.get(17).getText().equals("Form Authentication"));
		assertTrue("\"Sortable Data Tables\" option is not present on the main page",
				list.get(35).getText().equals("Sortable Data Tables"));
		System.out.println(list.get(11));
		assertTrue("\"Dynamic Loading\" option is not present on the main page",
				list.get(11).getText().equals("Dynamic Loading"));
	}

	public List<WebElement> getMenus() {
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.cssSelector("div>#content>ul>li"));
		return list;
	}

	public FileDownloadPage accessFileDownloadSection() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement fileDownloadSection = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("File Download"))));
		fileDownloadSection.click();

		return new FileDownloadPage(driver).get();
	}

	public LoginPageTheInternet accessFormAuthentication() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement loginSection = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Form Authentication"))));
		loginSection.click();
		return new LoginPageTheInternet(driver).get();
	}

	public DataTablesTheInternet accessTablesSection() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement tableSection = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Sortable Data Tables"))));
		tableSection.click();
		return new DataTablesTheInternet(driver).get();
	}
	
	public DynamicLoadingTheInternet accessDynamicLoadingSection() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement dynamicSection = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Dynamic Loading"))));
		dynamicSection.click();
		return new DynamicLoadingTheInternet(driver).get();
	}

}
