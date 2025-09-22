package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Report {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /**
     * Initialize ExtentReports instance.
     * Call once before running any tests.
     */
    public static void initReport() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("ddMMYYYY").format(new Date());
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

    /**
     * Flush the report to disk.
     * Call once after all scenarios/tests finish.
     */
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    /**
     * Create a new test in the report for the given scenario.
     */
    public static void createTest(String scenarioName) {
        if (extent == null) {
            System.err.println("❗ ExtentReports not initialized. Did you forget to call initReport()?");
            return;
        }
        ExtentTest extentTest = extent.createTest(scenarioName);
        test.set(extentTest);
    }

    /**
     * Clear the current thread's test instance.
     */
    public static void clearTest() {
        test.remove();
    }

    /**
     * Get the current thread's ExtentTest instance.
     */
    public static ExtentTest getTest() {
        return test.get();
    }

    /**
     * Log INFO message.
     */
    public static void logInfo(String message) {
        if (getTest() != null) {
            getTest().info(message);
        } else {
            System.out.println("[INFO] " + message);
        }
    }

    /**
     * Log PASS message.
     */
    public static void logPass(String message) {
        if (getTest() != null) {
            getTest().pass(message);
        } else {
            System.out.println("[PASS] " + message);
        }
    }

    /**
     * Log FAIL message.
     */
    public static void logFail(String message) {
        if (getTest() != null) {
            getTest().fail(message);
        } else {
            System.err.println("[FAIL] " + message);
        }
    }

    /**
     * Attach screenshot to report.
     */
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
