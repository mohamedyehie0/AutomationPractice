package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    public By emailCreateTextField = By.id("email_create");
    public By emailTextField = By.id("email");
    public By createAccountButton = By.id("SubmitCreate");
    public By password = By.id("passwd");
    public By submitLogin = By.id("SubmitLogin");


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

        return new MyAccountPage(driver);

    }


}
