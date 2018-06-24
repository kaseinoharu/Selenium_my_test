package kaseinoharu.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Reservation {

	WebDriver driver;
	
	public static void main(String[] args) {
		
		Reservation myObj = new Reservation();
		myObj.invokeBrowser();

	}
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\tools\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
//			driver.get("http://l-tike.com/");
			driver.get("http://l-tike.com/order/?gLcode=22803&gPfKey=20180606000000328258&gEntryMthd=03&gScheduleNo=1&gCarrierCd=08&gPfName=ＧＯＯＤ　ＫＵＲＵ．＃２&gBaseVenueCd=25777");
			seatCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void seatCount() {
		try {
			Thread.sleep(1000);
			/* 席種を選択 */
			driver.findElement(By.className("btnSelectTicket")).click();
			Thread.sleep(1000);
			/* 枚数を選択 */
			Select ticketNumberSelect = new Select(driver.findElement(By.name("numberSelect")));
			ticketNumberSelect.selectByIndex(1);
			/* お申し込みボタンを押下 */
			driver.findElement(By.xpath("//*[@id=\"cartContainer\"]/div/div[3]/p/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

