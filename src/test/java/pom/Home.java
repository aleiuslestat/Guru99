package pom;



//import java.util.Arrays;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Home extends Base {

	By MobileLocator = By.xpath("//li[@class='level0 nav-1 first']");
	By sortby = By.xpath("//div[@class='toolbar-bottom'] //select[@title='Sort By']");
	By ProductNameLocator = By.className("product-name");
	
	public Home(WebDriver driver) {
		super(driver);
	}
	
	public void mobile() {
		click(MobileLocator);
	}
	
	public void sorted() {
		Select SortBy = select(findElement(sortby));
		SortBy.selectByVisibleText("Name");
		List<WebElement> ProductsName =  findElements(ProductNameLocator);
	
		List<String> ProdutcsList = new ArrayList<String>();
		for(WebElement e : ProductsName){
			ProdutcsList.add(e.getText());
		}
		List<String> sortedList = ProdutcsList.stream().sorted().collect(Collectors.toList());

		// String[] sorted = ProdutcsList.toArray(new String[0]);
		//   System.out.print(ProdutcsList);
		//  Arrays.sort(sorted);
		   		
		 assertEquals(sortedList, ProdutcsList);
	}
	
	

}
