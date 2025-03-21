package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.AddToCartJewelryPage;
import pages.HomePage;
import utility.ExtentReport;

public class AddToCartJewelryTest extends BaseClass {

	String url;
	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		ExtentReport.getInstance();
	}
	@Test
	@Parameters({"browser"})
	public void purchaseJewelry(String browser) throws InterruptedException, IOException {
		invokeBrowser(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ExtentReport.createTest("Browser opened").info("Browser Opened successfully");

		HomePage hp = new HomePage(driver);
		hp.clickOnJewelry();

		AddToCartJewelryPage cart = new AddToCartJewelryPage(driver);
		Thread.sleep(2000);
		//adding one product
		cart.selectSortBy().sendKeys(Keys.ARROW_DOWN,"Name:A-Z",Keys.ENTER);
		cart.displayPerPage().sendKeys(Keys.ARROW_DOWN,"4",Keys.ENTER);;
		Thread.sleep(2000);
		cart.viewAs();
		cart.filterBy();
		cart.addjewelryToCart();
		ExtentReport.createTest("product details").info("Product details are selected");
		screenshot();
		//adding second product
		cart.addSecProductToCart();
		cart.selectMaterial().sendKeys(Keys.ARROW_DOWN,"Silver (1 mm)",Keys.ENTER);
		cart.enterLength();
		cart.selectPendant("heart");
		cart.enterQuantity().clear();
		cart.enterQuantity().sendKeys("1");
		cart.addToCartSec();
		screenshot();
		WebElement msg = cart.successMessage();
		if(msg.isDisplayed()) {
			System.out.println(msg.getText());
			Assert.assertTrue(true);
			ExtentReport.createTest("Add to cart test case").log(Status.PASS, "Add to cart test case successfully completed");
		}else {
			Assert.assertTrue(false);
			ExtentReport.createTest("Add to cart test case").log(Status.FAIL, "Add to cart test case failed");
		}
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		ExtentReport.getInstance().flush();
	}

}
