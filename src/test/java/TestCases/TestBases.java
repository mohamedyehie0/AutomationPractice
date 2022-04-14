package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestBases  {

    protected WebDriver driver;
    protected String webUrl = "http://automationpractice.com/index.php";
    protected SoftAssert softAssert;

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    String timeStamp = new SimpleDateFormat("MM dd yyyy_ HH mm ss").format(Calendar.getInstance().getTime());




    @BeforeSuite
    public void setUpReport(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Report/Report " + timeStamp + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Host Name", "Mohamed Yehia");

        extentTest = extentReports.createTest("Automation Practice");
        extentSparkReporter.config().setDocumentTitle("Automation Testing Practice");
        extentSparkReporter.config().setReportName("Automation Practice Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setTimelineEnabled(true);

    }


    @BeforeMethod
    public void browserInitialization(){

        System.setProperty("webdriver.chrome.driver","driver/New Folder/chromedriver.exe");

//        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();


    }



    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
            captureScreenShot(driver);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
            captureScreenShot(driver);

        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
            extentTest.skip(result.getThrowable());
            captureScreenShot(driver);

        }

        driver.quit();

    }

    @AfterSuite
    public void tearDown() {
        extentReports.flush();
    }

    public void captureScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationFolder = System.getProperty("user.dir") + "/test-output/Screenshots/" + timeStamp + ".png";
        File destination = new File(destinationFolder);
        FileUtils.copyFile(source, destination);
        extentTest.addScreenCaptureFromPath("../Screenshots/" + timeStamp + ".png");
    }
}
