package orangeHrmPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties prop;
    public static LoginPage loginPage;
    public static WaitActions waitActions;


    /**
     * Read properties
     */
    public BasePage(){
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/generic.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Browser setup.
     */
    public void setUp(){
        killChromeDriver();
        if(prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else {
            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        waitActions =  new WaitActions();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    /**
     * kill ChromeDriver
     */

    public void killChromeDriver() {
        String cmd = "taskkill /f /t /IM chromedriver.exe";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tearDown(){
        driver.quit();
    }
}
