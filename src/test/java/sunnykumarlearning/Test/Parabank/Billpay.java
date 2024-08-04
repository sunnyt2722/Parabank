package sunnykumarlearning.Test.Parabank;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Billpay {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String username = "bullet" + new Random().nextInt(1000);
		
		
		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		WebElement custFirstName = driver.findElement(By.id("customer.firstName"));
		WebElement custLastName = driver.findElement(By.id("customer.lastName"));
		WebElement addStreet = driver.findElement(By.id("customer.address.street"));
		WebElement city = driver.findElement(By.id("customer.address.city"));
		WebElement state = driver.findElement(By.id("customer.address.state"));
		WebElement zipcode = driver.findElement(By.id("customer.address.zipCode"));
		WebElement phnNumber = driver.findElement(By.id("customer.phoneNumber"));
		WebElement ssn = driver.findElement(By.id("customer.ssn"));
		WebElement usname = driver.findElement(By.id("customer.username"));
		WebElement paswrd = driver.findElement(By.id("customer.password"));
		WebElement cnfrmPassword = driver.findElement(By.id("repeatedPassword"));
		
		custFirstName.sendKeys("suny");
		custLastName.sendKeys("singh");
		addStreet.sendKeys("patna");
		city.sendKeys("ara");
		state.sendKeys("bihar");
		zipcode.sendKeys("6767");
		phnNumber.sendKeys("8989898989");
		ssn.sendKeys("7878");
		usname.sendKeys(username);
		paswrd.sendKeys("1234");
		cnfrmPassword.sendKeys("1234");
	
		driver.findElement(By.cssSelector("[value='Register']")).click();

		WebElement welcomeMessage = driver.findElement(By.xpath("//h1"));
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='rightPanel']//p"));

		WebElement usertext = driver.findElement(By.xpath("//h1[@class='title']"));
		WebElement welcommessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
		System.out.println( usertext.getText() + " : " + welcommessage.getText());
		

		Assert.assertEquals(welcomeMessage.getText(), "Welcome "+username);
		Assert.assertEquals(successMessage.getText(), "Your account was created successfully. You are now logged in.");

		//System.out.println("welcomeMessage.getText() :: "+welcomeMessage.getText());
		//System.out.println("successMessage.getText() :: "+successMessage.getText()); 
		//driver.quit();

	
	/************************Bill Pay****************************/
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
	frmAccount.selectByIndex(1);
	
	WebElement sendPayment = driver.findElement(By.xpath("//input[@value='Send Payment']"));
	sendPayment.click();
	Thread.sleep(3000);
	WebElement paymentDone = driver.findElement(By.xpath("//p[contains(text(),'Bill Payment to')]"));
	System.out.println("Payment Complete: " + paymentDone.getText());

	/**************************///*******************************/

}
}
