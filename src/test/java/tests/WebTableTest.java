package tests;
//This is WebTable Test Class
import java.io.IOException;

import org.testng.annotations.*;

import pages.BaseClass;
import pages.WebTable;

public class WebTableTest  extends BaseClass{
	
	public WebTable wt;
	public void initObject() {
		wt = new WebTable(driver);		
	}
	
	@BeforeClass
	public void init() throws InterruptedException {
		launchBrowser();
		initObject();
	}
	
  @Test
  public void ImportWebTable() throws IOException {
	  wt.countryData();
  }
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  tearDown();
  }
}
