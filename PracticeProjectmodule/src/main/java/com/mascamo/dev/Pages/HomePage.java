package com.mascamo.dev.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mascamo.dev.TestBase.TestBase;

public class HomePage extends TestBase {

	@CacheLookup
	@FindBy(xpath = "//div[@dir='ltr' and text()='Sachin Shetty']")
	WebElement homepageprofilename;

	public HomePage() {
		PageFactory.initElements(driver, this);
		System.out.println("login successful");
	}
	
	public String homepageloginprofile() {
		return homepageprofilename.getText();
	

	}

}
