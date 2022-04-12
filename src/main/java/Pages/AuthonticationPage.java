package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthonticationPage {

    WebDriver driver;

    //Registeration Form
    public By maleGender = By.id("id_gender1");
    public By firstName = By.id("customer_firstname");
    public By lastName = By.id("customer_lastname");
    public By password = By.id("passwd");
    public By firstNameAddress = By.id("firstname");
    public By lastNameAddress = By.id("lastname");
    public By address1 = By.id("address1");
    public By city = By.id("city");
    public By postCode = By.id("postcode");
    public By phoneMobile = By.id("phone_mobile");
    public By alies = By.id("alias");
    public By submitAccountButton = By.id("submitAccount");


    //DropDownLists
    public By days = By.id("days");
    public By months = By.id("months");
    public By years = By.id("years");
    public By state = By.id("id_state");
    public By county = By.id("id_county");

    public By homeButton = By.xpath("//li/a[@class = 'btn btn-default button button-small']");

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
