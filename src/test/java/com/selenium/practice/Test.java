/**
 * 
 */
package com.selenium.practice;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	@org.junit.Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.xpath("//*[@id=\"login1\"]"));
		userName.sendKeys("abc");
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("1234");
		
		WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"));
		login.click();
		
		WebElement page = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/p/span"));
		String errmsg = page.getText();
		assertEquals(errmsg, "Your security is important!");
	}

}
