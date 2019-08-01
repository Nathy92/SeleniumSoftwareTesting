package com.cedric.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.cedric.base.TestBase;

import junit.framework.Assert;

public class LoginTest extends TestBase {
	
	@Test
  public void loginAsBankManager() throws InterruptedException 
  {
	  log.debug("Inside Login Test");
	 // driver.findElement(By.xpath("button[class*='btn btn-primary btn-lg']")).click();
	  driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	  Assert.assertTrue(message, condition);
	  
	  log.debug("Login Test succesfull executed");
  }
}
