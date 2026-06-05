package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	

    public static ExtentReports getReportInstance() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("test-output/ExtentReport.html");

        spark.config().setReportName("Automation Exercise Report");
        spark.config().setDocumentTitle("Test Execution Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;
    }

}
