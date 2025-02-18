package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _18_MotorClaim_Completion extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_Completion() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Admin_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		Thread.sleep(500);
		
		//Open View List
		WebElement view_list = driver.findElement(By.xpath("//a[@href='/claim-details']"));
		view_list.click();
		
		//Completion Button Click
		driver.findElement(By.xpath("(//button[text()='Completion'])[1]")).click();
		Thread.sleep(500);
		
		//Enter Date of Delivery of vehicle
		WebElement DoV = driver.findElement(By.id("vehicle_delivery"));
		DoV.sendKeys(current_date);
		
		//Select Process Completed radio button
		WebElement proComp = driver.findElement(By.id("processedYes"));
		proComp.click();
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
	    submit.click();
	    
	    //Toaster Popup Click
	    ToasterPopupClick();
	    
	    //Open View List
		view_list = driver.findElement(By.xpath("//a[@href='/claim-details']"));
		view_list.click();
		Thread.sleep(500);
		
	}
	
}
