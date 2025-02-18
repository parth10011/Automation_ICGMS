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

public class _Feedback_From_All_Users extends BaseClassICGMS
{

	@Test(priority = 1)
	public void MotorClaim_Feedback_From_Customer() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{	
		
		//Login to Customer
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Click on Give Feedback button
		WebElement custFeedback = driver.findElement(By.xpath("(//button[text()='Give Feedback'])[1]"));
		custFeedback.click();
		
		// Give Overall rating to process
		WebElement overallRating = driver.findElement(By.xpath("(//span[text()='★'])[5]"));
		overallRating.click();
		
		// Give recommend to others rating to process
		WebElement recRating = driver.findElement(By.xpath("(//span[text()='★'])[9]"));
		recRating.click();
		
		// Give easiness rating to process
		WebElement easyRating = driver.findElement(By.xpath("(//span[text()='★'])[13]"));
		easyRating.click();
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
	    submit.click();
	    Thread.sleep(500);
	    
	}
	
	@Test(priority = 2)
	public void MotorClaim_Feedback_From_Insurer() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{	
		
		//Login to Insurer
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Insurer_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Click on Give Feedback button
		WebElement custFeedback = driver.findElement(By.xpath("(//button[text()='Give Feedback'])[1]"));
		custFeedback.click();
		
		// Give Overall rating to process
		WebElement overallRating = driver.findElement(By.xpath("(//span[text()='★'])[5]"));
		overallRating.click();
		
		// Give recommend to others rating to process
		WebElement recRating = driver.findElement(By.xpath("(//span[text()='★'])[9]"));
		recRating.click();
		
		// Give easiness rating to process
		WebElement easyRating = driver.findElement(By.xpath("(//span[text()='★'])[13]"));
		easyRating.click();
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
	    submit.click();
	    Thread.sleep(500);
	    
	}
	
	@Test(priority = 3)
	public void MotorClaim_Feedback_From_Repairer() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{	
		
		//Login to Repairer
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Repair_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Repair_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		WebElement claim_list = driver.findElement(By.xpath("//a[@href='/repairer-claim-list']"));
		claim_list.click();
		
		//Click on Give Feedback button
		WebElement custFeedback = driver.findElement(By.xpath("(//button[text()='Give Feedback'])[1]"));
		custFeedback.click();
		
		// Give Overall rating to process
		WebElement overallRating = driver.findElement(By.xpath("(//span[text()='★'])[5]"));
		overallRating.click();
		
		// Give recommend to others rating to process
		WebElement recRating = driver.findElement(By.xpath("(//span[text()='★'])[9]"));
		recRating.click();
		
		// Give easiness rating to process
		WebElement easyRating = driver.findElement(By.xpath("(//span[text()='★'])[13]"));
		easyRating.click();
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
	    submit.click();
	    Thread.sleep(500);
	    
	}
	
	@Test(priority = 4)
	public void MotorClaim_Feedback_From_Surveyor() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{	
		
		//Login to Surveyor
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		WebElement claim_list = driver.findElement(By.xpath("//a[@href='/surveyor-claim-list']"));
		claim_list.click();
		
		//Click on Give Feedback button
		WebElement custFeedback = driver.findElement(By.xpath("(//button[text()='Give Feedback'])[1]"));
		custFeedback.click();
		
		// Give Overall rating to process
		WebElement overallRating = driver.findElement(By.xpath("(//span[text()='★'])[5]"));
		overallRating.click();
		
		// Give recommend to others rating to process
		WebElement recRating = driver.findElement(By.xpath("(//span[text()='★'])[9]"));
		recRating.click();
		
		// Give easiness rating to process
		WebElement easyRating = driver.findElement(By.xpath("(//span[text()='★'])[13]"));
		easyRating.click();
		
		//Click Submit
	    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
	    submit.click();
	    Thread.sleep(500);
	}
	    
	@Test(priority = 5)
	public void MotorClaim_FeedBack_FinalCompletion() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
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
		
		//Final Completion Button Click
		driver.findElement(By.xpath("(//button[text()='Final Completion'])[1]")).click();
		Thread.sleep(500);
		
		//Complete Claim Button Click
		driver.findElement(By.xpath("(//button[text()='Complete Claim'])[1]")).click();
		Thread.sleep(500);
	    
	}
}