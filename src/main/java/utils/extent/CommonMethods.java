package utils.extent;

import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.Map;

import static utils.SharedDriver.driver;

public class CommonMethods {
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomEmail = new StringBuilder();
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            randomEmail.append(characters.charAt(index));
        }

        return randomEmail.toString() + "@gmail.com";

    }

    public static void slightScrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.6);
        int endY   = (int) (size.height * 0.4);

        Map<String, Object> args = new HashMap<>();
        args.put("left", startX);
        args.put("top", endY);                // top should be the smaller Y
        args.put("width", 1);                 // minimum width (cannot be 0)
        args.put("height", startY - endY);    // positive height
        args.put("direction", "up");
        args.put("percent", 0.2);             // small scroll
        driver.executeScript("mobile: swipeGesture", args);

    }
}

