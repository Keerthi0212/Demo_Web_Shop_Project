package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	WebDriver driver;

	//constructor 
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	//locator
	private By loginPage = By.xpath("//a[@class='ico-login']");
	private By registerPage = By.xpath("//input[@class='button-1 register-button']");
	private By femaleBtn = By.id("gender-female");
	private By maleBtn = By.id("gender-male");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By registerBtn = By.id("register-button");
	private By msg = By.xpath("//div[@class='result' ]");
	private By errorMsg = By.xpath("//li[text()='The specified email already exists']");
	
	//action methods
	public void clickOnLoginPage() {
		driver.findElement(loginPage).click();
	}
	public void clickOnRegisterPage() {
		driver.findElement(registerPage).click();
	}
	public void selectFemaleBtn() {
		driver.findElement(femaleBtn).click();
	}
	public void selectMaleBtn() {
		driver.findElement(maleBtn).click();
	}
	public void firstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}
	public void lastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}
	public void email(String mail) {
		driver.findElement(email).sendKeys(mail);
	}
	public void password(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void confirmPassword(String conPwd) {
		driver.findElement(confirmPassword).sendKeys(conPwd);
	}
	public void registerBtn() {
		driver.findElement(registerBtn).click();
	}
	public WebElement successMsg() throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(msg);
	}
	public WebElement unsuccessMsg(){
		return driver.findElement(errorMsg);
		
	}
	
	
	

}
