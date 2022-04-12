package Pages;

import Utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private final WebDriver driver;
    public By signIn = By.className("login");
    public By hoverWomen = By.xpath("//li/a[@class = 'sf-with-ul']");
    public By tShirtsWomen = By.xpath("//li/a[@title = 'T-shirts']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickOnLogin () throws Exception {

        Utilities.waitAndClickOnWebElement(signIn,driver);

        return new LoginPage(driver);

    }

    public CategoryPage chooseCategory() throws Exception {
        Utilities.hoverOverElement(hoverWomen, driver);
        Utilities.waitAndClickOnWebElement(tShirtsWomen, driver);

        return new CategoryPage(driver);
    }


}
