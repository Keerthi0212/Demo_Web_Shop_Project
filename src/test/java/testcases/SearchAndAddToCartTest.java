package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.AddToCartJewelryPage;
import pages.ReadMethods;
import pages.SearchAndAddToCart;
import utility.ExtentReport;

public class SearchAndAddToCartTest extends BaseClass {
	String url;
	ReadMethods read;
	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		read = new ReadMethods();
		ExtentReport.getInstance();
	}

	@Test
	@Parameters ({"browser"})
	public void testSearchAndAddToCart(String browser) throws InterruptedException {
		invokeBrowser(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		SearchAndAddToCart src = new SearchAndAddToCart(driver);
		ExtentReport.createTest("login test").log(Status.INFO,"login succesfully completed");
		src.clickOnSearchBar();
		src.clickOnSearch();
		src.clickOnAdvSearch();
		src.selectCategory();
		src.selectManufacture();
		src.enterFromPrice();
		src.enterToPrice();
		src.clickOnSearchBtn();
		try {
			AddToCartJewelryPage cart = new AddToCartJewelryPage(driver);
			cart.selectSortBy().sendKeys(Keys.ARROW_DOWN,"Name:A-Z",Keys.ENTER);
			cart.displayPerPage().sendKeys(Keys.ARROW_DOWN,"4",Keys.ENTER);
			//Thread.sleep(1000);
			cart.viewAs();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			cart.addjewelryToCart();
			screenshot();
			ExtentReport.createTest("search product test").log(Status.PASS,"Searching product and then add to cart test succesfully completed");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		ExtentReport.getInstance().flush();
		Thread.sleep(2000);
		driver.quit();
		
	}

}
