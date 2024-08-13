package sunnykumarlearning.Test.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount extends SignUp {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =  SignUp.chromeSetup();
		
		driver.manage().window().maximize();
		WebElement openAccount = driver.findElement(By.xpath("//a[normalize-space()='Open New Account']"));
		openAccount.click();
		Select accountType = new Select(driver.findElement(By.xpath("//select[@id='type']")));
		accountType.selectByVisibleText("SAVINGS");
		Thread.sleep(5000);
		Select fromAccountIds = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
		// fromAccountIds.selectByIndex(0);
		fromAccountIds.getFirstSelectedOption().getText();

		WebElement openAccountButton = driver.findElement(By.xpath("//input[@value='Open New Account']"));
		openAccountButton.click();
		Thread.sleep(3000);
		WebElement accountResult = driver.findElement(By.id("newAccountId"));
		System.out.println("Your new account number: " + accountResult.getText());
		Thread.sleep(2000);
		driver.quit();

	}
}
