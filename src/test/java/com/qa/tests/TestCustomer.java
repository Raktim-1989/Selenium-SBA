package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.CustomerForm;
import com.qa.setup.DriverSetup;
import com.qa.setup.ExcelUtils;

public class TestCustomer extends DriverSetup {
	
	CustomerForm customerform;
	Object[][] dataprovider;
	static String blankerrtext = "phoneNumber cannot be blank";
	
	@BeforeClass
	public void setUp()
	{
		driver =  DriverSetup.createDriver();
	}
	
	@Test(dataProvider = "customerInvalid")
	public void testInvalidCustomerDetails(String testcasename,String name, String age, String address, String phonenumber, String email )
	{
		driver.get("https://webapps.tekstac.com/CustomerRegistration");
		driver.manage().window().maximize();
		customerform = new CustomerForm(driver);
		customerform.setCustomerName(name);
		customerform.setAge(age);
		customerform.setAddress(address);
		customerform.setEmail(email);
		customerform.setPhoneNumber(phonenumber);
		customerform.submitForm();
		
		Assert.assertEquals(blankerrtext, driver.findElement(By.id("message")).getText());			
	}
	@DataProvider(name = "customerInvalid")
	public Object[][] getExcelData()
	{
		//dataprovider = new Object[1][6];
		try {
			dataprovider = ExcelUtils.readExcelData("customer_invalid");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return dataprovider;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
