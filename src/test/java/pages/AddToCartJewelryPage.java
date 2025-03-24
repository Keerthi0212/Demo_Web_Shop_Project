package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartJewelryPage {
	WebDriver driver;

	public AddToCartJewelryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By sortBy = By.id("products-orderby");
	private By display = By.id("products-pagesize");
	private By view = By.xpath("//select[@id='products-viewmode']");
	private By filter = By.xpath("//li[1]//a[1]//span[2]");
	private By product1 = By.xpath("(//input[@type='button' and @value='Add to cart'])[2]");
	private By successMsg = By.xpath("//p[@class='content']");
	//second product details
	private By product2 = By.xpath("(//input[@type='button' and @value='Add to cart'])[1]");
	//private By product2 = By.xpath("//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]");
	private By material = By.id("product_attribute_71_9_15");
	private By length = By.xpath("//input[@name='product_attribute_71_10_16' ]");
	private By quantity = By.id("addtocart_71_EnteredQuantity");
	private By ladyBug = By.xpath("//input[@id='product_attribute_71_11_17_48' ]");
	private By addToCart = By.id("add-to-cart-button-71");
	//with pf intialize the webElement
	@FindBy (xpath ="//input[@id='product_attribute_71_11_17_49' ]") WebElement heart;
	@FindBy (xpath ="//input[@id='product_attribute_71_11_17_50' ]") WebElement star;
	@FindBy (xpath ="//input[@id='product_attribute_71_11_17_51' ]") WebElement none;
	
	
	public WebElement selectSortBy() {
		return driver.findElement(sortBy);		
	}

	public WebElement displayPerPage() {
		return driver.findElement(display);
	}

	public void viewAs() {
		WebElement v = driver.findElement(view);
		v.click();
		Select s = new Select(v);
		List<WebElement> ele = s.getOptions();
		for(WebElement view : ele) {
			if(view.getText().equals("List")) {
				view.click();
			}
		}
	}
	public void filterBy() {
		driver.findElement(filter).click();
	}

	public void addjewelryToCart() {
		driver.findElement(product1).click();
	}
	public WebElement successMessage() {
		return driver.findElement(successMsg);
	}
	public void addSecProductToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(product2));
		//driver.findElement(product2).click();
        element.click();
	}
	public WebElement selectMaterial() {
		return driver.findElement(material);
        
	}
	public void enterLength() {
		driver.findElement(length).sendKeys("5");
	}
	public void selectPendant(String pend) {
		if(pend.equalsIgnoreCase("ladybug")) {
			driver.findElement(ladyBug).click();
		}else if(pend.equalsIgnoreCase("heart")){
			heart.click();
		}else if(pend.equalsIgnoreCase("star")){
			star.click();
		}else if(pend.equalsIgnoreCase("none")){
			none.click();
		}
	}
	public WebElement enterQuantity() {
		//explicit wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
		//return driver.findElement(quantity);	
        return element;
		}
	public void addToCartSec() {
		driver.findElement(addToCart).click();
	}


}
