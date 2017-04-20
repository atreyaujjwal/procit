package tests.weatherTest;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageObject.weatherIndex.WeatherIndex;
import tests.BaseTest;
/**
 * Created by Ujjwal on 4/17/2017.
 */
public class WeatherTest extends BaseTest {
    @Test
    public void allTeststoCheckKathmanduWeather() throws InterruptedException {
        WeatherIndex weatherIndex=new WeatherIndex(driver);
        PageFactory.initElements(driver,weatherIndex);

        weatherIndex.gotoSearchBox("Kathmandu, Madhyamanchal, Nepal");
        Thread.sleep(2000);
        //click search btn
        weatherIndex.clickSearchbtn();
        //click in 5 day link
        weatherIndex.gotoFiveDayWeather();
        weatherIndex.showAvgHighLowTemp();
    }
}









