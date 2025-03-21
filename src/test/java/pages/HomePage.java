package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By registerBtn = By.xpath("//input[@class='button-1 register-button']");
	private By loginBtn = By.xpath("//a[@class='ico-login' ]");
	private By jewelry = By.cssSelector("a[href='/jewelry']");
	
	public void clickOnRegisterBtn() {
		driver.findElement(registerBtn).click();
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public void clickOnJewelry() {
		driver.findElement(jewelry).click();
	}
	

}
