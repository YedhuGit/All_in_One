package Runner;

import Hooks.HooksClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

    @CucumberOptions(
            features = "src/main/java/Web/WebFeature",
            glue = {"Web.StepDefinitions", "Hooks"},
            tags = "@Web",
            plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
    )
    public class Web_Runner extends AbstractTestNGCucumberTests {


        @BeforeTest
        @Parameters({"platform", "browser"})
        public void beforeScenario(String platform, String browser) throws MalformedURLException, InterruptedException {
            HooksClass.web_platform_driver_init(browser);
            HooksClass.driver.get("https://www.amazon.in/");
            Thread.sleep(3000);
        }

        @AfterTest
        public void afterScenario() {
            HooksClass.driver.quit();
            System.out.println("browser quit");
        }
    }

