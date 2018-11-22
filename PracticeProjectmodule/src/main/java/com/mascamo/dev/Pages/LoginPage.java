package com.mascamo.dev.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mascamo.dev.TestBase.TestBase;

public class LoginPage extends TestBase {

	@CacheLookup
	@FindBy(id = "email")
	WebElement email;

	@CacheLookup
	@FindBy(how = How.ID, using = "pass")
	WebElement password;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@value='Log In' and @type='submit']")
	WebElement login;

	@FindBy(how = How.XPATH, using = "//a[@title='Go to Facebook home']//i")
	WebElement logo;

	@FindBy(how = How.XPATH, using = "//a[text()='Forgotten account?']")
	WebElement forgottenaccount;

	@FindBy(how = How.XPATH, using = "//div[text()='Create a new account']")
	WebElement createnewaccount;

	@FindBy(how = How.ID, using = "websubmit")
	WebElement register;

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean fblogodisplay() {
		return logo.isDisplayed();
	}

	public boolean forgottenpassworddisplay() {
		return forgottenaccount.isDisplayed();
	}

	public String createnewaccount() {
		return createnewaccount.getText();
	}

	public HomePage validlogin(String em ,String pass) {
		email.sendKeys(em);
		password.sendKeys(pass);
		login.click();
        return new  HomePage();
	}

}