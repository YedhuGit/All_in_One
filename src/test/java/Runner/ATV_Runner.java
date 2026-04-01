package Runner;

import Hooks.HooksClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import java.net.MalformedURLException;

@CucumberOptions(
        features = "src/main/java/AndroidTV/Features",
        glue = {"AndroidTV.StepDefinition", "Hooks"},
        tags = "@Demo",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)
public class ATV_Runner extends AbstractTestNGCucumberTests {

    public static RemoteWebDriver driver;

    @BeforeTest
    @Parameters({"platform", "osversion", "deviceName", "appiumPort", "userType"})
    public void beforeScenario(String platform, String osversion, String deviceName, String appiumPort, String userType) throws MalformedURLException, InterruptedException {
        System.out.println(">>> Setup before suite execution");
        HooksClass.appiumStart(appiumPort);
        HooksClass.initializeDriver(platform, osversion, deviceName, appiumPort, userType);
        Thread.sleep(8000);
    }

    @AfterTest
    @Parameters("appiumPort")
    public void afterScenario(String appiumPort) {
        System.out.println(">>> Teardown after suite execution");
        HooksClass.stopAppium(appiumPort);
    }
}
