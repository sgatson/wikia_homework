package homework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialUserLoginPage extends BasePage{
	
	@FindBy(name = "username")
	public WebElement userNameTextBox;
	
	@FindBy(name = "password")
	public WebElement passwordTextBox;
	
	@FindBy(name = "keeploggedin")
	public WebElement keepLoggedInCheckbox;
	
	@FindBy(css = "#mw-content-text > div > form > fieldset > div.input-group.login-button.big > input")
	public WebElement loginButton;
	
	@FindBy(css = "#mw-content-text > div > form > fieldset > div.input-group.error.required > div")
	public WebElement userNameErrorDiv;
	
	@FindBy(css = "#mw-content-text > div > form > fieldset > div.input-group.password-input.error.required > div")
	public WebElement passwordErrorDiv;
	
	public SpecialUserLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName, String password) {
		userNameTextBox.sendKeys(userName);
		passwordTextBox.sendKeys(password);
		loginButton.click();
	}
}
