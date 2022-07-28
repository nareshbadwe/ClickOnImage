package HeadLessTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessSampleProject {

	public static void main(String[] args) {
		FirefoxOptions Foption= new FirefoxOptions();
		ChromeOptions Coption = new ChromeOptions();
		EdgeOptions Eoption = new EdgeOptions();
		
//		to make headless true
//		Foption.setHeadless(true);
//		Coption.setHeadless(true);
//		Eoption.setHeadless(true);
		
//another option to make headless true
		
		Foption.addArguments("--headless");
		Coption.addArguments("--headless");
		Eoption.addArguments("--headless");
		
		WebDriver Fdriver=new FirefoxDriver(Foption);
		WebDriver Cdriver=new ChromeDriver(Coption);
		WebDriver Edriver = new EdgeDriver(Eoption);
		
		System.setProperty("WebDriver.firefox.Driver","D:\\Download\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		System.setProperty("WebDriver.chrome.Driver","D:\\Download\\chromedriver_96\\chromedriver.exe");
		System.setProperty("WebDriver.edge.Driver","D:\\Download\\edgedriver_win64\\msedgedriver.exe");
		
		Fdriver.navigate().to("https://www.google.com/");
		Cdriver.get("https://www.google.com/");
		Edriver.navigate().to("https://www.google.com/");
		
		System.out.println("The Title of the page on Firefox Browser"+ Fdriver.getTitle());
		System.out.println("The title of the page on Chrome Browser"+ Cdriver.getTitle());
		System.out.println("The Title of the page on Edge Browser" + Edriver.getTitle());
	
	}

}
