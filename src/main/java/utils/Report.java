package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void initReport() {
        String timeStamp = new SimpleDateFormat("ddMMM_HHmm").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/report/TestReport_" + timeStamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Mobile Automation Execution Report");
        spark.config().setDocumentTitle("Test Execution Summary");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    public static void createTest(String scenarioName) {
        if (extent == null) {
            System.out.println("❗Extent is NULL in createTest(). Did you forget to call initReport()?");
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
        getTest().info(message);
    }

    public static void logPass(String message) {
        getTest().pass(message);
    }

    public static void logFail(String message) {
        getTest().fail(message);
    }

    public static void attachScreenshot(String path) {
        getTest().addScreenCaptureFromPath(path);
    }
}
