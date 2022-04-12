package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.StaticProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InValidLogin extends TestBases{


    @Test(dataProvider = "InvalidLoginSheetData", dataProviderClass = StaticProvider.class)
    public void inValidSignIn(String TestID, String TestDescription, String Email, String Password, String ExpectedMessage) throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();

        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        String actualMessage = myAccountPage.getErrorMessage();
        softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, ExpectedMessage);
    }
}
