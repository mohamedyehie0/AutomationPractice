package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

    private final WebDriver driver;
    public By welcomeMessage = By.className("info-account");
    public By authonticationErrorMessage = By.id("authentication");

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
