package Pageobjects;
import java.io.File;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testbase.baseclass;
import utilities.ExcelUtils;
import testbase.baseclass;
public class Car_insurance03 extends basepage{
	
//	baseclass b = new baseclass();
	
	public Car_insurance03(WebDriver driver) 
	{
		super(driver);
	}
	

	@FindBy(xpath="(//a[text()='Car Insurance'])[2]")
	WebElement CI ;
	
	@FindBy(xpath="//span[text()='car? Click here']")
	public WebElement BuyingNewCar ;
	
	@FindBy(xpath="//div[text()='Chennai ']")
	WebElement CityChn ;
	
	@FindBy(xpath="//span[text()='TN10']")
	WebElement Carmodel;
	
	@FindBy(xpath="(//img[@alt='Skoda'])[1]")
	WebElement Skoda ;
	
	@FindBy(xpath="//span[text()='RAPID']")
	WebElement Rapidmodel ;
	
	@FindBy(xpath="//span[text()='Diesel']")
	WebElement Diesel ;
	
	
	@FindBy(xpath="(//span[text()='Automatic'])[1]")
	WebElement Automatic ;
	
	@FindBy(xpath="//span[text()='1.5 TDI CR AMBITION AT']")
	WebElement Ambition ;
	
	@FindBy(xpath="//input[@class='inputbox txtName']")
	WebElement Entername ;
	
	@FindBy(xpath="//input[@class='inputbox txtEmail']")
	WebElement Enteremailwrong ;
	
	@FindBy(xpath="//input[@id='mobNumber']")
	WebElement Entermobile ;
	
	
	@FindBy(xpath="//div[text()='Please enter valid email address']")
	WebElement Erromsg;
	

	@FindBy(xpath="//input[@id='txtEmail']")
	WebElement EmailCorrect ;
	
	@FindBy(xpath="//div[text()='View Prices ']")
	WebElement Viewprices ;
	
	  //------------------------------//
	
	
	/*@FindBy(xpath="//div[text()='Brand new car? ']")
	public WebElement brand ;
	
	@FindBy(xpath="//span[text()='Click here ']")
	WebElement newcar ;
	
	@FindBy(xpath="(//span[@class='truncate'])[9]")
	WebElement chennai01 ;
	
	@FindBy(xpath="//li[@class='rtoItem '][9]")
	WebElement ten ;
	
	@FindBy(xpath="//li[@class='skoda ']")
	WebElement skoda1 ;
	
	@FindBy(xpath="//li[text()='RAPID']")
	WebElement rapid1 ;
	
	@FindBy(xpath="//li[text()='Diesel']")
	WebElement diesel1 ;
	
	@FindBy(xpath="//li[text()='Automatic']")
	WebElement autmomatic1 ;
	
	@FindBy(xpath="//li[text()='1.5 TDI CR AMBITION AT (1498 cc)']")
	WebElement TDI ;
	
	@FindBy(xpath="//input[@placeholder='Full name']")
	WebElement fullname ;
	
	@FindBy(xpath="//input[@placeholder='Your email']")
	WebElement email1 ;
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement mobile ;
	
	@FindBy(xpath="//button[text()='View Prices']")
	WebElement viewprice1 ; */
	
	
	public void Car_insurance03() throws InterruptedException, IOException {
		Actions ac = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9000));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();",CI );
		wait.until(ExpectedConditions.visibilityOfAllElements( CI));
		executor.executeScript("arguments[0].click();", CI);
		//CI.click();
		//ac.moveToElement(CI).click().build().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements( BuyingNewCar));
		ac.moveToElement(BuyingNewCar).click().perform();
		//BuyingNewCar.click();
		wait.until(ExpectedConditions.visibilityOfAllElements( CityChn));
		executor.executeScript("arguments[0].click();", CityChn);
		//CityChn.click();
		Thread.sleep(3000);
		//Carmodel.click();
		executor.executeScript("arguments[0].click();",Carmodel );
		wait.until(ExpectedConditions.visibilityOfAllElements(Skoda));
		ac.moveToElement( Skoda).click().perform();
		//Skoda.click();
		Rapidmodel.click();
		Diesel.click();
		 wait.until(ExpectedConditions.visibilityOfAllElements(Automatic));
		 executor.executeScript("arguments[0].click();",Automatic );
		Automatic.click();
		 Thread.sleep(2000);
		 Ambition.click();
		 Entername.sendKeys(baseclass.getProperties().getProperty("Name"));
		 Enteremailwrong.sendKeys(baseclass.getProperties().getProperty("WrongMail"));
		 Entermobile.sendKeys(baseclass.getProperties().getProperty("Mobile"));
		 ErrorMsg();
	     ac.moveToElement( Viewprices).click().build().perform();
		 getScreenShot1();
		// Emailclick.click();
		 Thread.sleep(2000);
		 EmailCorrect.clear();
		 EmailCorrect.sendKeys(baseclass.getProperties().getProperty("CorrectMail"));
		 Thread.sleep(3000);
		 ac.moveToElement( Viewprices).click().build().perform();
		 
	   }
	
	
	/*public void Car_insurancenew() throws InterruptedException, IOException {
		Actions ac = new Actions(driver);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 
		 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9000));
		wait.until(ExpectedConditions.visibilityOfAllElements(newcar));
		ac.moveToElement(newcar).click().perform();
		//BuyingNewCar.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(chennai01));
		chennai01.click();
		ten.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(skoda1));
		skoda1.click();
		rapid1.click();
		diesel1.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(autmomatic1));
		autmomatic1.click();
		TDI.click();
		fullname.sendKeys("raju");
		email1.sendKeys("raju");
		mobile.sendKeys("9347454868");
		 getScreenShot1();
			// Emailclick.click();
			 Thread.sleep(2000);
			 email1.sendKeys("raju@gmail.com");
		Thread.sleep(3000);
		 ac.moveToElement(viewprice1).click().build().perform();
		
	}
	public void  Health_Insurance_Products () throws InterruptedException, IOException{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(MousehovertoInsurance).perform();
		System.out.println(ListHI.getText());
		Health_Prodcuts();
		getScreenShot2();
		
	} */
	List<String> ErrorMessage = new ArrayList<String>();
	List<String> ErrorMsg = new ArrayList<String>();
	public void ErrorMsg() throws IOException, InterruptedException {
		 System.out.println(Erromsg.getText());
		 String value=Erromsg.getText();
		 ErrorMsg.add(value);
			/*
			 * String element[]=Erromsg.getText().split(" "); for(int
			 * i=0;i<element.length;i++) { ErrorMsg.add(element[i]); ExcelUtils excel = new
			 * ExcelUtils(); excel.writeData("ErrorMessage", ErrorMsg , 0, 1);
			 * 
			 * }
			 */
		 ExcelUtils excel = new ExcelUtils();
		 excel.writeData("ErrorMessage", ErrorMsg , 0, 1);
			Thread.sleep(4000);
	     System.out.println("-----------------------------------------------------------");
	     
		
	}
			
			
	
	public void getScreenShot1() throws IOException {
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("../HackathonProject/screenShots_Insurance/ErrorMessege.png");
		FileHandler.copy(FirstScr, destination);
		}
	}




