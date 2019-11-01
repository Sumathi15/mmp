package com.mmp.pages;

//import com.mmp.base.TestBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mmp.base.TestBaseClass;

public class LoginPage extends TestBaseClass{
	
      @FindBy(name="username")
      WebElement username; 
      
      @FindBy (name="password")
      WebElement password;
      
      @FindBy (xpath="//input[@type='submit']")
      WebElement SignInBtn;
      
      @FindBy (xpath="//input[@type='register']")
      WebElement RegisterBtn;
      
      public LoginPage() {
    	  PageFactory.initElements(driver, this);
    	  
      }
      
      public String validateLoginPageTitle() {
		return driver.getTitle();
    	  
      }
      
      public HomePage SignIn(String un, String pwd){
    	  username.sendKeys(un);
    	  password.sendKeys(pwd);
    	  SignInBtn.click();
    	  
    	  return new HomePage();
    	  
    	 
    	  
      }
}
