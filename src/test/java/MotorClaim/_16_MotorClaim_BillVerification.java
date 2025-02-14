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

public class _16_MotorClaim_BillVerification 
{

	public class _11_MotorClaim_RepairerAuthorization extends BaseClassICGMS 
	{

		@Test
		public void MotorClaim_RepairerAuthorization() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
		{
			//Login
			String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 0);
			String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 1); 
			login_ICGMS lp = new login_ICGMS(driver);
			lp.login(username, pass);
					
			// Toaster Popup Click
			ToasterPopupClick();
			
			//Open View List
			WebElement claim_list = driver.findElement(By.xpath("//a[@href='/surveyor-claim-list']"));
			claim_list.click();
			Thread.sleep(500);
			
			//Bill Verification Button Click
			driver.findElement(By.xpath("(//button[text()='Bill Verification'])[1]")).click();
			Thread.sleep(500);
			
			// View Reapirer Bill
			WebElement repair_bill = driver.findElement(By.xpath("(//button[text()='View'])[1]"));
			repair_bill.click();
			
			//Toaster Popup Click
			ToasterPopupClick();
			
			// Close Pdf
			WebElement close_pdf = driver.findElement(By.xpath("//button[@aria-label='Close']"));
			close_pdf.click();
			
			// View Survey Bill
			WebElement survey_bill = driver.findElement(By.xpath("(//button[text()='View'])[2]"));
			survey_bill.click();
			
			//Toaster Popup Click
			ToasterPopupClick();
			
			// Close Pdf
			close_pdf = driver.findElement(By.xpath("//button[@aria-label='Close']"));
			close_pdf.click();
			
			// View Inspection Report
			WebElement inspection_report = driver.findElement(By.xpath("(//button[text()='View'])[3]"));
			inspection_report.click();
			
			//Toaster Popup Click
			ToasterPopupClick();
			
			// Close Pdf
			close_pdf = driver.findElement(By.xpath("//button[@aria-label='Close']"));
			close_pdf.click();
			
			// View Final Report
			WebElement final_report = driver.findElement(By.xpath("(//button[text()='View'])[4]"));
			final_report.click();
			
			//Toaster Popup Click
			ToasterPopupClick();
			
			// Close Pdf
			close_pdf = driver.findElement(By.xpath("//button[@aria-label='Close']"));
			close_pdf.click();
			
			//View Customer Inspection Report
			WebElement view_button = driver.findElement(By.xpath("//button[text()=' View ']"));
			view_button.click();
			
			// Toaster Pdf Popup Click
			ToasterPopupClick();
	        
	        //Close Button Click
	        WebElement close_button = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		    close_button.click();
		    Thread.sleep(1000);
		    
		    //Enter Remark
			WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Remark']"));
			remark.sendKeys("Report Viewing Successfully");
			Thread.sleep(500);
		    
		    //Click Approve
		    WebElement Approve = driver.findElement(By.xpath("//span[text()='Approve']"));
		    Approve.click();
		    
		    //Toaster Popup Click
		    ToasterPopupClick();
		    
		    //Open View List
			claim_list = driver.findElement(By.xpath("//a[@href='/surveyor-claim-list']"));
			claim_list.click();
			Thread.sleep(500);
	
		}
		
	}	
}
