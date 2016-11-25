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

public class DataTablesTheInternet extends LoadableComponent<DataTablesTheInternet> {
	
	private WebDriver driver;
	
	@FindBy(css="#table2")
	WebElement table2;
	
	@FindBy(css="table>thead>tr>th.header>.first-name")
	WebElement firstNamefieldNoSorting;
	@FindBy(css="table>thead>tr>th.header.headerSortDown>.first-name")
	WebElement firstNamefieldSortDown_alphabetically;
	@FindBy(css="table>thead>tr>th.header.headerSortUp>.first-name")
	WebElement firstNamefieldSortUp;
	
	public DataTablesTheInternet(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void isLoaded() throws Error {
		String url="http://the-internet.herokuapp.com/tables";
		assertTrue("URL is not the correct one", driver.getCurrentUrl().contains(url));
		assertTrue("Table2 is not displayed", table2.isDisplayed());
		
	}
	
	public List<String> getFirstNamesFromTable2(){
		List<WebElement> listWebElement = new ArrayList<WebElement>();
		listWebElement=driver.findElements(By.cssSelector(".first-name"));
		listWebElement.remove(0);
		
		List<String> listFirstNames = new ArrayList<String>();
		
		for(WebElement e:listWebElement){
			listFirstNames.add(e.getText());
		}
		return listFirstNames;
	}
	
	public boolean areFirstNamesOrderedAlphabetically(){
		List<String> list = this.getFirstNamesFromTable2();
		int indexTrue=0;
		for(int i=0;i<list.size()-1;i++){
			if(list.get(i).compareTo(list.get(i+1)) > 0){
				indexTrue++;
			}
		}
		
		if(indexTrue!=0){
			return false;
		}else{
			return true;
		}
		
	}
	
	

}
