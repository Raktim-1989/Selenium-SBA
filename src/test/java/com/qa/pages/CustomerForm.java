package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerForm {
	WebDriver driver;
	String message;
	
	public CustomerForm(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setCustomerName(String cname) 
	{
		driver.findElement(By.name("cname")).sendKeys(cname);
	}
	public void setAge(String age) 
	{
		driver.findElement(By.name("age")).sendKeys(age);

	}
	public void setAddress(String address) 
	{
		driver.findElement(By.name("address")).sendKeys(address);
	}
	public void setPhoneNumber(String phonenumber) 
	{
		driver.findElement(By.name("phonenumber")).sendKeys(phonenumber);
	}
	public void setEmail(String email) 
	{
		driver.findElement(By.name("email")).sendKeys(email);
	}
	public void submitForm() 
	{
		driver.findElement(By.id("submit")).click();
	}
	public String getErrorMessage() 
	{
		message = driver.findElement(By.id("message")).getText();
		return message;
		
	}

}
