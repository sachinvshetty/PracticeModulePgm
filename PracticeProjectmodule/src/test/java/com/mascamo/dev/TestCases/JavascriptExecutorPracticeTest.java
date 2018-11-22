package com.mascamo.dev.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//JavascriptExecutor is a class..ExecuteScript is a method used to run code
public class JavascriptExecutorPracticeTest {

	// public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\s.nagaraja.setty" + "\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/");

		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		username.sendKeys("sachin_vn_shetty");
		password.sendKeys("sachinincrmpro");
		// loginbtn.click();
		flashcolor(loginbtn, driver);
		Border(loginbtn, driver);
		screenshot(driver);
		javascriptalert(driver, "this is a javascript alert");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		javascriptrefresh(driver);
		System.out.println(javascriptgettitle(driver));
		System.out.println(javascriptinnerText(driver));
		WebElement forgotpassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		javascriptscrollintoiView(driver, forgotpassword);
		forgotpassword.click();
		driver.quit();

	}

	// Flashing the webelement
	public static void flashcolor(WebElement element, WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 2; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			Thread.sleep(2000);
			changeColor(bgcolor, element, driver);
		}

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);

	}

	// Highlighting the webelement with a border
	public static void Border(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void screenshot(WebDriver driver) {
		File fs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fs,
					new File("C:\\Users\\s.nagaraja.setty\\Desktop\\naveen automation labs\\new_window.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void javascriptalert(WebDriver driver, String Message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + Message + "')");

	}

	public static void clickonelement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}

	public static void javascriptrefresh(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public static String javascriptgettitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String javascriptinnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innertext = js.executeScript("return document.documentElement.innerText;").toString();
		return innertext;
	}

	public static void javascriptscrollpagedown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void javascriptscrollintoiView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
