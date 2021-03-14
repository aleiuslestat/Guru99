package pom;

import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class TestCase1 {

	private WebDriver driver;
	Home home;
	String website = "https://live.demoguru99.com/";
	
	@BeforeEach
	void setUp() throws Exception {
		home = new Home(driver);
		driver = home.firefoxDriverConnection();
		home.visit(website);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		assertEquals("Home page", home.getTitle(driver));
		home.mobile();
		assertEquals("Mobile", home.getTitle(driver));
		home.sorted();
	}

}
