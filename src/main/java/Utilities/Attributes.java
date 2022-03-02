package Utilities;

import org.openqa.selenium.By;

public class Attributes {

//Home Page
    public String webUrl = "http://automationpractice.com/index.php";
    public By signIn = By.className("login");

//LoginPage
    public By emailCreateTextField = By.id("email_create");
    public By emailTextField = By.id("email");
    public By createAccountButton = By.id("SubmitCreate");

    public By submitLogin = By.id("SubmitLogin");


//Registeration Form
    public By maleGender = By.id("id_gender1");
    public By firstName = By.id("customer_firstname");
    public By lastName = By.id("customer_lastname");
    public By password = By.id("passwd");
    public By firstNameAddress = By.id("firstname");
    public By lastNameAddress = By.id("lastname");
    public By address1 = By.id("address1");
    public By city = By.id("city");
    public By postCode = By.id("postcode");
    public By phoneMobile = By.id("phone_mobile");
    public By alies = By.id("alias");
    public By submitAccountButton = By.id("submitAccount");

    //DropDownLists
    public By days = By.id("days");
    public By months = By.id("months");
    public By years = By.id("years");
    public By state = By.id("id_state");
    public By county = By.id("id_county");


    public By homeButton = By.xpath("//li/a[@class = 'btn btn-default button button-small']");






}
