package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ResultOfBusesSearchPage {

    static List<String> busName;
    static List<Double> busPrice;

    @FindBy(xpath="//div[@class='onward-modify-btn g-button clearfix fl']")
    static WebElement modifyButton;

    @FindBy(xpath="//label[@for='bt_SLEEPER'][@class='custom-checkbox']")
    static WebElement sleeperFilter;

    @FindBy(xpath="//label[@for='dtAfter 6 pm'][@class='custom-checkbox']")
    static WebElement after6Filter;

    @FindBy(xpath="//ul[@class='bus-items']//div[@class='travels lh-24 f-bold d-color']")
    static List<WebElement> allBusName;

    @FindBy(xpath="//ul[@class='bus-items']//div[@class='fare d-block']/span")
    static List<WebElement> allBusPrice;


    public boolean verifyModifyBtn() {
        return modifyButton.isDisplayed();
    }


    public List<String> fetchBusName() {
        busName= new ArrayList<String>();
        for (WebElement currenBusName: allBusName) {
            busName.add(currenBusName.getText());

        }
        return busName;


    }


    public List<Double> fetchBusPrice() {
        busPrice= new ArrayList<Double>();
        for (WebElement currentBusPrice: allBusPrice) {
            busPrice.add(Double.parseDouble(currentBusPrice.getText()));

        }
        return busPrice;
    }

    public void applyFilters() {
        after6Filter.click();
        sleeperFilter.click();
    }

}
