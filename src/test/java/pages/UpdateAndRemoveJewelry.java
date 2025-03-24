package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateAndRemoveJewelry {
	WebDriver driver;

	public UpdateAndRemoveJewelry(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='button-2 update-cart-button']") WebElement update;
	@FindBy(name ="removefromcart") WebElement remove;
	@FindBy(name = "itemquantity5181547") WebElement quantity;
	@FindBy(xpath = "//a[text()='Edit']") WebElement edit;
	@FindBy(name = "continueshopping") WebElement continueShop;
	
	public void clickOnUpdate() {
		update.click();
	}
	
	public void clickOnRemove() {
		remove.click();
	}
	
	public void editQuantity() {
		quantity.sendKeys("2");
	}
	
	public void clickOnEdit() {
		edit.click();
	}
	
	public void clickOnContinueShopping() {
		continueShop.click();
	}
	

}
