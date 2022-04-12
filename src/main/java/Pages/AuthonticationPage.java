package Pages;

import Utilities.Attributes;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;

public class AuthonticationPage extends Attributes {

    WebDriver driver;

    public AuthonticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage fillRegisterationForm(String fName, String lName, String pswd, String fNAddress,
                                               String lNAddress, String fAddress, String City, String postalCode,
                                               String mobile, String Alies, String day,String month, String year,
                                               String State) throws Exception {

        Utilities.waitAndClickOnWebElement(maleGender, driver);
        Utilities.waitAndEnterTextInWebElement(fName, firstName, driver);
        Utilities.waitAndEnterTextInWebElement(lName, lastName, driver);
        Utilities.waitAndEnterTextInWebElement(pswd, password, driver);
        Utilities.waitAndEnterTextInWebElement(fNAddress, firstNameAddress, driver);
        Utilities.waitAndEnterTextInWebElement(lNAddress, lastNameAddress, driver);
        Utilities.waitAndEnterTextInWebElement(fAddress, address1, driver);
        Utilities.waitAndEnterTextInWebElement(City, city, driver);
        Utilities.waitAndEnterTextInWebElement(postalCode, postCode, driver);
        Utilities.waitAndEnterTextInWebElement(mobile, phoneMobile, driver);
        Utilities.waitAndEnterTextInWebElement(Alies, alies, driver);

        Utilities.waitAndSelectFromDropdown(days, day, driver);
        Utilities.waitAndSelectFromDropdown(months, month, driver);
        Utilities.waitAndSelectFromDropdown(years, year, driver);

        Utilities.waitAndSelectFromDropdown(state, State, driver);


        Utilities.waitAndClickOnWebElement(submitAccountButton, driver);
//        Utilities.waitAndClickOnWebElement(homeButton, driver);

        return new MyAccountPage(driver);
    }
}
