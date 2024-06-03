package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable {
	
	public WebDriver driver;
	
	@FindBy (xpath="//table[@id='countries']//tbody//tr//td[2]")
	private List<WebElement> Countries;
	
	public WebTable(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void countryData() throws IOException {
		System.out.println("Size of Countries : " + Countries.size());
		int row=0;
		int col=0;
		for(WebElement ele : Countries ) {
			String value=ele.getText();			
			WriteExcelFile.writeData(row, col, value);
			row++;
			System.out.println(value);
		}
	}

}
