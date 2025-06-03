package AndroidTV.StepDefinition;

import AndroidTV.Functions.ATV_HomeFunc;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ATV_HomeStep {
    ATV_HomeFunc atv_homaPageFunc = new ATV_HomeFunc();

    @Given("User launches the app")
    public void userLaunchesTheApp() {
        atv_homaPageFunc.launchApp();
    }
    @Given("User send message through app")
    public void user_send_message_through_app() {

    }
}
