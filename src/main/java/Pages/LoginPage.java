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

    public AuthonticationPage regiseration() throws Exception{

        Utilities.waitAndEnterTextInWebElement("medoyehia8@gmail.com",emailCreateTextField,driver);
        Utilities.waitAndClickOnWebElement(createAccountButton,driver);

        return new AuthonticationPage(driver);
    }

    public MyAccountPage login() throws Exception {
        Utilities.waitAndEnterTextInWebElement("medoyehia8@gmail.com",emailTextField,driver);
        Utilities.waitAndEnterTextInWebElement("mohamed2012",password,driver);

        Utilities.waitAndClickOnWebElement(submitLogin,driver);

        return new MyAccountPage(driver);

    }


}
