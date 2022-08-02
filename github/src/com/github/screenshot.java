package com.github;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class screenshot {

	public static void main(String[] args) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIKAS\\OneDrive\\Desktop\\cjc_Testing\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("web_page  is open");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src,new File("C:\\Users\\VIKAS\\OneDrive\\Desktop\\cjc_Testing\\screenshot\\image1.png"));
		driver.close();
		

	}


}
