package com.github;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MT 
{

	public WebDriver driver;
	
	@BeforeSuite
    public void openBrowser()
    {
	  System.out.println("open browser");
	  System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\VIKAS\\\\OneDrive\\\\Desktop\\\\cjc_Testing\\\\chromedriver.exe");
	  driver=new ChromeDriver();
    }

@BeforeTest
public void enterUrl()
{
	System.out.println("enter url");
	driver.get("https://demo.guru99.com/test/newtours/register.php");
}
@BeforeClass
public void maximize()
{
	System.out.println("maximize browser==before class");
	driver.manage().window().maximize();
}
@BeforeMethod
public void getCookies()
{
	Set<Cookie> ck=driver.manage().getCookies();
	int count=ck.size();
	System.out.println(count);
}

@Test
public void logincheck() 
{
	  System.out.println("login success");
	  driver.findElement(By.name("firstName")).sendKeys("vikas");
	  driver.findElement(By.name("lastName")).sendKeys("potdar");
	  driver.findElement(By.name("phone")).sendKeys("123457869");
	  driver.findElement(By.name("userName")).sendKeys("abc@gmail.com");
	  driver.findElement(By.name("address1")).sendKeys("pune");
	  driver.findElement(By.name("city")).sendKeys("pune");
	  driver.findElement(By.name("state")).sendKeys("Maharashatra");
	  driver.findElement(By.name("postalCode")).sendKeys("12393");
	  driver.findElement(By.tagName("select")).sendKeys("japan");
	  driver.findElement(By.id("email")).sendKeys("QQQQ");
	  driver.findElement(By.name("password")).sendKeys("qqqq");
	  driver.findElement(By.name("confirmPassword")).sendKeys("qqqq");
	  driver.findElement(By.name("submit")).click();
	  System.out.println("ragistration succesfully");
	  
}
@AfterMethod
public void captureSc() throws IOException 
{
	  System.out.println("screenshot capture");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src,new File("C:\Users\VIKAS\OneDrive\Desktop\cjc_Testing\screenshot\sc.png"));
}

@AfterClass
public void deleteCookies()
{
	
	  System.out.println("deleteCookies");
}

@AfterTest
public void dbclose() 
{
	  System.out.println("close db connection");
}
@AfterSuite
public void closebrowser() 
{
	  System.out.println("closebrowser");
}

}
