package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import pages.LoginPageWithPF;
import utility.ExtentReport;

public class LoginPageTest extends BaseClass{
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
	@Parameters({"browser"})
	public void loginTest(String browser) throws InterruptedException, IOException {
		invokeBrowser(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ExtentReport.createTest("Browser opened").info("Browser Opened successfully");
		
		LoginPageWithPF lp = new LoginPageWithPF(driver);
		lp.clickOnLoginPage();
		lp.enterEmailId(email);
		lp.enterPwd(password);
		ExtentReport.createTest("login details").log(Status.INFO,"user enterd email and password to login");
		lp.clickOnRemCheckBox();
		lp.clickOnLoginBtn();
		screenshot();
		Thread.sleep(2000);
		ExtentReport.createTest("Login testcase").log(Status. PASS,"Login testcase Completed");//update status p/f/s
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		ExtentReport.getInstance().flush();
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
