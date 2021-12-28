package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	 public static ExtentReports extentReports = new ExtentReports();

    public static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./Report/ext-report.html");
        reporter.config().setReportName("Regression Test Execution Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Operating System","Windows");
        extentReports.setSystemInfo("Author", "Lakshmikanth");
        extentReports.setSystemInfo("Build Release Version","v1.0" );
        return extentReports;
    }
}
