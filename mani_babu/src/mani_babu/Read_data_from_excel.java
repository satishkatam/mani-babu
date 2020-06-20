package mani_babu;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_data_from_excel 
{

	public static void main(String[] args) throws Exception
	{
		//browser and page launch
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Drivers_Jars\\Drivers\\chromeDriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		Thread.sleep(3000);
		
		//target file location
		FileInputStream file=new FileInputStream("Testdata\\fb_input_data.xlsx");
		System.out.println("file located");
		
		//get access to excel workbook using above file location
		XSSFWorkbook book=new XSSFWorkbook(file);
		System.out.println("workbook accessed");

		//access to a sheet using above book reference
		//XSSFSheet sheet=book.getSheet("Sheet1");
		XSSFSheet sheet=book.getSheetAt(0);
		
		String data=sheet.getRow(1).getCell(0).getStringCellValue();
		
		//read numeric value from excel
		Double numeric_data=sheet.getRow(1).getCell(2).getNumericCellValue();
		System.out.println("integer data in default format is "+ numeric_data);
		int numericdata=numeric_data.intValue();
		System.out.println("integer data in integer format after conversion is "+ numericdata);


/*		string numeric boolean date
 * 
*/		System.out.println("username is "+ data);
		
		driver.findElement(By.xpath("//*[contains(@type,'email')]")).sendKeys(data);
		
		
		
		
	}

}
