package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

//public String offerPageProductName;
public TestContextSetup testContextSetup;
public WebDriver driver;
public String landingPageProductName;
public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
		
}
@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
	//testContextSetup.driver = new ChromeDriver();
	driver = new ChromeDriver();
	testContextSetup.driver = driver;
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	driver.manage().window().maximize();
    
}
@When("user searched  with Shortnamme {string} and extracted actual name of product")
public void user_searched_with_shortnamme_and_extracted_actual_name_of_product(String shorName) {
	driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys(shorName);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	landingPageProductName =  driver.findElement(By.xpath("//div[@class='products']/div[@class='product']/h4")).getText().split("-")[0].trim();
	testContextSetup.landingPageProductName = landingPageProductName;
   System.out.println(landingPageProductName);
  
}





}
