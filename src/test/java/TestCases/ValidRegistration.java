package TestCases;

import Pages.AuthonticationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.StaticProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidRegistration extends TestBases {


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
}
