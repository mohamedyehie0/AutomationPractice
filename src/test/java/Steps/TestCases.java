package Steps;

import Pages.*;
import Utilities.Attributes;
import Utilities.StaticProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestCases extends Attributes {

    private WebDriver driver;

    private SoftAssert softAssert;

    @BeforeTest
    public void browserInitialization(){

        System.setProperty("webdriver.chrome.driver","driver/New Folder/chromedriver.exe");

//        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();


    }

    @Test
    public void Register() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        AuthonticationPage authonticationPage = loginPage.regiseration("m.yehiaintern@gmail.com");
        authonticationPage.fillRegisterationForm("Mohamed", "Yehia", "123456", "Ahmed",
                "Mohamed","Elshrouk", "Cairo", "20000", "01015021000", "alies",
                "1", "1", "1999", "1");
    }

    @Test(dataProvider = "ValidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void validSignIn(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();

        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        System.out.println(" debug"+Email + Password);



    }

    @Test(dataProvider = "ValidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void Login(String TestID, String TestDescription, String Email, String Password,String expectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        MyAccountPage myAccountPage = loginPage.login(Email,Password);
    }

//    @Test
//    public void BuyForWomen() throws Exception {
//        Login();
//        HomePage homePage = new HomePage(driver);
//        CategoryPage categoryPage = homePage.chooseCategory();
//        categoryPage.addProductToCart("small","orange");
//
//    }



    @AfterTest
    public void endTest(){
        driver.quit();
    }

}
