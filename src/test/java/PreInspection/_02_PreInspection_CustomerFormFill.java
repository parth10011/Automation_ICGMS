package PreInspection;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.BaseClassICGMS;
import generic.login_ICGMS;
import generic.DBFunction;
public class _02_PreInspection_CustomerFormFill extends BaseClassICGMS
{

	@Test
	public void Customer_Form_Fill() throws InterruptedException, AWTException, EncryptedDocumentException, IOException 
	{
		//Login
		String username = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Log, 1, 0);
		String pass = DBFunction.getDataFromExcelSheet(EXCEL_PATH, Cust_Log, 1, 1); 
		login_ICGMS lp = new login_ICGMS(driver);
		lp.login(username, pass);
		
		//Open View Details List
		driver.findElement(By.xpath("(//button[text()='View Details'])[1]")).click();
		Thread.sleep(500);
		
		// Toaster Popup Click
		ToasterPopupClick();
		
		//Set Browser to Mobile View
		driver.manage().window().setSize(Mobile_View);
		Thread.sleep(1000);
		
		//Add Robot Class
		Robot r = new Robot();
    	Thread.sleep(1000);
    	
    	//Upload Front View Selfie Image
    	WebElement Front_View_Selfie = driver.findElement(By.xpath("//label[@for='front_view_selfie']"));
    	
    	Front_View_Selfie.click();    	
    	Thread.sleep(500);
    	
    	r.keyPress(KeyEvent.VK_ESCAPE);
    	r.keyRelease(KeyEvent.VK_ESCAPE);
    	Thread.sleep(500);    	
        
    	WebElement Front_View_Input = driver.findElement(By.xpath("//input[@id='front_view_selfie']"));
    	Thread.sleep(500);
    	
    	Front_View_Input.sendKeys(Img_Link);
    	
    	//Maximize Screen
    	driver.manage().window().maximize();
    	Thread.sleep(500);
    	
    	
    	//Upload Chassis Number Image    	    	        
    	WebElement Chassis_Number_Input = driver.findElement(By.xpath("//input[@id='chassis_number']")); 
    	Thread.sleep(1000);
    	Chassis_Number_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Odometer Number Image    	    	        
    	WebElement Odometer_Number_Input = driver.findElement(By.xpath("//input[@id='odometer_reading']"));    	
    	Thread.sleep(1000);
    	Odometer_Number_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Front Rh View Image    	        
    	WebElement Front_Rh_View_Input = driver.findElement(By.xpath("//input[@id='front_rh_view']"));    	
    	Thread.sleep(1000);
    	Front_Rh_View_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Front Lh View Image   	        
    	WebElement Front_Lh_View_Input = driver.findElement(By.xpath("//input[@id='front_lh_view']")); 
    	Thread.sleep(1000);
    	Front_Lh_View_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Rear View Image    	        
    	WebElement Rear_View_Input = driver.findElement(By.xpath("//input[@id='rear_view']"));    	
    	Thread.sleep(1000);
    	Rear_View_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Rear Lh View Image        
    	WebElement Rear_Lh_View_Input = driver.findElement(By.xpath("//input[@id='rear_lh_view']"));    	
    	Thread.sleep(1000);
    	Rear_Lh_View_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Rear Rh View Image    	        
    	WebElement Rear_Rh_View_Input = driver.findElement(By.xpath("//input[@id='rear_rh_view']"));    	
    	Thread.sleep(1000);
    	Rear_Rh_View_Input.sendKeys(Img_Link);
    	
    	//Upload RC Copy Image        
    	WebElement RC_Copy_Input = driver.findElement(By.xpath("//input[@id='rc_copy']"));    	
    	Thread.sleep(1000);
    	RC_Copy_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Front Windscreen Inside Image    	
    	WebElement Front_Windscreen_Inside_Input = driver.findElement(By.xpath("//input[@id='front_windscreen_inside']"));    	
    	Thread.sleep(1000);
    	Front_Windscreen_Inside_Input.sendKeys(Img_Link);    	
    	
    	
    	//Upload Engine Compartment Image    	
    	WebElement Engine_Compartment_Input = driver.findElement(By.xpath("//input[@id='engine_compartment_photo']"));    	
    	Thread.sleep(1000);
    	Engine_Compartment_Input.sendKeys(Img_Link);
    	
    	
    	//Upload Front Windscreen Outside Image    	
    	WebElement Front_Windscreen_Outside_Input = driver.findElement(By.xpath("//input[@id='front_windscreen_outside']"));    	
    	Thread.sleep(1000);
    	Front_Windscreen_Outside_Input.sendKeys(Img_Link);
    	  	
    	
    	//Upload Dashboard Image    	
    	WebElement Dashboard_Input = driver.findElement(By.xpath("//input[@id='dashboard']"));    	
    	Thread.sleep(1000);
    	Dashboard_Input.sendKeys(Img_Link);
    	
		
    	//Upload Under Chassis Image    	
    	WebElement Under_Chassis_Input = driver.findElement(By.xpath("//input[@id='under_chassis']"));    	
    	Thread.sleep(1000);
    	Under_Chassis_Input.sendKeys(Img_Link);
    	
    	//Upload Walkaround Video
    	WebElement Video_Input = driver.findElement(By.xpath("//input[@id='walkaround_video']"));    	
    	Thread.sleep(1000);
    	Video_Input.sendKeys(Vid_Link);
    	Thread.sleep(1000);
    	
    		
    	
    	//PAN Card Upload
    	WebElement PAN_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[1]"));    	
    	PAN_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Aadhar Card Upload
    	WebElement Aadhar_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[2]"));    	
    	Aadhar_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Passport Card Upload
    	WebElement Passport_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[3]"));    	
    	Passport_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Voter Card Upload
    	WebElement Voter_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[4]"));    	
    	Voter_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Driving License Card Upload
    	WebElement DL_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[5]"));    	
    	DL_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//RC Card Upload
    	WebElement RC_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[6]"));    	
    	RC_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Insurance Upload
    	WebElement Insurance_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[7]"));    	
    	Insurance_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
    	//Gov ID Upload
    	WebElement GovID_Input = driver.findElement(By.xpath("(//input[@accept='application/pdf'])[8]"));    	
    	GovID_Input.sendKeys(Doc_Link);
    	Thread.sleep(1000);
    	
		//Signature
    	WebElement Sigarea = driver.findElement(By.xpath("//textarea[@placeholder='Sign here.........']"));
    	Sigarea.click();
    	Thread.sleep(1000);
    	WebElement canvas = driver.findElement(By.xpath("//canvas[@width='700' or height='200']"));
    	canvas.click();
    	Thread.sleep(1000);
    	WebElement submit_sign = driver.findElement(By.xpath("//button[text()='Submit the signature']"));
    	submit_sign.click();
    	WebElement close_sign = driver.findElement(By.xpath("//button[@aria-label='Close']"));
    	close_sign.click();
    	Thread.sleep(1000);
    	
    	//Submit Customer Form
    	WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
    	submit.click();
    	Thread.sleep(2000);
    	System.out.println("Customer Form Filled Successfully");
    	
    	// Toaster Popup Click
    	ToasterPopupClick();
    	
	}
	
}
