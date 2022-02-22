package Pages;

import Utilities.Attributes;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;

public class AuthonticationPage extends Attributes {

    WebDriver driver;

    public AuthonticationPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillRegisterationForm() throws Exception {

        Utilities.waitAndClickOnWebElement(maleGender,driver);
        Utilities.waitAndEnterTextInWebElement("mohamed",firstName,driver);
        Utilities.waitAndEnterTextInWebElement("yehia",lastName,driver);
        Utilities.waitAndEnterTextInWebElement("mohamed2012",password,driver);
        Utilities.waitAndEnterTextInWebElement("mohamed",firstNameAddress,driver);
        Utilities.waitAndEnterTextInWebElement("yehia",lastNameAddress,driver);
        Utilities.waitAndEnterTextInWebElement("Cairo",address1,driver);
        Utilities.waitAndEnterTextInWebElement("El-Shrouk",city,driver);
        Utilities.waitAndEnterTextInWebElement("20000",postCode,driver);
        Utilities.waitAndEnterTextInWebElement("01145500816",phoneMobile,driver);
        Utilities.waitAndEnterTextInWebElement("alies",alies,driver);

        Utilities.waitAndSelectFromDropdown(days,"1",driver);
        Utilities.waitAndSelectFromDropdown(months,"1",driver);
        Utilities.waitAndSelectFromDropdown(years,"1999",driver);

        Utilities.waitAndSelectFromDropdown(state,"1",driver);


        Utilities.waitAndClickOnWebElement(submitAccountButton,driver);
        Utilities.waitAndClickOnWebElement(homeButton,driver);
    }
}
