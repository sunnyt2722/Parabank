package sunnykumarlearning.Test.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FundTransfer extends SignUp {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  SignUp.chromeSetup();
		driver.manage().window().maximize();

	WebElement fundtransferButton = driver.findElement(By.xpath("//a[@href='transfer.htm']"));
	fundtransferButton.click();
	WebElement amountSend = driver.findElement(By.xpath("//input[@id='amount']"));
	amountSend.sendKeys("100");
	
	Thread.sleep(3000);
	
	WebElement fromAccountClick = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
	fromAccountClick.click();
	
	Select fromAccounts = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
	fromAccounts.selectByIndex(0);
	
	Select toAccount = new Select(driver.findElement(By.xpath("//select[@id='toAccountId']")));
	toAccount.selectByIndex(0);
	//System.out.println(toAccount.selectByIndex(1););
	
	WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
	Thread.sleep(5000);
	transferButton.click();
	Thread.sleep(3000);
	WebElement transferDone = driver.findElement(By.xpath("//div[@id='showResult']//p[1]"));
	System.out.println("Money Transfer: " + transferDone.getText());
	Thread.sleep(2000);


	}
	
	
}
