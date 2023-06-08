package booking;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.FileWriter;
import java.io.IOException;


public class TicketBooking {
	WebDriver driver;
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
	
	public void checkLogFile() {
		try {
		File log = new File("log\\eclipseConsoleLogs.log");
		if(!log.exists()) {
			log.createNewFile();
		}
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void bookTicket() throws InterruptedException, Exception {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/railways/");
		
		FileWriter log = new FileWriter("log\\eclipseConsoleLogs.log");
		
		
		// URL of the Page
		String url = driver.getCurrentUrl();
		System.out.println("URL of the Page: " + url);
		log.write("URL of the Page: " + url + "\n");
		//Title of the Page
		String title = driver.getTitle();
		System.out.println("Title of the Page: " + title);
		log.write("Title of the Page: " + title + "\n");
		
		TicketBooking.takeSnapShot(driver, "screenshots\\siteAccess.png") ;  
		
		//Setting From to DELHI
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Setting From To DELHI");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
		Thread.sleep(1000);
		log.write("Click on From\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\clickOnFrom.png") ; 
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input")).sendKeys("DELHI");
		Thread.sleep(1000);
		
		int length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();

		for (int i = 0; i < length; i++) {
			String element = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span")).get(i).getText();
			if (element.equals("Delhi")) {
				driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span")).get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
		log.write("Setting From To DELHI\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\enterDelhi.png") ;
		Thread.sleep(500);
		//Setting To to LUCKNOW
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Setting To to LUCKNOW");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/label/span")).click();
		Thread.sleep(1000);
		log.write("Click on To\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\clickOnTo.png") ;
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input")).sendKeys("LUCKNOW");
		Thread.sleep(1000);
		
		length = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li")).size();
		
		for (int i = 0; i < length; i++) {
			String element = driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span")).get(i).getText();
			if (element.equals("Lucknow")) {
				driver.findElements(By.cssSelector("ul.react-autosuggest__suggestions-list > li > div > div > p.searchedResult.font14.darkText > span")).get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
		log.write("Setting To To LUCKNOW\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\enterLucknow.png") ;
		
		//Setting Date to 20 May
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Setting Date to 20 May");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]")).click();
		Thread.sleep(1000);
		log.write("Click on Travel Date\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\clickOnTravelDate.png") ;
		
		String month_year = "May 2023";
		WebElement next= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
		Thread.sleep(1000);
		
		for (int i=0; i<12 ;i++) {
			WebElement present = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div"));
			if(present.getText().equals(month_year)) {
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]")).click();
				Thread.sleep(1000);
				break;
			}
			else {
				next.click();
				Thread.sleep(500);
			}
		}
		log.write("Set Date to 20 May\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\enterDate.png") ;
		
		//Setting Class to Third AC
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Setting Class to Third AC");		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[4]/label/span")).click();
		Thread.sleep(1000);
		log.write("Click on Class\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\clickOnClass.png") ;
		
		length = driver.findElements(By.cssSelector("ul.travelForPopup > li")).size();
				
		for(int i=0; i<length; i++) {
			WebElement present = driver.findElements(By.cssSelector("ul.travelForPopup > li")).get(i);
			if(present.getText().equals("Third AC")) {
				present.click();
				Thread.sleep(1000);
				break;
			}
		}
		log.write("Set Class to Third AC\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\selectThirdAC.png");
		
		//Searching Available Trains
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Searching Available Trains");
		driver.findElement(By.cssSelector("a.primaryBtn.font24.latoBold.widgetSearchBtn")).click();
		Thread.sleep(5000);
		log.write("Click on Search\n");
		TicketBooking.takeSnapShot(driver, "screenshots\\clickOnSearchButton.png") ;
		driver.close();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Close Web Browser");
		log.write("Close Web Browser\n");	
		log.close();
	}
	
	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		TicketBooking obj = new TicketBooking();
		obj.bookTicket();
	}
}