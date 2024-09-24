package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utils.TestContextSetup;

public class OfferPageStepDefinition{

String offerPageProductName;
//WebDriver driver;
//String landingPageProductName;
TestContextSetup testContextSetup;
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
	//this.driver = testContextSetup.driver;
	//this.landingPageProductName = testContextSetup.landingPageProductName;
}


@Then("user searched for {string} shortname in offers page")
public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) {
	
	 testContextSetup.driver.findElement(By.xpath("//a[text()=\"Top Deals\"]")).click();
	// driver.findElement(By.xpath("//a[text()=\"Top Deals\"]")).click();
	  //Set<String> window =  testContextSetup.driver.getWindowHandles();
	  Set<String> window =  testContextSetup.driver.getWindowHandles();
//	  Iterator<String>i1 = window.iterator();
//	 String parent =  i1.next();
//	  String child = i1.next();
	  List<String> windows = new ArrayList<>(window);
	  testContextSetup.driver.switchTo().window(windows.get(1));
	  //driver.switchTo().window(windows.get(1));
	  testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	//  driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
	  // By.cssSelector("tr td:nth-child(1)")
	 offerPageProductName =  testContextSetup.driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
	 //offerPageProductName =  driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
	
	  
}
@Then("validate product name in offers page matches with Landing Page")
public void validate_product_name_in_offers_page()
{
	Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	//Assert.assertEquals(offerPageProductName,landingPageProductName);
}



}
