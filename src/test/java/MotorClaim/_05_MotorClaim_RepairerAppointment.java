package MotorClaim;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _05_MotorClaim_RepairerAppointment extends BaseClassICGMS
{

	@Test
	public void MotorClaim_RepairerAppointment() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		//Toaster Popup Click
		ToasterPopupClick();
		
		//Open Repairer Appointment
		WebElement appoint_button = driver.findElement(By.xpath("(//button[text()='Repairer Appointment'])[1]"));
		appoint_button.click();
		
		//Select Repairer Type
		WebElement Repair_Type = driver.findElement(By.xpath("//select[@formcontrolname='repairer_id']"));

		Select s = new Select(Repair_Type);
		s.selectByVisibleText(" Parth Repair Corporation ");
//		s.selectByContainsVisibleText("Ehtasham");
		Thread.sleep(500);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@formcontrolname='repairer_remark']"));
		remark.sendKeys("Approval Done");
		Thread.sleep(500);
		
		//Click Appoint
		WebElement appoint = driver.findElement(By.xpath("//button[@type='submit']"));
		appoint.click();
		Thread.sleep(500);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
	}
	
	
}
