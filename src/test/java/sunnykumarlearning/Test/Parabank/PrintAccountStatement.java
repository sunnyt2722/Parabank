package sunnykumarlearning.Test.Parabank;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAccountStatement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("sunnyautotest2");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("test");
		driver.findElement(By.cssSelector("[value='Log In']")).click();
		
		Thread.sleep(5000);
		
		List<WebElement> accountDetails = driver.findElements(By.xpath("//table[@id='accountTable']//tbody/tr[1]/td"));
		WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
		
		for(int i=0;i<accountDetails.size();i++)
			System.out.println("Value of i is "+i+" : "+accountDetails.get(i).getText());
		
		logoutButton.click();
		
		driver.quit();
	}
}
