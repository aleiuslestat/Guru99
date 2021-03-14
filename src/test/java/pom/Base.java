package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	
	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	} 

	public WebDriver firefoxDriverConnection() { 
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public Select select(WebElement element) {
		Select drp = new Select(element);
		return(drp);
	}	
	
	public void sendKeys(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch( org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	} 
	
	public void visit(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	} 
	


}
