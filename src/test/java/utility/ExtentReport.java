package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentReports extent;//populate common info on the report(like tester name ,which browser,
    private static ExtentTest test;//creating test cases entries in the report and update the status of the test method
    private static ExtentSparkReporter sparkReporter;//UI of the report

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        sparkReporter = new ExtentSparkReporter("tricenties.html");//specifying file name
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);//attaching sparkreporter with extentreports
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);//create a new entry in the report
        return test;
    }

}
