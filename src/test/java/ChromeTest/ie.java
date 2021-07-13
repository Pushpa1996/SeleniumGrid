package ChromeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ie {

    public WebDriver driver;
   public String URL, Node;
   
   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
   
   @Parameters("browser")


@BeforeTest


   public void launchapp(String browser) throws MalformedURLException {
      String URL = "http://www.calculator.net";
      
      if (browser.equalsIgnoreCase("firefox")) {
         System.out.println(" Executing on FireFox");
         String Node = "  http://192.168.0.81:5551/wd/hub";
         
         ChromeOptions options = new ChromeOptions();
         
         DesiredCapabilities capabilities = new DesiredCapabilities();
     	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
     	
     	options.merge(capabilities);
       
        driver=new RemoteWebDriver(new URL(Node), capabilities);
         // Puts an Implicit wait, Will wait for 10 seconds before throwing exception
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         // Launch website
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      } else if (browser.equalsIgnoreCase("chrome")) {
         
    	  System.out.println(" Executing on CHROME");
         ChromeOptions options = new ChromeOptions();
         
         DesiredCapabilities cap = new DesiredCapabilities();
         
        cap.setCapability(ChromeOptions.CAPABILITY,options);
         
         cap.setBrowserName("chrome");
         String Node = " http://192.168.0.81:5550/wd/hub";
         driver = new RemoteWebDriver(new URL(Node), cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         // Launch website
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      } else if (browser.equalsIgnoreCase("ie")) {
         System.out.println(" Executing on IE");
         DesiredCapabilities cap = DesiredCapabilities.chrome();
         cap.setBrowserName("ie");
         String Node = "http://10.112.66.52:5558/wd/hub";
         driver = new RemoteWebDriver(new URL(Node), cap);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         // Launch website
         driver.navigate().to(URL);
         driver.manage().window().maximize();
      } else {
         throw new IllegalArgumentException("The Browser Type is Undefined");
      }
   }
   
   @Test
   public void calculatepercent() throws InterruptedException {
     
         System.out.println(" The Result is Pass");
      
         System.out.println(" The Result is Fail");
   }
      
   
   @AfterTest
   public void closeBrowser() {
      driver.quit();
   }
}


