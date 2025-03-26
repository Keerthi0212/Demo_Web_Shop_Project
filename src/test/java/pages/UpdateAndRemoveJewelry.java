package pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class UpdateAndRemoveJewelry {
	WebDriver driver;

	public UpdateAndRemoveJewelry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='button-2 update-cart-button']") WebElement update;
	@FindBy(name ="removefromcart") WebElement remove;
	@FindBy(xpath = "//input[@class='qty-input']") WebElement quantity;
	@FindBy(xpath = "//a[text()='Edit']") WebElement edit;
	@FindBy(name = "continueshopping") WebElement continueShop;
	@FindBy(xpath = "//div[@class='order-summary-content']") WebElement msg;
	
	public void clickOnUpdate() {
		update.click();
	}
	
	public void clickOnRemove() {
		remove.click();
	}
	
	public void editQuantity() {
		//fluent wait
		Wait<WebDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(40))
		        .pollingEvery(Duration.ofMillis(500))
		        .ignoring(NoSuchElementException.class);

		WebElement quantityElement = wait.until(driver -> quantity);
		quantityElement.clear();
		quantityElement.sendKeys("2");
	}
	
	public void clickOnEdit() {
		edit.click();
	}
	
	public void clickOnContinueShopping() {
		continueShop.click();
	}
	public WebElement getDisplayMsg() {
		return msg;
	}
	

}
