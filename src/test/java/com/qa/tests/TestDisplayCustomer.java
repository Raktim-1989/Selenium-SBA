package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.CustomerForm;
import com.qa.pages.DisplayCustomer;
import com.qa.setup.DriverSetup;
import com.qa.setup.ExcelUtils;

public class TestDisplayCustomer extends DriverSetup{
	public static String titletxt;
	public static String customerNametxt;
	public static String agetxt;
	public static String addresstxt;
	public static String emailtxt;
	public static String numbertxt;
	
	Object[][] datavalidprovider;
	CustomerForm customerform;
	DisplayCustomer displaycustomer;

	@BeforeClass
	public void setUp()
	{
		driver = DriverSetup.createDriver();
		customerform = new CustomerForm(driver);
		displaycustomer = new DisplayCustomer(driver);
	}
	
	@Test(dataProvider = "customerValid")
	public void testValidCustomerDetails(String testcasename,String name, String age, String address, String phonenumber, String email)
	{
		driver.get("https://webapps.tekstac.com/CustomerRegistration");
		driver.manage().window().maximize();
		customerform.setCustomerName(name);
		customerform.setAge(age);
		customerform.setAddress(address);
		customerform.setEmail(email);
		customerform.setPhoneNumber(phonenumber);
		customerform.submitForm();
		///verification of all the fields after successful registration
		
		titletxt = displaycustomer.getTitle();
		customerNametxt = displaycustomer.getName();
		agetxt = displaycustomer.getAge();
		addresstxt = displaycustomer.getAddress();
		numbertxt = displaycustomer.getPhoneNumber();
		emailtxt = displaycustomer.getEmail();
		
		Assert.assertEquals(titletxt, "Registered Succesfully");
		//Registered Succesfully
		Assert.assertEquals(customerNametxt, name + " " + age);
		Assert.assertEquals(agetxt, age);
		Assert.assertEquals(addresstxt,address);
		Assert.assertEquals(numbertxt, phonenumber);
		Assert.assertEquals(emailtxt, email);	
		
	}
	
	
	@DataProvider(name = "customerValid")
	public Object[][] getExcelData()
	{
		try {
			datavalidprovider = ExcelUtils.readExcelData("customer_valid");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datavalidprovider;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
