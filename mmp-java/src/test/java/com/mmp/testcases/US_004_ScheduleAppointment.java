package com.mmp.testcases;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mmp.base.TestBaseClass;


 
public class US_004_ScheduleAppointment extends TestBaseClass{
	
    @Test
   
    public void validateAppointment() throws InterruptedException
    {
        //Login
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
        driver.findElement(By.id("username")).sendKeys("ria1");
        driver.findElement(By.id("password")).sendKeys("Ria12345");
        driver.findElement(By.name("submit")).click();
        String actual = driver.findElement(By.tagName("h3")).getText();
        String expected = "ria1";
        Assert.assertEquals(actual, expected);
        
        //Navigate to Schedule Appointment
        driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
        actual = driver.findElement(By.tagName("h3")).getText();
        expected = "Current Appointments";
         
        //Schedule Appointment
        driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
         
        String actualSymptom = driver.findElement(By.xpath("//p[contains(text(),'Description:Cardiologist')]")).getText();
        String actualDoctorName= driver.findElement(By.xpath("//h4[contains(text(),'Dr.Charlie')]")).getText();
        String expectedSymptom="Cardiologist";
        String expectedDoctorName="Dr.Charlie";
         
        if(actualSymptom.contains(expectedSymptom)&&actualDoctorName.equals(expectedDoctorName))
        {
            driver.findElement(By.xpath("//h4[contains(text(),'Dr.Charlie')]//ancestor::td/button")).click();
             
        }
        else
        {
            System.out.println("Doctor the for the specilization is not Available!!!");
        }
         
        driver.switchTo().frame(0);
         
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.id("time")));
        List<WebElement> options = select.getOptions();
        options.get(new Random().nextInt(1)).click();
        driver.findElement(By.id("ChangeHeatName")).click();
         
         
         driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all ui-state-hover ui-datepicker-next-hover']")).click();
        driver.findElement(By.linkText("3")).click();
          
        driver.switchTo().defaultContent();
        String symptomName = "Fever";
        driver.findElement(By.id("sym")).sendKeys("Fever");
        driver.findElement(By.xpath("//input[@value='Submit']")).submit();
         
        Assert.assertTrue( driver.findElement(By.xpath("//table/tbody/tr[1]")).getText().contains(expectedSymptom));
        Assert.assertTrue(  driver.findElement(By.xpath("//table/tbody/tr[1]")).getText().contains(expectedDoctorName));
        Assert.assertTrue( driver.findElement(By.xpath("//table/tbody/tr[1]")).getText().contains(symptomName));
         
         
    }
 
}