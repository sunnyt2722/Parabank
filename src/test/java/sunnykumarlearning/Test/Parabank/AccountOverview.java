package sunnykumarlearning.Test.Parabank;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountOverview {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  SignUp.chromeSetup();
		driver.manage().window().maximize();

	WebElement accountOverview = driver.findElement(By.xpath("//a[normalize-space()='Accounts Overview']"));
	accountOverview.click();
	Thread.sleep(2000);
	
	List<WebElement> accountOverview1 = driver.findElements(By.xpath("//table[@id='accountTable']//tbody/tr[2]/td"));
	for(int i=0;i<accountOverview1.size();i++)
	{
		System.out.println("Value of i(Account overview) is "+i+" : "+accountOverview1.get(i).getText());
	}

}
}
