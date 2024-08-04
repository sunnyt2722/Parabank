package sunnykumarlearning.Test.Parabank;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fundtransfer {
	
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
		
		/*******************************Open new account*****************/
		WebElement openAccount = driver.findElement(By.xpath("//a[@href='openaccount.htm']"));
		openAccount.click();
		Select accountType = new Select(driver.findElement(By.xpath("//select[@id='type']")));
		accountType.selectByVisibleText("SAVINGS");
		Thread.sleep(5000);
		Select fromAccountIds = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
		//fromAccountIds.selectByIndex(0);
		fromAccountIds.getFirstSelectedOption().getText();
		
		//System.out.println("TTTTT" + fromAccountIds.getFirstSelectedOption().getText());
		
		WebElement openAccountButton = driver.findElement(By.xpath("//input[@value='Open New Account']"));
		openAccountButton.click();
		Thread.sleep(3000);
		WebElement accountResult = driver.findElement(By.id("newAccountId"));
		System.out.println("Your new account number: " + accountResult.getText());
		Thread.sleep(2000);
	
	/**************************Fund Trnasfer ******************/
	WebElement fundtransferButton = driver.findElement(By.xpath("//a[@href='transfer.htm']"));
	fundtransferButton.click();
	WebElement amountSend = driver.findElement(By.xpath("//input[@id='amount']"));
	amountSend.sendKeys("100");
	
	Thread.sleep(3000);
	
	WebElement fromAccountClick = driver.findElement(By.xpath("//select[@id='fromAccountId']"));
	fromAccountClick.click();
	
	Select fromAccounts = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
	fromAccounts.selectByIndex(1);
	
	Select toAccount = new Select(driver.findElement(By.xpath("//select[@id='toAccountId']")));
	toAccount.selectByIndex(1);
	//System.out.println(toAccount.selectByIndex(1););
	
	WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
	Thread.sleep(5000);
	transferButton.click();
	Thread.sleep(3000);
	WebElement transferDone = driver.findElement(By.xpath("//div[@id='showResult']//p[1]"));
	System.out.println("Money Transfer: " + transferDone.getText());
	Thread.sleep(2000);

	/****************************///Fund ***************************/

	}
}
