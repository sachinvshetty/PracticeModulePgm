package com.mascamo.dev.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mascamo.dev.Pages.HomePage;
import com.mascamo.dev.Pages.LoginPage;
import com.mascamo.dev.TestBase.TestBase;

public class LoginPageTest extends TestBase {

	public LoginPage LP;
	public HomePage HP;
	
	public LoginPageTest() {
		super();
		
	}
	

	@BeforeClass()
	public void setup() {
		initialization();
		LP = new LoginPage();

	}
	

	// services
	@Test
	public void fblogodislaytest() {
		boolean flag = LP.fblogodisplay();
		Assert.assertTrue(flag);
	}

	@Test
	public void fbpagelogintest() {
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		HP= LP.validlogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterClass
	public void teardown() {
		driver.quit();

	}

}
