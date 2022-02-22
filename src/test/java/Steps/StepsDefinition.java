package Steps;

import Pages.AuthonticationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.Attributes;
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
        AuthonticationPage authonticationPage = loginPage.regiseration();
        authonticationPage.fillRegisterationForm();
    }

}
