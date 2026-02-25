package tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import pages.AddCustomerPage;
import pages.LoginPage;
import base.BaseClass;

import org.apache.logging.log4j.LogManager;  //Log4j

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Steps extends BaseClass {

    @Before
    public void setUp() throws IOException
    {
        //Read config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Log4J2
        logger = LogManager.getLogger(this.getClass());
        logger.info("Launching Chrome browser");

        //Browser
        String browser = p.getProperty("browser");


        switch (browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                //WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }


    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {

        loginPage = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("Opening URL :{}" , url);
        driver.get(url);

    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        logger.info("Entering email as {} and password {}", email, password);
        loginPage.setUserName(email);
        loginPage.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_login() {

        logger.info("Clicking on Login");
        loginPage.clickLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {

        if (driver.getPageSource().contains("Login was successful")) {
            logger.info("Test FAILED");
            driver.quit();
            Assert.assertTrue(false);

        }else {
            logger.info("Test PASSED");
            Assert.assertEquals(driver.getTitle(), title);
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        logger.info("Clicking on Log out");
        loginPage.clickLogout();

    }

    @Then("close browser")
    public void close_browser() {
        logger.info("Closing Browser");
        driver.quit();
    }


    // Customer feature step definitions .......
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

        addCustomerPage = new AddCustomerPage(driver);
        Assert.assertEquals(addCustomerPage.getPageTitle(),"Dashboard / nopCommerce administration");

    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on Save button")
    public void click_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
