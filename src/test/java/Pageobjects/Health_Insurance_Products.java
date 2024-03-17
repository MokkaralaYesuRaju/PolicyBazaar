package Pageobjects;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtils;
public class Health_Insurance_Products extends basepage {
	public Health_Insurance_Products(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Policybazaar']")
	WebElement policylogo;
	
	@FindBy(xpath="//a[text()='Insurance Products ']")
	WebElement MousehovertoInsurance;
	
	@FindBy(xpath="(//a[text()='Health Insurance'])[2]")
	WebElement ListHI ;
	
	@FindBy(xpath="//div[@class='ruby-col-3 hidden-md'][2]//span")
	List<WebElement>HealthInsProducts ;
	
	
	public void  Health_Insurance_Products () throws InterruptedException, IOException{
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(MousehovertoInsurance).perform();
		System.out.println(ListHI.getText());
		Health_Prodcuts();
		getScreenShot2();
		
	}
	
	
	 List<String> HealthProducts = new ArrayList<String>();
	   // List<String> Moneycover = new ArrayList<String>();
	public void Health_Prodcuts() {
		Actions action = new Actions(driver);
		try {
			  for(int i=0;i<HealthInsProducts.size();i++) {
				 
		  		  String elementText01 =HealthInsProducts.get(i).getText(); 
		  		  WebElement w = HealthInsProducts.get(i);
		  		  action.moveToElement(w).perform();
		  		   System.out.println(elementText01); 
		  		   Thread.sleep(2000);

				HealthProducts.add(elementText01);
				
		  	  }
			  ExcelUtils excel = new ExcelUtils();
				excel.writeData("Health Products", HealthProducts, 0, 0);
			}catch(Exception e) {
				e.getStackTrace();
			}
		
	}
	  
   // List<String> Company_Name = new ArrayList<String>();
   // List<String> Moneycover = new ArrayList<String>();
	public void getScreenShot2() throws IOException {
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("../HackathonProject/screenShots_Insurance/HealthInsProducts.png");
		FileHandler.copy(FirstScr, destination);
		}
	

}
