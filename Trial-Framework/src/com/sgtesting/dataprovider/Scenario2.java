package com.sgtesting.dataprovider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario2 {
	public static WebDriver wd=null;
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
	@Test(priority =2)
	private static void navigate()
	{
		try
		{
			wd.get("http://localhost:8080/login.do");
			Thread.sleep(4000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 3,dataProvider = "Login")
	private static void login(String un, String pd)
	{
		try 
		{
			wd.findElement(By.id("username")).sendKeys(un);
			wd.findElement(By.name("pwd")).sendKeys(pd);
			wd.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
			Thread.sleep(2500);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="Login")
	public Object[][] getLogindetails()
	{
		return new Object[][] {{"admin","manager"}};
	}
	@Test(priority = 4,dataProvider = "UserDetails")
	private static void createUser(String fn, String ln, String email, String username,String pwd, String pwdcopy)
	{
		try 
		{
			wd.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[5]/a")).click();
			wd.findElement(By.xpath("//*[@id=\"createUserDiv\"]/div")).click();
			wd.findElement(By.name("firstName")).sendKeys(fn);
			wd.findElement(By.name("lastName")).sendKeys(ln);
			wd.findElement(By.name("email")).sendKeys(email);
			wd.findElement(By.name("username")).sendKeys(username);
			wd.findElement(By.name("password")).sendKeys(pwd);
			wd.findElement(By.name("passwordCopy")).sendKeys(pwdcopy);
			wd.findElement(By.xpath("//*[@id=\"userDataLightBox_commitBtn\"]")).click();
			Thread.sleep(3000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="UserDetails")
	public Object [][] getuserdetails()
	{
		return new Object [][] {{"Basu","Patil","basu@gmail.com","basu17","basu123","basu123"}};
	}
	
	@Test(priority = 5,dataProvider = "modify")
	private static void modifyuser(String modifyln)
	{
		try 
		{
			wd.findElement(By.xpath("//span[text()='Patil, Basu']")).click();
			Thread.sleep(2000);
			wd.findElement(By.name("lastName")).clear();
			Thread.sleep(1000);
			wd.findElement(By.name("lastName")).sendKeys(modifyln);
			Thread.sleep(1000);
			wd.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="modify")
	public Object[][] getmodifyln()
	{
		return new Object [][] {{"N"}};
	}
	
	@Test(priority = 6)
	private static void deleteUser()
	{
		try 
		{
			wd.findElement(By.xpath("//span[text()='N, Basu']")).click();
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
	@Test(priority = 7)
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
	
	@Test(priority = 8)
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
