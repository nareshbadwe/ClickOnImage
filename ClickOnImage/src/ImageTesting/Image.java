package ImageTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("WebDriver.chrome.Driver","D:\\Download\\chromedriver_96\\chromedriver.exe");
		driver.get("https://www.guru99.com/click-on-image-in-selenium.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='brand nohover']")).click();
		Thread.sleep(2000);
		driver.close();

	}

}
