package stepDefinitions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition {
public WebDriver driver;
String landingPageProductName;
String offerPageProductName;
@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.manage().window().maximize();
    
}
@When("user searched  with Shortnamme {string} and extracted actual name of product")
public void user_searched_with_shortnamme_and_extracted_actual_name_of_product(String shorName) {
    driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(shorName);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
   landingPageProductName =   driver.findElement(By.xpath("//div[@class='products']/div[@class='product']/h4")).getText().split("-")[0].trim();
   System.out.println(landingPageProductName);
  
}
@Then("user searched for {string} shortname in offers page")
public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {
	
	 driver.findElement(By.xpath("//a[text()=\"Top Deals\"]")).click();
	  Set<String> window =  driver.getWindowHandles();
//	  Iterator<String>i1 = window.iterator();
//	 String parent =  i1.next();
//	  String child = i1.next();
	  List<String> windows = new ArrayList<>(window);
	  driver.switchTo().window(windows.get(1));
	  driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	  // By.cssSelector("tr td:nth-child(1)")
	 offerPageProductName =  driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
	
	  
}
@Then("validate product name in offers page matches with Landing Page")
public void validate_product_name_in_offers_page()
{
	Assert.assertEquals(offerPageProductName, landingPageProductName);
}



}
