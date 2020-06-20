package mani_babu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mani1 
{


	

 
	
		/*
		 * test case:
		 * go to markets tab in homepage
		 * check if nifty tab is in active state
		 * check index points of nifty and print that it is in profit
		 * if greater than 9000 else print it is in loss
		 */
		public static void main(String[] args) throws InterruptedException 
		{
			//variables
			String nifty_attribute;
			String niftyPoints;
			
			//locations
			By markets_loc=By.xpath("//*[@id=\"liMarket\"]/a");
			By nifty_tab_loc=By.xpath("//*[@id=\"TradeRec\"]");

			By nifty_points_loc=By.xpath("(//span[@class='flo_right'])[2]");

			
			//browser and page launch
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers_Jars\\Drivers\\chromedriver1.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.icicidirect.com/idirectcontent/Home/Home.aspx");
			
			//clicking on markets option
			driver.findElement(markets_loc).click();
			
			//verifying nifty tab status whether selected or not
			WebElement niftyTab=driver.findElement(nifty_tab_loc);
			nifty_attribute=niftyTab.getAttribute("class");
			if(nifty_attribute.contains("tab-active"))
			{
				System.out.println("nifty tab is active ");			
			}
			else
			{
				System.out.println("nifty tab is inactive");
			}
			Thread.sleep(3000);		
			//identifying nifty points and verifying if above 9000 or not
			WebElement nifty_pts=driver.findElement(nifty_points_loc);
			niftyPoints=nifty_pts.getText();
			@SuppressWarnings("deprecation")
			Double nif_pts=new Double(niftyPoints);
			System.out.println("nifty index points: "+nif_pts);
			if(nif_pts>9000)
			{
				System.out.println("nifty is in profit");
				
			}
			else
			{
				System.out.println("nifty is in loss");

			}
			
			
			
		}

	}



