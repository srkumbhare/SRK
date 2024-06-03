package tests;

import java.io.IOException;

import org.testng.annotations.*;

import pages.BaseClass;
import pages.OrangeLoginPage;
import pages.ReadExFile;

public class OrangeLoginTest extends BaseClass{
	
	public OrangeLoginPage olp;
	public void initObject() {
		olp = new OrangeLoginPage(driver);
	}
	
	@BeforeClass
	public void init() throws InterruptedException {
		launchBrowser();
		initObject();
	}
	
	
  @Test (dataProvider="driveTest")
  public void loginApp(String user, String pass) throws InterruptedException {
		olp.login(user, pass);
	}
  
  @DataProvider (name="driveTest")
  public String[][] getData() throws IOException{
	  String[][] data= new String[5][2];
	  	for(int row=0; row<5; row++) {
	  		for(int col=0; col<2; col++) {
	  			data[row][col] = ReadExFile.readData(row, col);
	  		}
	  	}
	  	return data;
  }
  
//  @DataProvider(name="testData")
//  public String[][] getData(){
//	  String[][] data = {{"Swapnil", "swapnil123"},{"Sachin", "sachin123"},{"Rohit", "rohit123"},
//			  			{"Aman", "aman123"},{"Virat", "virat123"}, {"Admin", "admin123"}};
//	return data;
//	  }
  
  
  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  tearDown();
  }
}

