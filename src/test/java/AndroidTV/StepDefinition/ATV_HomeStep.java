package AndroidTV.StepDefinition;

import AndroidTV.Functions.ATV_HomeFunc;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ATV_HomeStep {
    ATV_HomeFunc atv_homaPageFunc = new ATV_HomeFunc();

    @Given("User launches the sony app")
    public void userLaunchesTheSonyApp() throws InterruptedException {
        atv_homaPageFunc.launchApp();
        Thread.sleep(30000);
    }
}
