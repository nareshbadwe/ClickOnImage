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

public class BrokenLinks3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.setProperty("WebDriver.driver.Chrome", "D:\\Download\\chromedriver_96\\chromedriver.exe");
		
//		https://developer.mozilla.org/en-US/docs/Web/HTTP/Status		
//		Informational responses (100–199)
//		Successful responses (200–299)
//		Redirection messages (300–399)
//		Client error responses (400–499)
//		Server error responses (500–599)
				
		
		//retrieve all anchor tag and store into list as a webelements
		List <WebElement> links =driver.findElements(By.tagName("a"));
		//count the no. of links
		int linkSize=links.size();
		for(int i=1;i<=linkSize;i++) {
			//retrieve link and and store as a webelement
			WebElement element=links.get(i);
			// convert this link into string
			String url=element.getAttribute("href");
			//convert this string into url
			URL link=new URL(url);
			//set connection for this link
			HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
			httpconn.connect();
			int code=httpconn.getResponseCode();
			if (code>=400 )
				System.out.println(link+" - "+"is Broken link"+code);
			else
				System.out.println(link+" - "+"is Valid link"+code);	
		}
		
	}

}
