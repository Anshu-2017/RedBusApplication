package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageScreen {

    @FindBy(xpath="//input[@data-message='Please enter a source city']")
    static WebElement fromEditBox;

    @FindBy(xpath="//input[@data-message='Please enter a destination city']")
    static WebElement toEditBox;

    @FindBy(xpath="//ul[@class='autoFill']/li")
    static WebElement optionSelected;

    @FindBy(xpath="//label[@for='onward_cal']")
    static WebElement fromCalenderBox;

    @FindBy(xpath="//div[@id='rb-calendar_onward_cal']//td[text()='30']")
    static WebElement dateSelected;


    @FindBy(xpath="//button[@id='search_btn'][text()='Search Buses]")
    static WebElement serachBtn;


    public void doSerachBus(WebDriver driver, String fromDestination, String toDestination) throws Exception {
        Thread.sleep(2000);
        fromEditBox.sendKeys(fromDestination);
        Thread.sleep(2000);
        Actions fromSelection= new Actions(driver);
        fromSelection.click(optionSelected).build().perform();

        Thread.sleep(2000);
        toEditBox.sendKeys(toDestination);
        Thread.sleep(2000);
        Actions toSelection= new Actions(driver);
        fromSelection.click(optionSelected).build().perform();

        fromCalenderBox.click();
        Thread.sleep(2000);
        dateSelected.click();
        Thread.sleep(2000);
        toEditBox.click();
        toEditBox.sendKeys(Keys.ENTER);

    }


}
