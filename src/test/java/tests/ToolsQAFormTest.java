package tests;

import java.io.IOException;

import org.testng.annotations.*;

import pages.BaseClass;
import pages.ReadExFile;
import pages.ToolsQAFormPage;

public class ToolsQAFormTest extends BaseClass {
	
	public ToolsQAFormPage tfp;
	public void initObject() {
		tfp = new ToolsQAFormPage(driver);
	}
	
	@BeforeClass
	public void init() throws InterruptedException {
		launchBrowser();
		initObject();
	}
	
  @Test (dataProvider="testData")
  public void testFormFill(String first, String last, String email, long mobile, String city, String message) throws InterruptedException {
	  tfp.fillform(first, last, email, mobile, city, message);
  }
  
  @DataProvider (name="testData")
  public Object[][] getData(){
	  Object[][] data= {{"Sachin", "Tendulkar", "sachin@gmail.com", 8574961254l, "Mumbai", "Best Batsman"},
			  			{"Mahendra", "Dhoni", "mahendra@gmail.com", 8978747485l, "Satara", "Best Wicket Keeper"},
			  			{"Ravindra", "Jadeja", "ravindra@gmail.com", 7585741256l, "Kolhapur", "Best All Rounder"},
			  			{"Yuvraj", "Singh", "yuvraj@gmail.com", 785218574l, "Yavatmal", "Best Sixes of Six"},
			  			{"Japrit", "Bumrah", "jasprit@gmail.com", 698548574l, "Nagpur", "Best Bowler"}			  			
	  };
	return data;
  }
  
//  @DataProvider (name="testData")
//  public Object[][] getData() throws IOException{
//	  Object[][] data = new Object[5][6];
//	  for(int row=0; row<5; row++) {
//		  for(int col=0; col<6; col++) {
//			  data[row][col]=ReadExFile.readData(row, col);
//		  }
//	  }
//	return data;  
//  	} 

  @AfterClass
  public void closeBrowser() throws InterruptedException {
	  tearDown();
  }
}