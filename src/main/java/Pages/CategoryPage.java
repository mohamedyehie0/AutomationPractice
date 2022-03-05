package Pages;

import Utilities.Attributes;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends Attributes {

    private final WebDriver driver;

    public CategoryPage(WebDriver driver) {this.driver = driver;}


    public void filterBySize(String size) throws Exception {

        switch (size) {
            case "small":
                Utilities.waitAndClickOnWebElement(smallSizeFilter, driver);
                break;
            case "medium":
                Utilities.waitAndClickOnWebElement(mediumSizeFilter, driver);
                break;
            case "large":
                Utilities.waitAndClickOnWebElement(largeSizeFilter, driver);
                break;
        }

    }

    public void filterByColor(String color) throws Exception {

        switch (color) {
            case "orange":
                Utilities.waitAndClickOnWebElement(orangeFilter, driver);
                break;
            case "blue":
                Utilities.waitAndClickOnWebElement(blueFilter, driver);
                break;
        }
    }

    public void chooseProduct() throws Exception {

        Utilities.hoverOverElement(product,driver);
        Utilities.waitAndClickOnWebElement(moreButton,driver);
    }

    public CheckoutPage addProductToCart(String size, String color) throws Exception {

        filterBySize(size);
        filterByColor(color);
        chooseProduct();
        Utilities.waitAndClickOnWebElement(addToCart,driver);
        Utilities.waitAndClickOnWebElement(proccedToCheckout,driver);

        return new CheckoutPage(driver);
    }

}
