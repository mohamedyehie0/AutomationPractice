package Pages;

import Utilities.*;
import org.openqa.selenium.WebDriver;

public class HomePage extends Attributes {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnLogin () throws Exception {

        Utilities.waitAndClickOnWebElement(signIn,driver);

        return new LoginPage(driver);

    }


}
