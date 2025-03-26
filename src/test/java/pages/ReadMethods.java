package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ReadMethods{
	String url,email,password,coupon,giftCard,pincode;
	
	public void readData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\geeth\\OneDrive\\Desktop\\selenium\\capstone_project\\src\\test\\java\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		
	}
	public void LoginMethod(WebDriver driver,String mail,String pwd) {
		LoginPageWithPF lp = new LoginPageWithPF(driver);
		lp.clickOnLoginPage();
		lp.enterEmailId(mail);
		lp.enterPwd(pwd);
		lp.clickOnRemCheckBox();
		lp.clickOnLoginBtn();
	}
	
	public void LoginMethod(WebDriver driver) {
		LoginPageWithPF lp = new LoginPageWithPF(driver);
		lp.clickOnLoginPage();
		lp.enterEmailId(email);
		lp.enterPwd(password);
		lp.clickOnRemCheckBox();
		lp.clickOnLoginBtn();
	}
	public void clickOnJewelry(WebDriver driver) {
		HomePage hp = new HomePage(driver);
		hp.clickOnJewelry();
	}
	
	public void addJewelryToCart(WebDriver driver) throws InterruptedException {
		AddToCartJewelryPage cart = new AddToCartJewelryPage(driver);
		cart.selectSortBy().sendKeys(Keys.ARROW_DOWN,"Name:A-Z",Keys.ENTER);
		cart.displayPerPage().sendKeys(Keys.ARROW_DOWN,"4",Keys.ENTER);
		//Thread.sleep(1000);
		cart.viewAs();
		cart.filterBy();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		cart.addjewelryToCart();
	}

}
