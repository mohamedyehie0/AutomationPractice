package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.StaticProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidLogin extends TestBases{


    @Test(dataProvider = "ValidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void validLogin(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();

        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        String actualMessage = myAccountPage.getWelcomeMessage();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, ExpectedMessage);
    }
}
