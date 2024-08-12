package sunnykumarlearning.Test.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillPay extends SignUp {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  SignUp.chromeSetup();
		driver.manage().window().maximize();
		
		WebElement openAccount = driver.findElement(By.xpath("//a[normalize-space()='Bill Pay']"));
		openAccount.click();
	WebElement PayeeName = driver.findElement(By.xpath("//input[@name='payee.name']"));
	WebElement Address = driver.findElement(By.xpath("//input[@name='payee.address.street']"));
	WebElement City = driver.findElement(By.xpath("//input[@name='payee.address.city']"));
	WebElement State = driver.findElement(By.xpath("//input[@name='payee.address.state']"));
	WebElement ZipCode = driver.findElement(By.xpath("//input[@name='payee.address.zipCode']"));
	WebElement Phone = driver.findElement(By.xpath("//input[@name='payee.phoneNumber']"));
	WebElement Account = driver.findElement(By.xpath("//input[@name='payee.accountNumber']"));
	WebElement verifyAccount = driver.findElement(By.xpath("//input[@name='verifyAccount']"));
	WebElement Amount = driver.findElement(By.xpath("//input[@name='amount']"));
	
	PayeeName.sendKeys("angad");
	Address.sendKeys("lomdon");
	City.sendKeys("ortanio");
	State.sendKeys("UK");
	ZipCode.sendKeys("35ge3");
	Phone.sendKeys("555656565");
	Account.sendKeys("45565656");
	verifyAccount.sendKeys("45565656");
	Amount.sendKeys("1111");
	
	
	
	WebElement frmAccountclick = driver.findElement(By.xpath("//select[@name='fromAccountId']"));
	frmAccountclick.click();
	
	Select frmAccount = new Select(driver.findElement(By.xpath("//select[@name='fromAccountId']")));
	frmAccount.selectByIndex(0);
	
	WebElement sendPayment = driver.findElement(By.xpath("//input[@value='Send Payment']"));
	sendPayment.click();
	Thread.sleep(3000);
	WebElement paymentDone = driver.findElement(By.xpath("//p[contains(text(),'Bill Payment to')]"));
	System.out.println("Payment Complete: " + paymentDone.getText());

	

}
}
