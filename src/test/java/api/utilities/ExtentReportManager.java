package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest test;
    String reportName;
    @Override
    public void onStart(ITestContext context)
    {
        String timeStamp=new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss").format(new Date());
        reportName="Test-Report-"+timeStamp+".html";
        extentSparkReporter=new ExtentSparkReporter("C://Users//abhay//IdeaProjects//APIAutomationFramework//Reports//"+reportName);
        extentSparkReporter.config().setDocumentTitle("RestAssured");
        extentSparkReporter.config().setReportName("API Automation");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Operating Syatem",System.getProperty("os.name"));
        extentReports.setSystemInfo("Environment","QA");
    }

    @Override
    public void onTestStart(ITestResult result) {
       test=extentReports.createTest(result.getName());
       test.assignCategory(result.getMethod().getGroups());
       test.createNode(result.getName());
       test.log(Status.PASS,"Test Pass");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test=extentReports.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.SKIP,"Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
