package pageObject.weatherIndex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
/**
 * Created by Ujjwal on 4/17/2017.
 */
public class WeatherIndex {
    WebDriver driver;

    @FindBy(xpath = ".//*[@id='wx-header-wrap']/div/div/div/div[2]/div[2]/div/section/div/form/input")
    WebElement searchBox;

    @FindBy(css = ".wx-iconfont-global.wx-icon-search.icon--search")
    WebElement searchBtn;

    @FindBy(linkText = "Kathmandu, Madhyamanchal, Nepal")
    WebElement refineSearch;

    @FindBy(linkText = "5 Day")
    WebElement fiveDays;

    @FindBy(xpath = ".//*[@id='APP']/div/div[8]/div[2]/div[2]/div[1]/div/h1")
    WebElement fiveDayPage;

    @FindBy(xpath = ".//td[@headers='hi-lo']")
    List<WebElement> hiLo;

    public WeatherIndex(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void gotoSearchBox(String searchKeys){
        searchBox.sendKeys(searchKeys);

    }
    public void clickSearchbtn(){
        searchBtn.click();
        refineSearch.click();
    }
    public void gotoFiveDayWeather(){
        fiveDays.click();
    }
    public void showAvgHighLowTemp() {
        Integer totalLoTemp = 0;
        Integer totalHiTemp = 0;

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElements(hiLo));

        for (WebElement hiLoElement : hiLo) {
            totalHiTemp += Integer.parseInt(hiLoElement.getText().replace("°", "").substring(0, 2).replace("--", "0"));
            totalLoTemp += Integer.parseInt(hiLoElement.getText().replace("°", "").substring(2, 4).replace("--", "0"));
        }

        System.out.println("Avg High Temp = " + totalHiTemp / hiLo.size());
        System.out.println("Avg Low Temp = " + totalLoTemp / hiLo.size());

        if (totalHiTemp>=20 && totalHiTemp<=25){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
