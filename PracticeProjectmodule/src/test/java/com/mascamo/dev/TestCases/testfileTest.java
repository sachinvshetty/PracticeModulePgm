package com.mascamo.dev.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class testfileTest {

	public static Properties prop;
	public static WebDriver driver;

	@Test
	public void testfile() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\s.nagaraja.setty\\Desktop\\Maven Actitime\\"
					+ "PracticeProjectmodule\\src\\main\\java\\com\\mascamo\\dev\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("sachin");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "testfile" })
	public void display() {
		System.out.println(prop.getProperty("username"));
	}

	@Test
	public void testing() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		
		Actions action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.fb.com");
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		action.clickAndHold(email).moveToElement(password).release().build().perform();

	}

}
