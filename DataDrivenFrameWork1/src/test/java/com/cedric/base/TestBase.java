package com.cedric.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	/*
	 * WebDriver - Done
	 * Properties - Done
	 * Logs -Log4j
	 * ExtentReports,
	 * DB,
	 * Excel,
	 * Mail
	 */
	

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	
	@BeforeSuite
	public void setUp() 
	{
		if(driver==null) 
		{
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis =  new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		if(config.getProperty("browser").equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Launched!!");
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to:" + config.getProperty("testsiteurl") );
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.waite")), TimeUnit.SECONDS);
		
		}
		
	}

	@AfterSuite
	public void tearDown()
	{
		//This will execute if "driver"session not active
		if(driver!=null) {
		driver.quit();
		}
		log.debug("Test execution completed");
	}
}
