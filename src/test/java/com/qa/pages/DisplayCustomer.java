package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisplayCustomer {
   
	WebDriver driver;
	static String titletxt;
	static String customerNametxt;
	static String agetxt;
	static String emailtxt;
	static String addresstxt ;
	static String phonetxt;
	
	public DisplayCustomer(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle()
	{
		 titletxt = driver.findElement(By.xpath("//html//body/h2")).getText();
		return titletxt;
	}
	public String getName()
	{
		customerNametxt = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
		return customerNametxt;
	}
	public String getAge()
	{
		agetxt = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
		return agetxt;
	}
	public String getEmail()
	{
		emailtxt = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
		return emailtxt;
	}
	public String getAddress()
	{
		addresstxt = driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText();
		return addresstxt;
	}
	public String getPhoneNumber()
	{
		phonetxt = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]")).getText();
		return phonetxt;
	}
	
	
	
}
