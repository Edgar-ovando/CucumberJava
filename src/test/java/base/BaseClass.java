package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddCustomerPage;
import pages.LoginPage;
import org.apache.logging.log4j.Logger;   //Log4j
import utils.WaitHelper;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AddCustomerPage addCustomerPage;
    protected static  Logger logger;
    protected Properties p;

    public static class BasePage {

        protected WebDriver driver;
        protected WaitHelper waitHelper;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
            waitHelper = new WaitHelper(driver);
        }

    }

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






}
