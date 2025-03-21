package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPF {

		WebDriver driver;

		//constructor
		public LoginPageWithPF(WebDriver driver){
			this.driver = driver;
			PageFactory.initElements(driver, this);//to perform intialization of WebElements annotated by @FindBy
		}

		//locators
		@FindBy(xpath="//a[@class='ico-login']") WebElement loginPageBtn;
		@FindBy(xpath="//input[@class='email' ]") WebElement email;
		@FindBy(xpath="//input[@class='password' ]") WebElement password_loc;
		@FindBy(xpath="//input[@id='RememberMe']") WebElement remCheckBox;
		@FindBy(xpath="//input[@class='button-1 login-button']") WebElement loginButton_loc;
		

		//action methods
		public void clickOnLoginPage() {
			loginPageBtn.click();
		}
		
		public void enterEmailId(String mail) {
			email.sendKeys(mail);
		}
		
		public void enterPwd(String password) {
		password_loc.sendKeys(password);
		}
		
		public void clickOnRemCheckBox() {
			remCheckBox.click();
		}
		
		public void clickOnLoginBtn() {
			loginButton_loc.click();
		}
		


}


