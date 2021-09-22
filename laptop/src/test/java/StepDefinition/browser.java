package StepDefinition;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
class TestClass1 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "chrome");
		capsHashtable.put("browser_version", "93.0");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
    	capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 1");
		browser r1 = new browser();
		r1.executeTest(capsHashtable);
    }
}
class TestClass2 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "firefox");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "Windows");
		capsHashtable.put("os_version", "10");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 2");
		browser r2 = new browser();
    	r2.executeTest(capsHashtable);
  	}
}
class TestClass3 implements Runnable {
	public void run() {
		Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
		capsHashtable.put("browser", "safari");
		capsHashtable.put("browser_version", "latest");
		capsHashtable.put("os", "OS X");
		capsHashtable.put("os_version", "Big Sur");
		capsHashtable.put("build", "browserstack-build-1");
		capsHashtable.put("name", "Thread 3");
		browser r3 = new browser();
    	r3.executeTest(capsHashtable);
  	}
}

public class browser {
	public static final String USERNAME = "ayshaareej_kdYueI";
	public static final String AUTOMATE_KEY = "sU3Txe7k6yEyGppkF4yS";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
WebDriver driver;

	
	

	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
				//create chrome instance
				driver = new ChromeDriver();
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exe
						System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
						//create Edge instance
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		public void executeTest(Hashtable<String, String> capsHashtable) {
		// TODO Auto-generated method stub
		
	}

		@Test
		public void testParameterWithXML(Capabilities caps) throws InterruptedException{
			try {
				
				driver = new RemoteWebDriver(new URL(URL), caps);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				// Searching for 'BrowserStack' on google.com
				driver.get("https://www.google.com");
				WebElement element = driver.findElement(By.name("q"));
				element.sendKeys("BrowserStack");
				element.submit();
				// Setting the status of test as 'passed' or 'failed' based on the condition; if title of the web page contains 'BrowserStack'
				WebDriverWait wait = new WebDriverWait(driver, 5);
		    	try {
					wait.until(ExpectedConditions.titleContains("BrowserStack"));
					jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
		    	}
		    	catch(Exception e) {
		    		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
		    	}
		    	System.out.println(driver.getTitle());
		    	driver.quit();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		}
