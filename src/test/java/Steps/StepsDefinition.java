package Steps;

import Pages.AuthonticationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.Attributes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsDefinition extends Attributes {

    private WebDriver driver;


    @Before
    public void browserInitialization(){

        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(webUrl);


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

    @Test
    public void Login() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        MyAccountPage myAccountPage = loginPage.login("medoyehia8@gmail.com","mohamed2012");
    }

//    @After
//    public void endTest(){
//        driver.close();
//    }
//
}
