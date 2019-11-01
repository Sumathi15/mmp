package com.mmp.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mmp.base.TestBaseClass;
import com.mmp.pages.HomePage;
import com.mmp.pages.LoginPage;

public class LoginPageTest extends TestBaseClass {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		
	}

	
	@BeforeMethod
	public void setup(){
		browserinitialization();
		loginpage =new LoginPage();
		
	}
	private void browserinitialization() {
		// TODO Auto-generated method stub
		
	}


	@Test(priority=1)
	public void LoginPagetitleTest() {
	String title =	loginpage.validateLoginPageTitle();
	Assert.assertEquals(title, "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal");
	
	}
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
		
	}
}

