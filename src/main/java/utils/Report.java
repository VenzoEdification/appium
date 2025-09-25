package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Report {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void initReport() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("dd_MM_yyy").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/reports/TestReport_" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Mobile Automation Execution Report");
            spark.config().setDocumentTitle("Test Execution Summary");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Cucumber + Appium");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void createTest(String scenarioName) {
        if (extent == null) {
            System.err.println("❗ ExtentReports not initialized. Did you forget to call initReport()?");
            return;
        }
        ExtentTest extentTest = extent.createTest(scenarioName);
        test.set(extentTest);
    }

    public static void clearTest() {
        test.remove();
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void logInfo(String message) {
        if (getTest() != null) {
            getTest().info(message);
        } else {
            System.out.println("[INFO] " + message);
        }
    }

    public static void logPass(String message) {
        if (getTest() != null) {
            getTest().pass(message);
        } else {
            System.out.println("[PASS] " + message);
        }
    }

    public static void logFail(String message) {
        if (getTest() != null) {
            getTest().fail(message);
        } else {
            System.err.println("[FAIL] " + message);
        }
    }

    public static void attachScreenshot(String path) {
        try {
            if (getTest() != null) {
                getTest().addScreenCaptureFromPath(path);
            }
        } catch (Exception e) {
            System.err.println("⚠ Could not attach screenshot: " + e.getMessage());
        }
    }
}
