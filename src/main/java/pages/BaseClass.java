package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.get("https://toolsqa.com/selenium-training?q=banner#enroll-form");
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		Thread.sleep(3000);
	}
	
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
