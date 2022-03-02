package Pages;

import Utilities.Attributes;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Attributes {


    private final WebDriver driver;

    public LoginPage(WebDriver driver) throws Exception {
        this.driver = driver;
//        Utilities.waitAndClickOnWebElement(emailTextField,driver);
    }

    public AuthonticationPage regiseration(String email) throws Exception{

        Utilities.waitAndEnterTextInWebElement(email,emailCreateTextField,driver);
        Utilities.waitAndClickOnWebElement(createAccountButton,driver);

        return new AuthonticationPage(driver);
    }

    public MyAccountPage login(String email, String userPassword) throws Exception {
        Utilities.waitAndEnterTextInWebElement(email,emailTextField,driver);
        Utilities.waitAndEnterTextInWebElement(userPassword,password,driver);

        Utilities.waitAndClickOnWebElement(submitLogin,driver);
        Utilities.waitAndClickOnWebElement(homeButton, driver);

        return new MyAccountPage(driver);

    }


}
