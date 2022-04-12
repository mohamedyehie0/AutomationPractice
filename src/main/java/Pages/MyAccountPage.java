package Pages;

import Utilities.Attributes;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Attributes {

    private final WebDriver driver;

    public MyAccountPage (WebDriver driver) {
        this.driver = driver;
    }
    public String getWelcomeMessage() throws Exception {
        return Utilities.waitAndGetWebElementText(welcomeMessage, driver);
    }
    public String getErrorMessage() throws Exception {
        return Utilities.waitAndGetWebElementText(authonticationErrorMessage, driver);
    }
}
