package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Shopping cart']") WebElement shoppingCart;
	@FindBy(name = "discountcouponcode") WebElement coupon;
	@FindBy(xpath="//input[@name='applydiscountcouponcode']") WebElement applyCoupon;
	@FindBy(name ="giftcardcouponcode") WebElement giftCard;
	@FindBy(xpath = "//input[@name='applygiftcardcouponcode']") WebElement addGift;
	@FindBy(id="CountryId") WebElement country;
	@FindBy(id="StateProvinceId") WebElement state;
	@FindBy(id="ZipPostalCode") WebElement pincode;
	@FindBy(name = "estimateshipping") WebElement estimateShip;
	@FindBy(id="termsofservice") WebElement terms;
	@FindBy(id= "checkout") WebElement checkout;

	
	public void clickOnCart() {
		shoppingCart.click();
	}
	public void enterCoupon() {
		coupon.sendKeys("FIRST");
	}
	public void clickOnCoupon() {
		applyCoupon.click();
	}
	public void enterGiftCode() {
		giftCard.sendKeys("505");
	}
	public void clickOnGiftCard() {
		addGift.click();
	}
	public void selectCountry() {
		country.click();
		Select s = new Select(country);
		s.selectByContainsVisibleText("India");	
	}
	
	public void selectState() {
		state.click();
		Select s = new Select(state);
		s.selectByIndex(0);
	}
	
	public void enterPincode() {
		pincode.sendKeys("516002");
	}
	public void clickOnEstimateShip() {
		estimateShip.click();
	}
	
	public void clickOnTerms() {
		terms.click();
	}
	public void clickOnCheckOut() {
		checkout.click();
	}
	

}
