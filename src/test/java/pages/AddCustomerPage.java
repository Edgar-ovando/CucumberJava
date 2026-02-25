package pages;

import base.BaseClass;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends BasePage {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath="//a[@href='#']//span[contains(text(),'Customers')]")
    private WebElement lnkCustomersMenu;

    @FindBy(xpath="//span[@class='menu-item-title'][contains(text(),'Customers')]")
    private WebElement lnkCustomersMenuItem;

    @FindBy(xpath="//a[@class='btn bg-blue']")
    private WebElement btnAddCustomer;

    @FindBy(xpath="//input[@id='Email']")
    private WebElement txtEmail;

    @FindBy(xpath="//input[@id='Password']")
    private WebElement txtPassword;

    @FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
    private WebElement txtCustomerRoles;


    @FindBy(xpath = "//li[contains(text(),'Administrators')]")
    private WebElement listItemAdministrators;

    @FindBy(xpath = "//li[contains(text(),'Registered')]")
    private WebElement listItemRegistered;

    @FindBy(xpath = "//li[contains(text(),'Guests')]")
    private WebElement listItemGuests;

    @FindBy(xpath = "//li[contains(text(),'Vendors')]")
    private WebElement listItemVendors;


    @FindBy(xpath = "//*[@id='VendorId']")
    private WebElement drpmgrOfVendor;

    @FindBy(id="Gender_Male")
    private WebElement rdMaleGender;

    @FindBy(id="Gender_Female")
    private WebElement rdFemaleGender;


    @FindBy(xpath="//input[@id='FirstName']")
    private WebElement txtFirstName;

    @FindBy(xpath="//input[@id='LastName']")
    private WebElement txtLastName;

    @FindBy(xpath="//input[@id='DateOfBirth']")
    private WebElement txtDateOfBirth;

    @FindBy(xpath="//input[@id='Company']")
    private WebElement txtCompanyName;

    @FindBy(xpath="//textarea[@id='AdminComment']")
    private WebElement txtAdminContent;

    @FindBy(xpath="//button[@name='save']")
    private WebElement btnSave;

    //Actions Methods

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickOnCustomersMenu(){
        lnkCustomersMenu.click();
    }

    public void clickOnCustomersMenuItem(){
        lnkCustomersMenuItem.click();
    }

    public void clickOnAddCustomer(){
        btnAddCustomer.click();
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void setCustomerRoles(String roles){
        txtCustomerRoles.sendKeys(roles);
    }















}
