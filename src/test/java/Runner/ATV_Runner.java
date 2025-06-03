package Runner;
import Hooks.HooksClass;
import io.appium.java_client.android.AndroidDriver;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

@CucumberOptions(
        features = "src/main/java/AndroidTV/Features",
        glue = {"AndroidTV.StepDefinition", "HooksClass"},
        tags = "@smoke",
        dryRun = false,
        monochrome = true
)
public class ATV_Runner extends AbstractTestNGCucumberTests {

    public static RemoteWebDriver driver;

    @BeforeTest
    @Parameters({"platform","osversion","deviceName","appiumPort","userType"})
    public static void beforeScenario(String platform, String osversion, String deviceName, String appiumPort, String userType) throws MalformedURLException, InterruptedException {
        System.out.println("Executing Before Hook: Setup for the scenario.");
        HooksClass.appiumStart(appiumPort);
        HooksClass.initializeDriver(platform,osversion,deviceName,appiumPort,userType);
        Thread.sleep(8000);
    }

    @AfterTest
    @Parameters("appiumPort")
    public static void afterScenario(String appiumPort) {
        System.out.println("Executing After Hook: Cleanup after the scenario.");
        HooksClass.stopAppium(appiumPort);
    }

}
