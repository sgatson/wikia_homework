package homework.test;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
  private String browser;
  private String pathToDriver;
  private String baseURL = "http://testhomework.wikia.com/";
  protected WebDriver driver = null;
  
  public void beforeTest() {
	  driver = getWebDriver();
	  driver.get(baseURL);
  }

  public void afterTest() {
	  driver.quit();
  }
  
  private WebDriver getWebDriver() {
	  loadProperties();
	  if(browser.equals("chrome")) {
          System.setProperty("webdriver.chrome.driver", pathToDriver);
          driver = new ChromeDriver();
      } else {
          driver = new FirefoxDriver();
      }
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      return driver;
  }
  
  private void loadProperties() {
	  Properties props = new Properties();
	  try {
		  InputStream inputStream = ClassLoader.getSystemResourceAsStream("TestProps.properties");
		  props.load(inputStream);
		  browser = props.getProperty("TestProps.browser");
		  pathToDriver = props.getProperty("TestProps.pathToDriver");
	  }
	  catch (Exception ex) {
		  ex.printStackTrace();
	  }
  }
}