package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import base.BaseClass;
import pages.RegisterPage;
import utility.ExcelReader;
import utility.ExtentReport;

public class RegisterTestForNewUser extends BaseClass{
	String url;

	//getting url from data.properties file
	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		ExtentReport.getInstance();
	}

	@Test(priority = 1)
	@Parameters({"browser"})
	public void testRegisterPage(String browser) throws InterruptedException, IOException {
		invokeBrowser(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ExtentReport.createTest("Browser opened").info("Browser Opened successfully");
		//creating object of RegisterPage to access the methods present in RegisterPage
		RegisterPage regist = new RegisterPage(driver);
		//click on login
		regist.clickOnLoginPage();
		//click on register
		regist.clickOnRegisterPage();
		
		regist.selectFemaleBtn();
		//user enter details
		regist.firstName(ExcelReader.getData(1, 0));
		Thread.sleep(2000);
		regist.lastName(ExcelReader.getData(1, 1));
		regist.email(ExcelReader.getData(1, 2));
		regist.password(ExcelReader.getData(1, 3));
		regist.confirmPassword(ExcelReader.getData(1, 4));
		ExtentReport.createTest("user details").info("user entered details successfully");
		regist.registerBtn();
		//new user register
		if(regist.successMsg().isDisplayed()) {
			String message = regist.successMsg().getText();
			System.out.println("success message: "+message);
			Assert.assertTrue(true);
			screenshot();
			ExtentReport.createTest("Register Testcase for new user").log(Status. PASS,"RegisterTest Completed");
		}
	}
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		ExtentReport.getInstance().flush();
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}
