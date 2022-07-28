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

public class BrokenLink2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.driver.Chrome","D:\\Download\\chromedriver_96\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		List <WebElement> links= driver.findElements(By.tagName("a"));
		int linkSize=links.size();
		System.out.println(linkSize);
		
		for (int i=1;i<=linkSize;i++) {
			WebElement element=links.get(i);
			String url=element.getAttribute("href");
			URL link=new URL(url);
			HttpURLConnection httpconn=(HttpURLConnection) link.openConnection();
			httpconn.connect();
			int respcode=httpconn.getResponseCode();
			if(respcode>=400)
				System.out.println(link+" -- "+"is broken link");
			else
				System.out.println(link+" -- "+ "is valid link");
		}
		driver.close();
		
	}

}
