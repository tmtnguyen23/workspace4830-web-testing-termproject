package edu.uno.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class Reservation2 {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	  @Before
	  public void setUp() throws Exception {
	    System.setProperty("webdriver.chrome.driver", //
	    		"lib\\win\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testLoginpage() throws Exception {
		  	driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/login.html");
			driver.findElement(By.name("user")).click();
			driver.findElement(By.name("user")).clear();
			driver.findElement(By.name("user")).sendKeys("test");
			driver.findElement(By.name("pwd")).clear();
			driver.findElement(By.name("pwd")).sendKeys("pwd");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/Home.jsp");
			driver.findElement(By.linkText("New Reservation")).click();
			driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/ReservationForm.jsp");
			driver.findElement(By.id("date")).click();
			driver.findElement(By.id("date")).clear();
			driver.findElement(By.id("date")).sendKeys("2023-12-15");
			driver.findElement(By.id("start")).click();
			driver.findElement(By.id("start")).click();
			driver.findElement(By.id("start")).clear();
			driver.findElement(By.id("start")).sendKeys("09:00");
			driver.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/Confirmation.jsp");

		    String expected = "Confirmed! Your reservation was added.";
		    String result = driver.findElement(By.id("confirm-message")).getText();
		    Assert.assertEquals(expected, result);
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}