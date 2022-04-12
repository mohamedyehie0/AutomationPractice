package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage  {

    private final WebDriver driver;

    public By smallSizeFilter = By.name("layered_id_attribute_group_1");
    public By mediumSizeFilter = By.name("layered_id_attribute_group_2");
    public By largeSizeFilter = By.name("layered_id_attribute_group_3");

    public By orangeFilter = By.name("layered_id_attribute_group_13");
    public By blueFilter = By.name("layered_id_attribute_group_14");

    public By product = By.xpath("//li/div[@class = 'product-container']");
    public By moreButton = By.xpath("//div/a[@class= 'button lnk_view btn btn-default']");
    public By addToCart = By.xpath("//p/button[@class = 'exclusive']");
    public By proccedToCheckout = By.xpath("//div/a[@class = 'btn btn-default button button-medium']");

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
