package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageInvalid {
	WebDriver driver;

	//constructor
	public LoginPageInvalid(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	private By loginPage = By.xpath("//a[@class='ico-login' ]");
	private By emailId = By.xpath("//input[@class='email' ]");
	private By pwd = By.xpath("//input[@class='password' ]");
	private By remCheckBox = By.xpath("//input[@id='RememberMe']");
	private By loginBtn = By.xpath("//input[@class='button-1 login-button']");
	private By errorMsg = By.xpath("//div[@class='validation-summary-errors']//span");
	
	//action methods
	public void clickOnLoginPage() {
		driver.findElement(loginPage).click();
	}

	public WebElement enterEmailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement enterPwd() {
		return driver.findElement(pwd);
	}
	
	public void clickOnRemCheckBox() {
		driver.findElement(remCheckBox).click();
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public WebElement getErrorMsg() {
		return driver.findElement(errorMsg);
	}

}
