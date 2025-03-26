package stepdef;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CheckOutPage;
import pages.ReadMethods;
import pages.UpdateAndRemoveJewelry;
import utility.ExtentReport;

public class RemoveSteps extends BaseClass{
	ReadMethods read;
	UpdateAndRemoveJewelry  remove;
	
	@Given("user enters into {string} the url Demo Web Shop") 
	public void user_enters_into_demo_web_shop(String url) {
		driver.get(url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    read = new ReadMethods();
	}
	@Then("user should enter {string} and {string} in email and password textbox and login")
	public void user_should_enter_and_in_email_and_password_textbox_and_login(String email, String password) {
		read.LoginMethod(driver,email,password);
	}

	@And("user should jewelry to cart")
	public void user_should_jewelry_to_cart() throws InterruptedException {
		read.clickOnJewelry(driver);
	    read.addJewelryToCart(driver);
	    CheckOutPage check = new CheckOutPage(driver);
	    check.clickOnCart();
	}
	
	@Then("user should update cart product")
	public void user_should_update_cart_product() throws InterruptedException, IOException {
		remove = new UpdateAndRemoveJewelry(driver);
		remove.editQuantity();
		Thread.sleep(1000);
		remove.clickOnUpdate();
		screenshot();
	}

	@Then("user should remove the product")
	public void user_should_remove_the_product() throws IOException, InterruptedException {
	   Thread.sleep(1000);
	   remove.clickOnRemove();
	   Thread.sleep(1000);
	   remove.clickOnUpdate();
	   screenshot();
	   try {
		  if(remove.getDisplayMsg().isDisplayed()) {
			  String msg = remove.getDisplayMsg().getText();
			  System.out.println("Removed Message: "+msg);
			  Assert.assertTrue(true);
			  ExtentReport.createTest("remove test case").log(Status.PASS, "Product Removed Successfully Completed");
		  }
	   }catch(Exception e) {
		   e.printStackTrace();
		   Assert.assertTrue(false);
	   ExtentReport.createTest("remove test case").log(Status.FAIL, "Product Remove failed");
	}
	}

}
