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
import pages.HomePage;
import pages.ReadMethods;
import utility.ExtentReport;

public class LogoutWithValidLogin extends BaseClass{
	
	String url,email,password;
	ReadMethods read;
	@BeforeTest
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		read = new ReadMethods();
		ExtentReport.getInstance();
	}
	
	@Test
	@Parameters ({"browser"})
	public void logoutTest(String browser) throws InterruptedException, IOException {
		invokeBrowser(browser);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//first login into website with valid login credentials
		HomePage hp = new HomePage(driver);
		hp.clickOnLoginBtn();
		read.LoginMethod(driver, email, password);
		Thread.sleep(1000);
		
		//logging out from website
		hp.clickOnLogout();
		screenshot();
		ExtentReport.createTest("logout test").log(Status.PASS,"logging out with valid login test succesfully completed");
		
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException {
		 ExtentReport.getInstance().flush();
		 if (driver != null) {  // Check if driver session is still active
		        Thread.sleep(2000);
		        //driver.close();
		        driver.quit();  // Ensure the session is fully terminated
		    }
		   
	}

}
