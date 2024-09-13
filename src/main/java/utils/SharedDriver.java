package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class SharedDriver extends EventFiringDecorator<WebDriver> {
//    public static WebDriver driver;
//    public  SharedDriver(){
//        this.driver=driver;
//
//    }
//TestUtils utils = new TestUtils();

//    public DesiredCapabilities getCaps() throws IOException {
//        GlobalParams params = new GlobalParams();
//        Properties props = new PropertyManager().getProps();
//    }
private static AndroidDriver driver;

    public static AndroidDriver getCapabilities() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy A21s");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            capabilities.setCapability(MobileCapabilityType.UDID, "RZ8N609NS9X");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
            capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        }

    return driver;

//    UiAutomator2Options options = new UiAutomator2Options();
//    options.setPlatformName("Android");
//    options.setDeviceName("NILA'S M51");
//    options.setPlatformVersion("12");
//    options.setUdid("RZ8N91WR1CD");
//    options.setAutomationName("UiAutomator2");
//    options.setAppPackage("com.sec.android.app.popupcalculator");
//    options.setAppActivity("com.sec.android.app.popupcalculator.Calculator");
//        return options;
//    getDriver(capabilities);

}
public static AndroidDriver getDriver(DesiredCapabilities capabilities) throws MalformedURLException {
    AndroidDriver driver;
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    UiAutomator2Options options = new UiAutomator2Options();
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        return driver;

    }
}
