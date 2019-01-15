package com.mascamo.dev.TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mascamo.dev.Pages.HomePage;
import com.mascamo.dev.Pages.LoginPage;
import com.mascamo.dev.TestBase.TestBase;

public class LoginPageTest extends TestBase {

	public static LoginPage LP;
	public static HomePage HP;

	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void setup() {

		initialization();
		LP = new LoginPage();
		HP =new HomePage();
	}

	// services provided

	@Test (priority=0)
	public void fblogodisplaytest() {
		boolean logocheck = LP.fblogodisplay();
		Assert.assertTrue(logocheck);
	}

	@Test (priority=1)
	public void validlogintest() {
		HP =LP.validlogin(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@Test (priority=2)
	public void homepageloginprofiletest() {

		String Expected_text = "Sachin Shetty";
		Assert.assertEquals(HP.homepageloginprofile(), Expected_text);
	}

	@AfterClass
	public void closebrowser() {
		driver.quit();
	}

}