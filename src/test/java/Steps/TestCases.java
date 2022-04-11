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

    @BeforeMethod
    public void browserInitialization(){

        System.setProperty("webdriver.chrome.driver","driver/New Folder/chromedriver.exe");

//        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(webUrl);
        driver.manage().window().maximize();


    }

    @Test(dataProvider = "ValidSignUpSheetData", dataProviderClass = StaticProvider.class)
    public void Registeration(String TestID, String TestDescription, String FirstName,
                       String LastName, String Email, String Password, String Address, String City,
                       String State, String ZipCode, String Country,
                       String MobilePhone, String AliasEmail, String ExpectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        AuthonticationPage authonticationPage = loginPage.regiseration(Email);
        MyAccountPage myAccountPage = authonticationPage.fillRegisterationForm(FirstName, LastName, Password, "Ahmed",
                "Mohamed",Address, City, ZipCode, MobilePhone, AliasEmail,
                "1", "1", "1999", "1");

        String actualMessage = myAccountPage.getWelcomeMessage();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, ExpectedMessage);

    }

    @Test(dataProvider = "ValidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void validSignIn(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();

        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        String actualMessage = myAccountPage.getWelcomeMessage();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, ExpectedMessage);
    }


    @Test(dataProviderClass = StaticProvider.class,dataProvider = "ValidLoginSheetData")
    public void BuyForWomen(String TestID, String TestDescription, String Email, String Password,String expectedMessage) throws Exception {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        CategoryPage categoryPage = homePage.chooseCategory();
        categoryPage.addProductToCart("small","orange");

    }



    @AfterMethod
    public void endTest(){
        driver.quit();
    }

}
