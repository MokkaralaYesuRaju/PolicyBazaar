package Pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.baseclass;

public class Travel_insurance01 {
	WebDriver driver;
	
	public  Travel_insurance01(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//label[contains (text(),'Enter your destination')]")
	WebElement destination;
	
	@FindBy(xpath="//*[@id=\"search-country\"]/ul/li[3]")
	WebElement country;
	
	@FindBy(xpath="//button[@class='travel_main_cta']")
	WebElement submitcountry;
	
	@FindBy(xpath="//input[@placeholder='dd mmmm, yyyy'][1]")
	WebElement startdate01;
	

	@FindBy(xpath="(//button[@data-mui-test='next-arrow-button'])[2]")
	WebElement nextarrow;
	

	@FindBy(xpath="//button[@data-mui-test='DateRangeDay']")
	List<WebElement> marchdate;
	

	@FindBy(xpath="(//button[@data-mui-test='next-arrow-button'])[2]")
	WebElement nextarrow01;
	

	@FindBy(xpath="//button[@aria-label='Apr 18, 2024']")
	WebElement aprildate;
	

	@FindBy(xpath="//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button")
	WebElement proceed;
	
	@FindBy(xpath="//label[@for='traveller_2']")
	WebElement travellers2;
	
	@FindBy(xpath="//div[text()='Select age of traveller 1']")
	WebElement selectageofTV1;
	
	@FindBy(xpath="//*[@id=\"optionBox_0_wrapper\"]/div[24]/label")
	WebElement age22;
	
	@FindBy(xpath="//div[text()='Select age of traveller 2']")
	WebElement selectageofTV2;
	
	@FindBy(xpath="//*[@id=\"optionBox_1_wrapper\"]/div[23]/label")
	WebElement age21;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextbt;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement medical_no ;
	

	@FindBy(xpath="//div//input[@id='mobileNumber']")
	WebElement mobileclick ;
	
	@FindBy(xpath="//div//input[@id='mobileNumber']")
	WebElement mobileEnter ;
	
	@FindBy(xpath="//span[@class='slider round']")
	WebElement whatsappoff ;
	
	@FindBy(xpath="//button[text()='View plans']")
	WebElement viewplans ;
	
	
	
	public void Destination_travel() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOfAllElements(destination));
		destination.click();
		Actions ac = new Actions(driver);
		ac.moveToElement(country).click().perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(submitcountry));
		submitcountry.click();
		//wait.until(ExpectedConditions.visibilityOfAllElements(startdate01));
		Thread.sleep(2000);
		startdate01.click();
	//	wait.until(ExpectedConditions.visibilityOfAllElements(nextarrow));
	//	nextarrow.click();
	//	wait.until(ExpectedConditions.visibilityOfAllElements(marchdate));
		click_march_date();
	//	wait.until(ExpectedConditions.visibilityOfAllElements(nextarrow01));
		//nextarrow01.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(aprildate));
		aprildate.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(proceed));
		proceed.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(travellers2));
		travellers2.click();
		Thread.sleep(1000);
		selectageofTV1.click();
		Thread.sleep(1000);
		age22.click();
		Thread.sleep(1000);
		selectageofTV2.click();
		age21.click();
		Thread.sleep(1000);
		nextbt.click();
		medical_no.click();
		Thread.sleep(2000);
		mobileclick.click();
		Thread.sleep(2000);
		mobileEnter.sendKeys(baseclass.getProperties().getProperty("Mobile"));
		Thread.sleep(2000);
		whatsappoff.click();
		viewplans.click();
	}
	
	public void click_march_date() throws InterruptedException{
		for (WebElement ele : marchdate) {
			if (ele.getText().equals("20")) {
				Thread.sleep(2000);
				Actions ac = new Actions(driver);
				ac.moveToElement(ele).click().perform();
			//	ele.click();
				break;
			}
		}
	}
	
}
