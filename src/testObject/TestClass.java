package testObject;

import dataObject.DataFromExcel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObject.HomePageScreen;
import pageObject.ResultOfBusesSearchPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestClass {
    static ChromeOptions options;
    static WebDriver driver;
    static HomePageScreen homePage;
    static ResultOfBusesSearchPage listOfBusAndPrice;
    static DataFromExcel dataObjectFromExcel;


    @BeforeTest
    public void environmentSetUp() {
        options = new ChromeOptions();
        Map<String,Object> prefs= new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications",2);
        options.setExperimentalOption("prefs", prefs);

        System.setProperty("webdriver.chrome.driver", "C:\\Jarfiles\\jarchrome\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        homePage = new HomePageScreen();
        PageFactory.initElements(driver, homePage);

        listOfBusAndPrice = new ResultOfBusesSearchPage();
        PageFactory.initElements(driver, listOfBusAndPrice);

        dataObjectFromExcel= new DataFromExcel();
        PageFactory.initElements(driver, dataObjectFromExcel);


    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }


}
