package com.sgtesting.dataprovider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario1 {
	private static WebDriver wd=null;
	@Test(priority = 1)
	private static void launch()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "E:\\JavaAutomation\\Excel-Automation2\\Trial-Framework\\Library\\Driver\\chromedriver.exe");
			wd=new ChromeDriver();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 2)
	private static void navigate()
	{
		try 
		{
			wd.get("http://localhost:8080/login.do");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test (priority = 3,dataProvider ="credentials" )
	private static void login(String user,String pwd)
	{
		try 
		{
			wd.findElement(By.id("username")).sendKeys(user);
			wd.findElement(By.name("pwd")).sendKeys(pwd);
			wd.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
			Thread.sleep(2500);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="credentials")
	public Object[][] getlogindetails()
	{
		return new Object[][] {{"admin","manager"}};
		
	}
	@Test (priority = 4,dataProvider = "createuser")
	private static void createUser(String fn, String ln, String email, String username,String pwd, String pwdcopy)
	{
		try 
		{
			wd.findElement(By.xpath("//a[@class='content users']")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(1000);
			wd.findElement(By.name("firstName")).sendKeys(fn);
			wd.findElement(By.name("lastName")).sendKeys(ln);
			wd.findElement(By.name("email")).sendKeys(email);
			wd.findElement(By.name("username")).sendKeys(username);
			wd.findElement(By.name("password")).sendKeys(pwd);
			wd.findElement(By.name("passwordCopy")).sendKeys(pwdcopy);
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\"userDataLightBox_commitBtn\"]")).click();
			Thread.sleep(4000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="createuser")
	public Object [][] getcreate()
	{
		return new Object[][] {{"Sujeeth","Kumar","sujeeth@gmail.com","sujeeth17","welcome123","welcome123"}};	
	}
	@Test(priority = 5)
	private static void deleteUser()
	{
		try 
		{
			wd.findElement(By.xpath("//span[text()='Kumar, Sujeeth']")).click();
			Thread.sleep(2000);
			wd.findElement(By.xpath("//*[@id=\"userDataLightBox_deleteBtn\"]")).click();
			Thread.sleep(2000);
			Alert alt=wd.switchTo().alert();
			alt.accept();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 6)
	private static void logout()
	{
		try
		{
			wd.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 7)
	private static void closeApp()
	{
		try
		{
			wd.quit();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
