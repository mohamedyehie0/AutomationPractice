package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestBases  {

    protected WebDriver driver;
    protected String webUrl = "http://automationpractice.com/index.php";
    protected SoftAssert softAssert;




    @BeforeMethod
    public void browserInitialization(){

        System.setProperty("webdriver.chrome.driver","driver/New Folder/chromedriver.exe");

//        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();


    }


    @AfterMethod
    public void endTest(){
        driver.quit();
    }

}
