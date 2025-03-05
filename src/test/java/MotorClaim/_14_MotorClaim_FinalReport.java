package MotorClaim;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.DBFunction;
import generic.login_ICGMS;

public class _14_MotorClaim_FinalReport extends BaseClassICGMS 
{

	@Test
	public void MotorClaim_FinalReport() throws InterruptedException, AWTException, EncryptedDocumentException, IOException
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Surveyor_Login, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		//Toaster Popup Click
		ToasterPopupClick();
		
		//Open View List
		WebElement claim_list = driver.findElement(By.xpath("//a[@href='/surveyor-claim-list']"));
		claim_list.click();

		//Open Final Report
		WebElement finalReport_button = driver.findElement(By.xpath("//button[contains(text(),'Final Report')][1]"));
		finalReport_button.click();
		Thread.sleep(500);
				
		//Upload Final Report
		WebElement finalReport_upload = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		finalReport_upload.sendKeys(Est_Report);
		
		//Enter Remark
		WebElement remark = driver.findElement(By.xpath("//textarea[@placeholder='Enter Your Remark']"));
		remark.sendKeys("Report Uploaded Successfully");
		
		//Upload Document Files
		WebElement doc_upload = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		doc_upload.sendKeys(Doc_Link);
		
		//Enter File Name
		WebElement file_name = driver.findElement(By.xpath("//input[@placeholder='Enter filename']"));
		file_name.sendKeys("DummyZeroGo");
		
		//Add more Button Click
		WebElement Add_button = driver.findElement(By.xpath("//button[@ngbtooltip='add row']"));
		Add_button.click();
		
		//Set Browser to Mobile View
		driver.manage().window().setSize(Mobile_View);
		Thread.sleep(500);
		
		// Close Menu
		WebElement closeMenu = driver.findElement(By.xpath("//i[@class='ti-close']"));
		closeMenu.click();
		
		//Add Robot Class
		Robot r = new Robot();
	    Thread.sleep(500);
		
	    //Scroll to the particular web element of page
	    WebElement Image = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Image);					
		Thread.sleep(500);
	    
		//Upload Image
		Image = driver.findElement(By.xpath("//label[@for='cameraInput0']"));
		Image.click();
		    	
		Thread.sleep(500);
		    	
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
    	Thread.sleep(1000);
    	
    	//Maximize Screen
    	driver.manage().window().maximize();
    	
       
    	WebElement Image_Input = driver.findElement(By.xpath("//input[@id='cameraInput0']"));
    	Thread.sleep(500);
		    	
    	Image_Input.sendKeys(Img_Link);
    	
    	//Toaster Popup Click
    	ToasterPopupClick();
		
		//View Customer Inspection Report
		WebElement view_button = driver.findElement(By.xpath("//button[text()=' View ']"));
		view_button.click();
		Thread.sleep(1000);
		
		// Toaster Pdf Popup Click
        WebElement pdf_toaster = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@toast-component='']")));
        pdf_toaster.click();
        Thread.sleep(1000);
        
        //Close Button Click
        WebElement close_button = driver.findElement(By.xpath("//button[@aria-label='Close']"));
	    close_button.click();
	    Thread.sleep(1000);
	    
	    //Submit Customer Form
		WebElement submit = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		submit.click();
		Thread.sleep(1000);
		
		//Toaster Popup Click
		ToasterPopupClick();
	}
}
