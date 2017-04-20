package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by Ujjwal on 4/17/2017.
 */
public class BaseTest {

  public WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://weather.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
