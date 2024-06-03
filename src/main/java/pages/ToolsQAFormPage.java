package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQAFormPage {
	
	public WebDriver driver;
	
	@FindBy (xpath="//input[@name='firstName']")
	private WebElement firstName;
	
	@FindBy (xpath="//input[@name='lastName']")
	private WebElement lastName;
	
	@FindBy (xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy (xpath="//input[@name='mobile']")
	private WebElement mobile;
	
	@FindBy (xpath="//select[@name='country']")
	private WebElement country;
	
	@FindBy (xpath="//input[@name='city']")
	private WebElement city;
	
	@FindBy (xpath="//textarea[@name='message']")
	private WebElement message;
	
	public ToolsQAFormPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillform(String f, String l, String e, long mob, String c, String mes ) throws InterruptedException {
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView()", firstName); Thread.sleep(2000);
		
		try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(driver -> firstName.isDisplayed());
            
		firstName.sendKeys(f);	Thread.sleep(2000);
		lastName.sendKeys(l);	Thread.sleep(2000);
		email.sendKeys(e);		Thread.sleep(2000);
		mobile.sendKeys(String.valueOf(mob));	Thread.sleep(2000);
		Select sel1 = new Select(country);	
		sel1.selectByVisibleText("India");	Thread.sleep(2000);
		city.sendKeys(c);		Thread.sleep(2000);
		message.sendKeys(mes);	Thread.sleep(2000);			
		driver.navigate().refresh(); Thread.sleep(2000);	
		} catch (TimeoutException ex) {
            System.out.println("Element not found within the specified timeout.");
            // Handle or log the exception as per your need
            ex.getStackTrace();
        }
	}
}
