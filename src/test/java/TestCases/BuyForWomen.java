package TestCases;

import Pages.CategoryPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Utilities.StaticProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BuyForWomen extends TestBases{


    @Test(dataProviderClass = StaticProvider.class,dataProvider = "ValidLoginSheetData")
    public void BuyForWomen(String TestID, String TestDescription, String Email, String Password,String expectedMessage) throws Exception {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickOnLogin();
        MyAccountPage myAccountPage = loginPage.login(Email,Password);
        CategoryPage categoryPage = homePage.chooseCategory();
        categoryPage.addProductToCart("small","orange");

    }
}
