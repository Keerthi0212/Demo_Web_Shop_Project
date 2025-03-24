package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.AddToCartJewelryPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPageWithPF;
import utility.ExtentReport;

public class CheckOutPageTest extends BaseClass{
	String url,email,password;
	
	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		ExtentReport.getInstance();
		
	}
	
	@Test
	@Parameters ({"browser"})
	public void checkOutTest(String browser) throws InterruptedException {
		invokeBrowser(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		LoginPageWithPF lp = new LoginPageWithPF(driver);
		lp.clickOnLoginPage();
		lp.enterEmailId(email);
		lp.enterPwd(password);
		//ExtentReport.createTest("login details").log(Status.INFO,"user enterd email and password to login");
		lp.clickOnRemCheckBox();
		lp.clickOnLoginBtn();
        //click on jewelry
		HomePage hp = new HomePage(driver);
		hp.clickOnJewelry();
		
		//add product to cart
		AddToCartJewelryPage cart = new AddToCartJewelryPage(driver);
		cart.selectSortBy().sendKeys(Keys.ARROW_DOWN,"Name:A-Z",Keys.ENTER);
		cart.displayPerPage().sendKeys(Keys.ARROW_DOWN,"4",Keys.ENTER);;
		Thread.sleep(2000);
		cart.viewAs();
		cart.filterBy();
		cart.addjewelryToCart();
		
		//checkout
		CheckOutPage c = new CheckOutPage(driver);
		c.clickOnCart();
		Thread.sleep(1000);
		c.enterCoupon();
		Thread.sleep(1000);
		c.clickOnCoupon();
		Thread.sleep(1000);
		c.enterGiftCode();
		c.clickOnGiftCard();
		Thread.sleep(1000);
		c.selectCountry();
		Thread.sleep(1000);
		c.selectState();
		Thread.sleep(1000);
		c.enterPincode();
		Thread.sleep(1000);
		c.clickOnEstimateShip();
		Thread.sleep(1000);
		c.clickOnTerms();
		Thread.sleep(1000);
		c.clickOnCheckOut();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		//ExtentReport.getInstance().flush();
	}


}
