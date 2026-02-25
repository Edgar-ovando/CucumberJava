package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddCustomerPage;
import pages.LoginPage;
import org.apache.logging.log4j.Logger;   //Log4j
import utils.WaitHelper;

import java.util.Properties;


public class BaseClass {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddCustomerPage addCustomerPage;
    protected static  Logger logger;
    protected Properties p;

    //testing Push


    public static class BasePage {

        protected WebDriver driver;
        protected WaitHelper waitHelper;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            waitHelper = new WaitHelper(driver);
        }

    }
}
