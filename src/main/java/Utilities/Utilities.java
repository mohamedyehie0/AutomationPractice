package Utilities;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Utilities {
    public static long timeOut = 2;//in seconds

    public static void waitUntilWebElementIsPresent(By element, WebDriver driver) throws Exception {
        if (element != null) {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void waitUntilWebElementIsEnabled(By element, WebDriver driver) throws Exception {
        if (element != null) {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            System.out.println(driver.findElement(element).getAttribute("class"));
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
                while(driver.findElement(element).getAttribute("class").contains("disabled"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void waitAndClickOnWebElement (By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).click();
            } catch (Exception ex) {
                throw new Exception("Can not click on webElement: " + element.toString());
            }
        }
    }

    public static void waitAndEnterTextInWebElement (String text, By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(text);
            } catch (Exception ex) {
                throw new Exception("Can not enter text in webElement: " + element.toString());
            }
        }
    }

    public static void waitAndEnterTextInWebElementAndThenPressEnter (String text, By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                driver.findElement(element).clear();
                driver.findElement(element).sendKeys(text);
                driver.findElement(element).sendKeys(Keys.ENTER);
            } catch (Exception ex) {
                throw new Exception("Can not enter text in webElement: " + element.toString());
            }
        }
    }

    public static String waitAndGetWebElementText (By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            String webElementText = "";
            try {
                webElementText = driver.findElement(element).getText();
            } catch (Exception ex) {
                throw new Exception("Can not get text from webElement: " + element.toString());
            }
            return webElementText;
        }
        return "";
    }

    public static boolean isWebElementPresent (By element, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            boolean found=false;
            try {
                driver.findElement(element);
                found=true;
            } catch (Exception ex) {
                found=false;
            }
            return found;
        }else{
            return false;
        }

    }

    public static void addScreenshotAndLogStep(Scenario scenario,String step,WebDriver driver) throws IOException {
        /*scenario.log(step);
        Utilities.addScreenshot(scenario,driver);*/
    }


    public  static void addScreenshot(Scenario scenario,WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");
    }


    public static void switchToFrameById (String ID, WebDriver driver) throws Exception {
        if (ID != null) {
            try {
                driver.switchTo().frame(ID);
            } catch (Exception ex) {
                throw new Exception("Frame is not found by id: " +ID);
            }
        }
    }

    public static void switchToMainWindow (WebDriver driver) throws Exception {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception ex) {
            throw new Exception("Default Frame is not Found");
        }

    }

    public static void waitAndSelectFromDropdown(By element, String value, WebDriver driver) throws Exception {
        if (element != null) {
            Utilities.waitUntilWebElementIsPresent(element, driver);
            try {
                Select dropdownElement = new Select(driver.findElement(element));
                dropdownElement.selectByValue(value);
            } catch (Exception ex) {
                throw new Exception("Can not enter text in webElement: " + element.toString());
            }
        }

    }


    public static void hoverOverElement(By element, WebDriver driver) throws Exception{

        if(element!=null){
            Utilities.waitUntilWebElementIsPresent(element,driver);
            try {
                WebElement webElement = driver.findElement(element);
                Actions actions = new Actions(driver);
                actions.moveToElement(webElement).perform();
            }
            catch (Exception e){
                throw new Exception("Can not enter text in webElement: " + element.toString());

            }
        }

    }



}
