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

public class ManageAccount2 {
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
		    driver.findElement(By.name("pwd")).sendKeys(Keys.ENTER);
		    driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/Home.jsp");
		    driver.findElement(By.linkText("Manage Account")).click();
		    driver.get("http://ec2-18-220-185-50.us-east-2.compute.amazonaws.com:8080/term-project-placeholder_name_2/MngAcct.jsp");
		    driver.findElement(By.name("pwd")).click();
		    driver.findElement(By.name("fname")).click();
		    driver.findElement(By.name("fname")).clear();
		    driver.findElement(By.name("fname")).sendKeys("Person");
		    driver.findElement(By.name("lname")).clear();
		    driver.findElement(By.name("lname")).sendKeys("Bob");
		    driver.findElement(By.name("phone")).clear();
		    driver.findElement(By.name("phone")).sendKeys("1234567890");
		    driver.findElement(By.name("mail")).clear();
		    driver.findElement(By.name("mail")).sendKeys("him@email.com");
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();

		    String expected1 = "First name: Person";
		    String expected2 = "Last name: Bob";
		    String expected3 = "Phone: 1234567890";
		    String expected4 = "Email: him@email.com";
		    String result1 = driver.findElement(By.id("first-name")).getText();
		    String result2 = driver.findElement(By.id("last-name")).getText();
		    String result3 = driver.findElement(By.id("phone")).getText();
		    String result4 = driver.findElement(By.id("email")).getText();
		    Assert.assertEquals(expected1, result1);
		    Assert.assertEquals(expected2, result2);
		    Assert.assertEquals(expected3, result3);
		    Assert.assertEquals(expected4, result4);
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