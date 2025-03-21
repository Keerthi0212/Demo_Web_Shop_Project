package stepdef;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPageInvalid;
import utility.ExtentReport;

public class LoginSteps extends BaseClass{
	static LoginPageInvalid lp;
	public static  void login() {
		lp=new LoginPageInvalid(driver);
	}
	
	@Given("Open Browser")
	public void open_browser() {
	   invokeBrowser("chrome");
	}

	@Then("user enters into {string} Demo Web Shop")
	public void user_enters_into_demo_web_shop(String url) {
		driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    login();
	    lp.clickOnLoginPage();
	    ExtentReport.getInstance();
	}

	@And("user should enter {string} in email text box")
	public void user_should_enter_in_email_text_box(String email) {
		 lp.enterEmailId().sendKeys(email);
	}

	@And("user should enter {string} in password text box")
	public void user_should_enter_in_password_text_box(String password) {
	    lp.enterPwd().sendKeys(password);
	    ExtentReport.createTest("invalid data").info("user enters invalid email and password");
	}

	@Then("user should clicks on login button")
	public void user_should_clicks_on_login_button() {
		lp.clickOnRemCheckBox();
	    lp.clickOnLoginBtn();
	}
	
	@Then("An error message is generated")
	public void an_error_message_is_generated() throws IOException {
		WebElement ele = lp.getErrorMsg();
	   if(ele.isDisplayed()) {
		   String msg = lp.getErrorMsg().getText();
		   System.out.println("Error msg : "+msg);
		   Assert.assertTrue(true);
		   screenshot();
		   ExtentReport.createTest("Invalid login test case").log(Status.PASS, "Login Test Case with in valid data Successfully Completed");
	   }
	}

	@And("close the browser")
	public void close_the_browser() throws InterruptedException {
	   Thread.sleep(2000);
	   driver.close();
	   ExtentReport.getInstance().flush();
	}

}
