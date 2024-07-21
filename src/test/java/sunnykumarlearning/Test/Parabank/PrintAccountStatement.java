package sunnykumarlearning.Test.Parabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAccountStatement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String username="sunnyautotest2";
		
		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("customer.firstName")).sendKeys("FirstNameSk");
		driver.findElement(By.id("customer.lastName")).sendKeys("LaastName");
		driver.findElement(By.id("customer.address.street")).sendKeys("Address");
		driver.findElement(By.id("customer.address.city")).sendKeys("City");
		driver.findElement(By.id("customer.address.state")).sendKeys("State");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("2345345");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("3454643456");
		driver.findElement(By.id("customer.ssn")).sendKeys("34546");
		driver.findElement(By.id("customer.username")).sendKeys(username);
		driver.findElement(By.id("customer.password")).sendKeys("test");
		driver.findElement(By.id("repeatedPassword")).sendKeys("test");
	
		driver.findElement(By.cssSelector("[value='Register']")).click();

		WebElement welcomeMessage = driver.findElement(By.xpath("//h1"));
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='rightPanel']//p"));

		Assert.assertEquals(welcomeMessage.getText(), "Welcome "+username);
		Assert.assertEquals(successMessage.getText(), "Your account was created successfully. You are now logged in.");

		System.out.println("welcomeMessage.getText() :: "+welcomeMessage.getText());
		System.out.println("successMessage.getText() :: "+successMessage.getText());
		
	}
}
