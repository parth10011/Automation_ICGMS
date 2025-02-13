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

public class _10_MotorClaim_SurveyorReport extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_SurveyorReport() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
				
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Surveyor Appointment Button Click
		driver.findElement(By.xpath("(//button[text()=' Surveyor Report '])[1]")).click();
		
		//Upload Surveyor Report Document
		WebElement Surveyor_Report_Input = driver.findElement(By.xpath("(//input[@type='file'])[1]")); 
    	Thread.sleep(500);
    	Surveyor_Report_Input.sendKeys(Doc_Link);
    	
    	//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Report Uploaded Successfully");
		Thread.sleep(500);
		
		// Reinspection Required Radio Button
		WebElement Re_Inspection_Radio = driver.findElement(By.xpath("(//input[@formcontrolname='is_re_inspection_required'])[1]"));
		Re_Inspection_Radio.click();
		
		//Upload Document
		WebElement Document_Upload = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
		Document_Upload.sendKeys(Doc_Link);
		
		//Enter File Name
		WebElement File_Name = driver.findElement(By.xpath("//input[@placeholder='Enter filename']"));
		File_Name.sendKeys("Dummydotpdf");
		Thread.sleep(500);
		
		//Click Submit
		WebElement Submit_Button = driver.findElement(By.xpath("//span[text()='Submit']"));
		Submit_Button.click();
		Thread.sleep(1000);
		
		//Open View List
		driver.findElement(By.xpath("//a[@href='/insurer-claim-list']")).click();
		Thread.sleep(500);
		
		//Toaster Popup Click
		ToasterPopupClick();
	}
}
