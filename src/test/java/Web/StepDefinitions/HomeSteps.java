package Web.StepDefinitions;

import Hooks.HooksClass;
import Web.Functions.HomeFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeSteps {
    WebDriver driver = HooksClass.driver;
    public HomeFunctions homeFunctions;

    @Given("User lands on home page")
    public void userLandsOnHomePage() {

    }

    @Then("User takes all the API calls")
    public void userTakesAllTheAPICalls() throws InterruptedException {
       homeFunctions = new HomeFunctions();
        Thread.sleep(4000);
        System.out.println(homeFunctions.getXPathByVisibleText(driver,"& Orders"));
        driver.findElement(By.xpath(homeFunctions.getXPathByVisibleText(driver,"& Orders"))).click();
        Thread.sleep(10000);

    }
}
