package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _09_MotorClaim_SurveyorAppointment extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_SurveyorAppointment() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
				
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Surveyor Appointment Button Click
		driver.findElement(By.xpath("(//button[text()=' Surveyor Appointment '])[1]")).click();
		
		//Select Surveyor Name
		WebElement Surveyor_Name = driver.findElement(By.xpath("//select[@formcontrolname='surveyor_id']"));

		Select s2 = new Select(Surveyor_Name);
		try {
		    s2.selectByVisibleText("Surveyor Phase I Corporation");
		} catch (NoSuchElementException e) {
		    s2.selectByVisibleText("UAT Test Surveyor ");
		}
//		s2.selectByVisibleText("Surveyor Phase I Corporation" or "UAT Test Surveyor "); 
		
		//Enter Date Of Visit
		WebElement date_visit = driver.findElement(By.xpath("//input[@type='date']"));
		date_visit.sendKeys(current_date);
		
		//Enter Time Of Visit
		WebElement time_visit = driver.findElement(By.xpath("//input[@type='time']"));
		time_visit.sendKeys(current_time);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Appointment Completed Successfully");
		
		//Click Appoint
		WebElement Appoint_Button = driver.findElement(By.xpath("//span[text()='Appoint']"));
		Appoint_Button.click();
		Thread.sleep(1000);
		
		//Open View List
		driver.findElement(By.xpath("//a[@href='/insurer-claim-list']")).click();
		Thread.sleep(500);
		
		//Toaster Popup Click
		ToasterPopupClick();
		
	}
}
