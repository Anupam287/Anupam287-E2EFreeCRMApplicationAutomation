package com.crm.qa.base;

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

import com.crm.qa.Testutil.TestUtil;
import com.crm.qa.Testutil.WebEventListener;

public class BasePage {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver ;
	public static WebEventListener eventListener;
	
	public BasePage() {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("E:\\Eclipse-workspace\\Java-Training\\E2EFreeCRMApplicationAutomation"
					+ "\\src\\test\\resources\\com\\crm\\qa\\config\\config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialisation() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver1\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver\\chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		
		else {
			
			System.out.println("Please enter the corerct browser name"+browserName);
		}
		// Webdriver fire Event - help to create User action logs to understand where the code is failing
		e_driver= new EventFiringWebDriver(driver);
		
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIME_OUT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
