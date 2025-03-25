package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.CheckOutPage;
import pages.ConfirmOrderPage;
import pages.ReadMethods;
import utility.ExtentReport;

public class CheckOutPageTest extends BaseClass{
	String url,email,password,coupon,giftCard,pincode,city,address,phoneNo;
	ReadMethods read;

	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		coupon = prop.getProperty("coupon");
		giftCard = prop.getProperty("giftCard");
		pincode = prop.getProperty("pincode");
		city = prop.getProperty("city");
		address = prop.getProperty("address");
		phoneNo = prop.getProperty("phoneNo");
		read= new ReadMethods();
		read.readData();
		ExtentReport.getInstance();

	}

	@Test
	@Parameters ({"browser"})
	public void checkOutTest(String browser) throws InterruptedException, IOException {
		invokeBrowser(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		read.LoginMethod(driver);
		ExtentReport.createTest("login test").log(Status.INFO,"login succesfully completed");

		//click on jewelry
		read.clickOnJewelry(driver);

		//add product to cart
		read.addJewelryToCart(driver);
		ExtentReport.createTest("Add jewelry test").log(Status.INFO,"jewelry added successfully");

		//checkout
		CheckOutPage c = new CheckOutPage(driver);
		ExtentReport.createTest("checkout details").log(Status.INFO,"entered checkout details");
		c.clickOnCart();
		Thread.sleep(1000);
		c.enterCoupon(coupon);
		Thread.sleep(1000);
		c.clickOnCoupon();
		Thread.sleep(1000);
		c.enterGiftCode(giftCard);
		c.clickOnGiftCard();
		Thread.sleep(1000);
		c.selectCountry();
		Thread.sleep(1000);
		c.selectState();
		Thread.sleep(1000);
		c.enterPincode(pincode);
		Thread.sleep(1000);
		c.clickOnEstimateShip();
		Thread.sleep(1000);
		c.clickOnTerms();
		Thread.sleep(1000);
		c.clickOnCheckOut();
		Thread.sleep(3000);
		ExtentReport.createTest("checkout test").log(Status.PASS,"Successfully Clicked On Checkout");


		ConfirmOrderPage cp = new ConfirmOrderPage(driver);
		ExtentReport.createTest("confirm order details").log(Status.INFO,"shipping address and billing are in process");

		cp.selectBillAddress();
		cp.selectCountry();
		cp.enterCity(city);
		cp.enterAddress(address);
		cp.enterPincode(pincode);
		cp.enterPhoneNum(phoneNo);
		cp.clickOnAddressContinue();
		cp.clickOnPickUp().click();
//		cp.clickOnGround();
//		cp.clickOnShipMethContinue();
		cp.clickOnShipContinue();

		cp.clickOnCOD();
		cp.clickOnPaymentContinue();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		cp.clickOnPaymentInfo();
		cp.clickOnConfirmOrder();
		try {
			if(cp.getMsgTitle().isDisplayed()) {
				String msg = cp.getMsgTitle().getText();
				System.out.println("successfully orderd: "+msg);
				String orderNo = cp.getOrderNum().getText();
				System.out.println("order number : "+orderNo);
				screenshot();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		cp.clickOnOrderDetails();
		cp.getOrderPdf();
		screenshot();
		ExtentReport.createTest("confirm order test").log(Status.PASS,"order confirm is successfully completed");
		

	}

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		ExtentReport.getInstance().flush();
		Thread.sleep(2000);
		driver.quit();
		
	}


}
