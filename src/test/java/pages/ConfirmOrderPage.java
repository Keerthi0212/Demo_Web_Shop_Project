package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmOrderPage {
	WebDriver driver;

	public ConfirmOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="billing-address-select") WebElement bill;
	@FindBy(id = "BillingNewAddress_CountryId") WebElement country;
	@FindBy(id = "BillingNewAddress_City") WebElement city;
	@FindBy(id = "BillingNewAddress_Address1") WebElement address1;
	@FindBy(id = "BillingNewAddress_ZipPostalCode") WebElement pincode;
	@FindBy(id = "BillingNewAddress_PhoneNumber") WebElement phoneNum;
	@FindBy(xpath = "//input[@onclick='Billing.save()']") WebElement continueBill;
	@FindBy(id = "PickUpInStore") WebElement pickUp;
	@FindBy(xpath = "//a[text()='Back']") WebElement back;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']") WebElement continueShip;
	@FindBy(id ="shippingoption_0") WebElement ground;
	@FindBy(id = "shippingoption_1") WebElement nextDay;
	@FindBy(id = "shippingoption_2") WebElement secDay;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']") WebElement continueShipMethod;
	@FindBy(id = "paymentmethod_0") WebElement cashOnDelivery;
	@FindBy(id = "paymentmethod_1") WebElement moneyOrder;
	@FindBy(id = "paymentmethod_2") WebElement creditCard;
	@FindBy(id = "paymentmethod_3") WebElement  purchaseOrder;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']") WebElement continuePayment;
	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']") WebElement paymentInfo;
	//@FindBy(xpath = "//input[@value='Confirm']") WebElement confirm;
	@FindBy(xpath = "//div[@class='title']") WebElement msgTitle;
	@FindBy(xpath = "//ul[@class='details']") WebElement orderNum;
	@FindBy(xpath = "//a[text()='Click here for order details.']") WebElement orderDetails;
	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']") WebElement continueConfirm;
	@FindBy(xpath = "//a[text()='PDF Invoice']") WebElement pdf;
	
	public void selectBillAddress() {
		bill.sendKeys(Keys.ARROW_DOWN,"New Address",Keys.ENTER);
	}
	public void selectCountry() {
		country.sendKeys(Keys.ARROW_DOWN,"India",Keys.ENTER);
	}
	public void enterCity(String cty) {
		city.clear();
		city.sendKeys(cty);
	}
	public void enterAddress(String address) {
		address1.clear();
		address1.sendKeys(address);
	}
	public void enterPincode(String pin) {
		pincode.clear();
		pincode.sendKeys(pin);
	}
	public void enterPhoneNum(String num) {
		phoneNum.sendKeys(num);
	}
	public void clickOnAddressContinue() {
		continueBill.click();
	}
	public WebElement clickOnPickUp() {
		return pickUp;
	}
	public void clickOnShipContinue() {
		continueShip.click();
	}
	public void clickOnBack() {
		back.click();
	}
	public void clickOnGround() {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(15))
		        .pollingEvery(Duration.ofMillis(500))
		        .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(driver -> ground);
		element.click();
		
	}
	public void clickOnNextDay() {
		nextDay.click();
	}
	public void clickOnSecDay() {
		secDay.click();
	}
	public void clickOnShipMethContinue() {
		continueShipMethod.click();
	}
	public void clickOnCOD() {
	     cashOnDelivery.click();
	}
	public void clickOnMoneyOrder() {
		moneyOrder.click();
	}
	public void clickOnCreditCard() {
		creditCard.click();
	}
	public void clickOnPurchaseOrder() {
		purchaseOrder.click();
	}
	public void clickOnPaymentContinue() {
		continuePayment.click();
	}
	public void clickOnPaymentInfo() {
		paymentInfo.click();
	}
	public void clickOnConfirmOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Confirm']")));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBtn);

		// Click
		confirmBtn.click();
	}
	public WebElement getMsgTitle() {
		return msgTitle;
	}
	public WebElement getOrderNum() {
		return orderNum;
	}
	public void clickOnOrderDetails() {
		orderDetails.click();
	}
	public void clickOnConfirmContinue() {
        continueConfirm.click();
	}
	public void getOrderPdf() {
		pdf.click();
	}
}
