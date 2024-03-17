package Pageobjects;
import java.io.IOException;
import java.time.Duration;
import utilities.ExcelUtils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Travel_insurance02 extends basepage{
	ExcelUtils excel;
	
	public Travel_insurance02 (WebDriver driver)
	{
		super(driver);
	}
	

//	WebDriver driver;
	
		//PageFactory.initElements(driver,this);
	@FindBy(xpath="//p[text()='Leaving already?']")
	WebElement popup;
	
	@FindBy(xpath="	//span[@class='exitIntentPopup__box__closePop']")
	WebElement close_alert;

	
	@FindBy(xpath="//label[text()='Student plans']")
		WebElement scrolltostudentplans ;
		
	@FindBy(xpath="//label[text()='Student plans']")
		WebElement clickstudentplans ;
	
	@FindBy(xpath="//label[@for='Traveller_1']")
	WebElement clickTraveller1 ;
	
	@FindBy(xpath="//label[@for='Traveller_2']")
	WebElement clickTraveller2 ;
	
	@FindBy(xpath="//select[@id='feet']")
	WebElement EnterTravelDuration ;
	
	@FindBy(xpath="//option[@value='1']")
	WebElement days30click ;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement ClickApply ;
	
	@FindBy(xpath="//p[text()='Sort by']")
	WebElement SortBy;
	
	@FindBy(xpath="//label[text()='Premium low to high']")
	WebElement premiumlowtohigh ;
	
	@FindBy(xpath="//p[@class='quotesCard--insurerName']")
	List<WebElement>InsuranceCompany;
	
	@FindBy(xpath="//span[@class='premiumPlanPrice']")
	List<WebElement> Totalpremium ;
	
	@FindBy(xpath="//a[text()='Policybazaar']")
	WebElement policylogo;
		
	public void TravelInsurance02() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7000));
		Actions ac = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Popup();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(scrolltostudentplans));
		js.executeScript("arguments[0].scrollIntoView();",scrolltostudentplans );
		js.executeScript("arguments[0].click();",clickstudentplans );
		wait.until(ExpectedConditions.visibilityOfAllElements(clickTraveller1));
		js.executeScript("arguments[0].click();", clickTraveller1 );
		// clickTraveller1.click();
		 
		 wait.until(ExpectedConditions.visibilityOfAllElements(clickTraveller2));
		 clickTraveller2.click();
		 
		 Thread.sleep(2000);
		 EnterTravelDuration.click();
		 days30click.click();
		 ClickApply.click();
		 Thread.sleep(3000);
		 SortBy.click();
		 Thread.sleep(2000);
		 premiumlowtohigh.click();
		 Thread.sleep(2000);
		 Insurance_Companies();
		 policylogo.click();
		 
		}
	public void Popup() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4000));
		Actions act=new Actions(driver);
		 try {
			 wait.until(ExpectedConditions.visibilityOfAllElements( popup));
			    if(	 popup.isDisplayed()) {
			    	//wait.until(ExpectedConditions.visibilityOfAllElements(close_alert));
			    	//Thread.sleep(2000);
			    	act.moveToElement(close_alert).click().perform();
			    		
			    }
			    	
		 }catch(Exception e2) {
		    	e2.getStackTrace();
		 }
		 
	}
	 List<String> Insurance_Company01 = new ArrayList<String>();
	 List<String> Total_Premium = new ArrayList<String>();
	public void Insurance_Companies() throws IOException, InterruptedException {
	for (int i = 0; i < 3; i++) {
		Thread.sleep(3000);
		System.out.println(InsuranceCompany.get(i).getText() + "-----" +  Totalpremium.get(i).getText());
	
		Insurance_Company01.add(InsuranceCompany.get(i).getText());
		 Total_Premium.add( Totalpremium.get(i).getText() );
	
	    }
	
	 ExcelUtils excel = new ExcelUtils();
		excel.writeData("Insurance_Company",Insurance_Company01 , 0, 0);
		excel.writeData("Insurance_Company", Total_Premium, 0, 1);
	
	}
	
}
