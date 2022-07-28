package BrokenLinksTesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.setProperty("WebDriver.driver.Chrome","D:\\Download\\chromedriver_96\\chromedriver.exe");
		driver.get("https://demo.guru99.com/test/newtours/");
		
		//capture link from web page
		List <WebElement> links=  driver.findElements(By.tagName("a"));
		//find out the no. of links (size)
		int linkSize=links.size();
		System.out.print(linkSize);
		for( int i=1;i<=linkSize;i++) {
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
			//now need to established the connection
			URL link= new URL(url);
			//create connection using link object
			HttpURLConnection httpConn=(HttpURLConnection) link.openConnection();
			//Wait for 2 second
			Thread.sleep(2000);
			//Established the connection
			httpConn.connect();
			int respCode=httpConn.getResponseCode();
			if (respCode>=400) 
				System.out.println(link+"  -  "+"is broken link");
			else
				System.out.println(link+"  -  "+ "is valid link");
			
		}
		
		Thread.sleep(5000);
		driver.close();

	}

}
