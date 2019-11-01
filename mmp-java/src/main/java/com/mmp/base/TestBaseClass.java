package com.mmp.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
     
    public WebDriver driver;
    @BeforeTest
    @Parameters({"browserType"})
    public void intiateDriverInstance(String browserType)
         {
        if(browserType.equals("IE"))
        {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        else if(browserType.equals("FF"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }
 
}