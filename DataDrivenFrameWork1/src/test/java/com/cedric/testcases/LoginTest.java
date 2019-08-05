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
	  //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
	  //driver.findElement(By.id(OR.getProperty("nameTxt"))).sendKeys("Nkosinathi Cedric Malala");
	 // driver.findElement(By.id(OR.getProperty("emailTxt"))).sendKeys("example@gmail.com");
	  driver.findElement(By.id("name")).sendKeys("Nkosinathi Cedric");
	  
	  
	  //Assert.assertTrue(message, condition);
	  
	  log.debug("Login Test succesfull executed");
  }
}
