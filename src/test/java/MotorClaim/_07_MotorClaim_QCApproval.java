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

public class _07_MotorClaim_QCApproval extends BaseClassICGMS
{

	@Test
	public void MotorClaim_QCApproval() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
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
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		
		//QC Approval Button Click
		driver.findElement(By.xpath("(//button[text()='QC Approval'])[1]")).click();
		Thread.sleep(500);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Approval Done");
		Thread.sleep(500);
		
		//Click Submit
		WebElement submit = driver.findElement(By.xpath("//span[text()='Approve']"));
		submit.click();
		Thread.sleep(1000);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		driver.findElement(By.xpath("//a[@href='/claim-details']")).click();
		
	}
}
