package testObject;


import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestClass{
    @Test(priority=1)
    public void doLogin() throws Exception {
        homePage.doSerachBus(driver, "Bangalore (All Locations)", "Pune (All Locations)");
        Thread.sleep(2000);
    }

    @Test(priority=2)
    public void verifyResultPage() throws Exception {

        try {
            Assert.assertTrue(listOfBusAndPrice.verifyModifyBtn());
        } catch (AssertionError e) {
            System.out.println("Result page is not displayed");
            throw e;
        }
        System.out.println("Result page is displayed");

    }


}
