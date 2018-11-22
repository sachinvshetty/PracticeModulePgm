package com.mascamo.dev.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.mascamo.dev.Util.WebEventListner;
import com.mascamo.dev.Util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener listner;

	public  TestBase() {
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

	public void initialization() {
		String Browser = prop.getProperty("browser");
		if (Browser.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\s.nagaraja.setty\\Desktop\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// create object for the webdriverlistner
		listner = new WebEventListner();
		e_driver.register(listner);
		driver = e_driver;
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}
