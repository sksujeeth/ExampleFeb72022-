package com.sgtesting.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Scenario4 {
private static WebDriver driver=null;
	
	@Test
	private static void launch()
	{
		try 
		{
			System.setProperty("webdriver.gecko.driver", "E:\\JavaAutomation\\Excel-Automation2\\Trial-Framework\\Library\\Driver\\geckodriver.exe");
			driver =new FirefoxDriver();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 1)
	private static void navigate()
	{
		try 
		{
			driver.get("http://localhost:8080/login.do");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 2,dataProvider = "Login")
	private static void login(String un, String pd)
	{
		try 
		{
			driver.findElement(By.name("username")).sendKeys(un);
			Thread.sleep(1200);
			driver.findElement(By.name("pwd")).sendKeys(pd);
			Thread.sleep(1200);
			driver.findElement(By.xpath("//div[text()='Login ']")).click();
			Thread.sleep(1500);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="Login")
	public Object[][] getLogin()
	{
		return new Object[][] {{"admin","manager"}};
	}
	@Test(priority = 3,dataProvider = "customer")
	private static void createcust(String cust, String desc)
	{
		try
		{
			driver.findElement(By.xpath("//*[@id=\"topnav\"]/tbody/tr[1]/td[3]/a")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("//div[text()='Add New']")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("/html/body/div[12]/div[1]")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@id='customerLightBox_nameField']")).sendKeys(cust);
			driver.findElement(By.xpath("//*[@id='customerLightBox_descriptionField']")).sendKeys(desc);
			Thread.sleep(1200);
			driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
			Thread.sleep(3000);	
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@DataProvider (name="customer")
	public Object[][] getcutomer()
	{
		return new Object[][] {{"Nestle","FMGC"}};
	}
	@Test(priority = 4,dataProvider = "modify")
	private static void modifycust(String description)
	{
		try 
		{
			driver.findElement(By.xpath("/html/body/div[10]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[1]/textarea")).clear();
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[2]/div[1]/div[3]/div[2]/div/div[1]/textarea")).sendKeys(description);
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(1200);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@DataProvider(name="modify")
	public Object[][] getmodifycust()
	{
		return new Object[][] {{"FOOD Manufacturing "}};
	}
	@Test(priority = 5)
	private static void deletecust()
	{
		try 
		{
			driver.findElement(By.xpath("/html/body/div[10]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[2]/div[1]/div[4]/div/div")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[2]/div[4]/div/div[3]/div")).click();
			Thread.sleep(1200);
			driver.findElement(By.xpath("//*[@*='customerPanel_deleteConfirm_submitTitle']")).click();
			Thread.sleep(1200);
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
			driver.findElement(By.id("logoutLink")).click();
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
			driver.quit();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
