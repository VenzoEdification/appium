package driver;

import constants.AppConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class driverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, AppConstants.PLATFORM_NAME);
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, AppConstants.DEVICE_NAME);
                caps.setCapability(MobileCapabilityType.BROWSER_VERSION, AppConstants.ANDROID_VERSION);
                caps.setCapability(MobileCapabilityType.UDID, AppConstants.UDID);
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AppConstants.AUTOMATION_NAME);
                caps.setCapability("appPackage", AppConstants.APP_PACKAGE);
                caps.setCapability("appActivity", AppConstants.APP_ACTIVITY);
                caps.setCapability("unicodeKeyboard", true);
//                caps.setCapability("resetKeyboard", true);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
