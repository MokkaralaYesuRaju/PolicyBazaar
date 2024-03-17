package Pageobjects;

import testbase.baseclass;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class Health_Inusrance05 extends basepage {
	public Health_Inusrance05(WebDriver driver)
	{
		super (driver);
	}
	@FindBy(xpath="(//i[@class='icon-bg homeIconsBg health-insurance'])[2]")
	WebElement HealthInsurancelogo;
	
	@FindBy(xpath="//button[text()=' Continue › ']")
	WebElement Continue;
	
	@FindBy(xpath="//select[@id='Self']")
	WebElement age;
	
	@FindBy(xpath="//*[@id=\"Self\"]/option[6]")
	WebElement age22;
	
	@FindBy(xpath="//*[@id=\"step2ContinueBtn\"]")
	WebElement continue1;
	
	@FindBy(xpath="//*[@id=\"city\"]")
	WebElement chennai;
	
	@FindBy(xpath="//*[@id=\"foundCityContainer\"]/ul/li/span")
	WebElement Chn;
	
	@FindBy(xpath="//*[@id=\"step3ContinueBtn\"]")
	WebElement Continue2;
	
	@FindBy(xpath="//input[@id='fullName']")
	WebElement FullName;
	
	@FindBy(xpath="//label[text()='Enter mobile number']")
	WebElement Mobileclick;
	
	@FindBy(xpath="//*[@id=\"mobile\"]")
	WebElement Mobie;
	
	@FindBy(xpath="//*[@id=\"step4ContinueBtn\"]")
	WebElement Continue4;
	
	@FindBy(xpath="//label[text()='None of these']")
	WebElement None;
	
	@FindBy(xpath="//input[@value='yes']")
	WebElement yes;
	
	@FindBy(xpath="//input[@value='Less than Rs 3 lakh']")
	WebElement RadioBtn;
	
	@FindBy(xpath="//*[@id=\"viewPlansBtn\"]/span")
	WebElement viewplans;
	
	@FindBy(xpath="//span[@class='quotes_rvmp_card__content__plan_header__name']")
	List<WebElement> CompanyNames;
	
	@FindBy(xpath="//select[@class='quotes_select']")
	List<WebElement> MoneyCover;
	
	@FindBy(xpath="	//a[text()='PolicyBazaar Health insurance takes care of your medical expenses']")
	WebElement Homelogo;
	
	
	
    public  void Health_Inusrance05() throws InterruptedException, IOException {
    	HealthInsurancelogo.click();
       	Actions action = new Actions(driver);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
    	wait.until(ExpectedConditions.visibilityOfAllElements(Continue));
    	js.executeScript("arguments[0].scrollIntoView();", Continue);
    	Thread.sleep(1000);
    	js.executeScript("arguments[0].click();", Continue);
    	
    	//action.moveToElement(Continue).click().perform();
    
 
    	action.moveToElement(age).click().perform();
    	
    	age22.click();
    	
    	continue1.click();
    	
    	chennai.sendKeys(baseclass.getProperties().getProperty("place"));
    	Chn.click();
    	Continue2.click();
    	Thread.sleep(2000);
    	 //action.moveToElement(FullName).click().perform();
    	FullName.click();;
    	FullName.sendKeys(baseclass.getProperties().getProperty("Name"));
    	Mobileclick.click();
    	Mobie.sendKeys(baseclass.getProperties().getProperty("Mobile"));
    	//action.moveToElement(Continue4).click().perform();
        Continue4.click();
    	 Thread.sleep(2000);
    	 action.moveToElement(None).click().perform();
    	// None.click();
    	 Thread.sleep(3000);
    	 action.moveToElement(yes).click().perform();
    //	 yes.click();   
    	 RadioBtn.click();
    	 viewplans.click();
    	 Thread.sleep(3000);
    	 Company_NamesList();
    	 Homelogo.click();
    	
    }
    
    List<String> Company_Name = new ArrayList<String>();
    List<String> Moneycover = new ArrayList<String>();
	public void Company_NamesList() throws InterruptedException, IOException {
		 try {
      	  Thread.sleep(5000);
      	  //System.out.println(CompanyNames.size());
      	  for(int i=0;i<5;i++) {
      		  String elementText = CompanyNames.get(i).getText() + "---------" + MoneyCover.get(i).getText();
      		   System.out.println(elementText); 
      		   Thread.sleep(3000);
      		   Company_Name.add(CompanyNames.get(i).getText());
      		 Moneycover.add(MoneyCover.get(i).getText());
      	  }
//      	  break;
      	ExcelUtils excel = new ExcelUtils();
		excel.writeData("Company Details", Company_Name, 0, 0);
		excel.writeData("Company Details", Moneycover, 0, 1);
      }
      catch(StaleElementReferenceException e1) {
      }
	}
	
}
