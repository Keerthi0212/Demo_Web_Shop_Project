package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAndAddToCart {
	WebDriver driver;

	public SearchAndAddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="small-searchterms") WebElement search;
	@FindBy(xpath ="//input[@class='button-1 search-box-button']") WebElement enterSearch;
	@FindBy(id ="As") WebElement advSearch;
	@FindBy(id="Cid") WebElement category;
	@FindBy(id="Isc") WebElement automatic;
	@FindBy(id="Mid") WebElement manufacture;
	@FindBy(id="Pf") WebElement fromPrice;
	@FindBy(id="Pt") WebElement toPrice;
	@FindBy(id="Sid") WebElement searchProDesc;
	@FindBy(xpath="//input[@class='button-1 search-button']") WebElement searchBtn;
	@FindBy(xpath = "//div[@class='page-body']//div[2]//div[1]//div[2]//div[3]//div[2]//input[1]") WebElement product;
	
	public void clickOnSearchBar() {
		search.sendKeys("Jewelry");
	}
	public void clickOnSearch() {
		enterSearch.click();
	}
	public void clickOnAdvSearch() {
		advSearch.click();
	}
	public void selectCategory() {
		category.sendKeys(Keys.ARROW_DOWN,"Jewelry",Keys.ENTER);
		automatic.click();
	}
	public void selectManufacture() {
		manufacture.sendKeys(Keys.ARROW_DOWN,"All",Keys.ENTER);
	}
	public void enterFromPrice() {
		fromPrice.sendKeys("100");
	}
	public void enterToPrice() {
		toPrice.sendKeys("200");
		searchProDesc.click();
	}
	public void clickOnSearchBtn() {
		searchBtn.click();
	}
	
	public void clickOnProduct() {
		product.click();
	}
}
