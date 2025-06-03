package Hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class HooksClass {

    public static RemoteWebDriver driver;
    public static AppiumDriverLocalService service;



    public static void initializeDriver(String platformName, String osversion,String deviceName, String appiumPort, String userType ) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName",platformName);
        desiredCapabilities.setCapability("platformVersion",osversion);
        desiredCapabilities.setCapability("deviceName",deviceName);
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("appPackage","com.sonyliv");
        desiredCapabilities.setCapability("appActivity","ui.splash.SplashActivity");
        desiredCapabilities.setCapability("app","/Users/yedhukv/IdeaProjects/All_in_One_Automation/src/main/java/AndroidTV/Utilities/Apps/ATV_Prod_SP104_105_QA_INSP_INC1_REL_VC10684_V_6_12_81_T_291020241241_Debug (1).apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:"+appiumPort),desiredCapabilities);
    }

    public static void appiumStart(String port){
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingPort(Integer.parseInt(port))
                .withIPAddress("127.0.0.1")
                .withArgument(() -> "--session-override")  // Example argument
                .withArgument(() -> "--log-level", "error");
        service = AppiumDriverLocalService.buildService(serviceBuilder);
        service.start();
        System.out.println("Appium server started with port "+port);
    }
    public static void stopAppium(String port){
        service.stop();
        System.out.println("Appium server stopped with port "+port);
    }


}
