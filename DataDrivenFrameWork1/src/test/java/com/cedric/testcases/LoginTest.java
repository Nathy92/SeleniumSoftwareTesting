package com.cedric.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cedric.base.TestBase;

public class LoginTest extends TestBase {
	
	@Test
  public void loginAsBankManager() throws InterruptedException 
  {
	  log.debug("Inside Login Test");
	 // driver.findElement(By.xpath("button[class*='btn btn-primary btn-lg']")).click();
	  driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	  Thread.sleep(3000);
	  
	  log.debug("Login Test succesfull executed");
  }
}
