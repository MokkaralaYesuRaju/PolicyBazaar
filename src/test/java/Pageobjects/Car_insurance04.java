package Pageobjects;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testbase.baseclass;
import utilities.ExcelUtils;
public class Car_insurance04 extends basepage{
	//baseclass b;
	public Car_insurance04(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[@class='text fontMedium']")
	List<WebElement>next30days;
	@FindBy(xpath="//h2[text()='Refresh the page']")
	WebElement RefreshPage;
	@FindBy(xpath="//div[@class='crossBtn']")
	WebElement crossbtn;
	@FindBy(xpath="//input[@placeholder='Enter ex-showroom price']")
	WebElement clickexshowroom;
	@FindBy(xpath="//input[@placeholder='Enter ex-showroom price']")
	WebElement Ex_showPrice;
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	@FindBy(xpath="//img[@alt='Kotak General']")
	WebElement 	Kotak;
	@FindBy(xpath="//p[text()='View Coverage'][1]")
	WebElement ViewCoverage;
	
	@FindBy(xpath="//li[@class='tabItem '][1]")
	WebElement premium ;
	
	@FindBy(xpath="//div[@class='popupBox padding0 policyDetailPopup slideToLeft']")
	WebElement quote ;
	
	@FindBy(xpath="//div[@class='crossBtn']")
	WebElement crossBtn1 ;
	
	@FindBy(xpath="//img[@alt='policybazaar']")
	WebElement home ;
	
	
	
	
	public void Car_insurance04() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(9000));
		next30days();
		//refreshpage();
		driver.navigate().refresh();
		clickexshowroom.click();
		Ex_showPrice.sendKeys(baseclass.getProperties().getProperty("Ex-showPrice"));
		Submit.click();
		Thread.sleep(3000);
		Kotak();
		wait.until(ExpectedConditions.visibilityOfAllElements(premium));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", premium);
	//	premium.click();
		Thread.sleep(3000);
		CarQuote();
		getScreenShot();
		//System.out.println(quote.getText());
		crossBtn1.click();
		home.click();
		
	}
	@Test(priority=1)
	public void next30days() {
		for (WebElement nx :next30days) {
			if (nx.getText().equals("Within next 30 days")) {
				Actions ac = new Actions(driver);
				ac.moveToElement(nx).click().perform();
				break;
			}
	    }
	}
	@Test(priority=2,dependsOnMethods="next30days()")
		public void refreshpage() throws InterruptedException {
			try {
			 if(RefreshPage.isDisplayed()) {
				 crossbtn.click();
			    	Thread.sleep(2000);
			    }
			} catch(org.openqa.selenium.NoSuchElementException e){
					e.getStackTrace();
			}
	
	}
	@Test(priority=3)
		public void Kotak() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7000));
			 try {
				 wait.until(ExpectedConditions.visibilityOfAllElements(Kotak));
				    if(	Kotak.isDisplayed()) {
				    	wait.until(ExpectedConditions.visibilityOfAllElements( ViewCoverage));
				    	Actions act=new Actions(driver);
				    	Thread.sleep(2000);
				    	act.moveToElement(ViewCoverage).click().perform();
				    	//executor.executeScript("arguments[0].click();",  ViewCoverage);
				  //  ViewCovergae.click();
				    }
			 }catch(Exception e2) {
			    	e2.getStackTrace();
			    }
		}
	
	 List<String> car_quote = new ArrayList<String>();
	 @Test(priority=4)
		public void CarQuote() throws IOException, InterruptedException {
			System.out.println(quote.getText());
			String element[]=quote.getText().split(" ");
			for(int y=0;y<element.length;y++)
			{
				 car_quote.add(element[y]);				
			}
			 
			 ExcelUtils excel = new ExcelUtils();
			excel.writeData("Car_Quote", car_quote, 0, 0);
			Thread.sleep(4000);
		}
		
		public void getScreenShot() throws IOException {
			File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("../HackathonProject/screenShots_Insurance/CarQuote.png");
			FileHandler.copy(FirstScr, destination);
			}
	
}
