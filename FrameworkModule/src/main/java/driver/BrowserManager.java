package driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by dante on 3/11/17.
 */
public class BrowserManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private BrowserManager(){

    }

    public static WebDriver getBrowserInstance(){
        return driver.get();
    }

    public static WebDriver startChrome(){
        if(getBrowser("chrome").getClass().equals(ChromeDriver.class)) {
           return driver.get();
        }else{
            return throwExceptionAndReturnDriver();
        }
    }

    public static WebDriver startFirefox() {
        if(getBrowser("firefox").getClass().equals(FirefoxDriver.class)) {
            return driver.get();
        }else{
            return throwExceptionAndReturnDriver();
        }
    }

    private static WebDriver throwExceptionAndReturnDriver(){
            System.err.println("\nYou can not start two browsers in one thread.\n");
            return driver.get();
    }

    private static WebDriver getBrowser(String browser){
        if (driver.get() == null) {
            switch (browser) {
                case "chrome":
                    ChromeDriverManager.getInstance().setup();
                    driver.set(new ChromeDriver());
                    break;
                default:
                    FirefoxDriverManager.getInstance().setup();
                    driver.set(new FirefoxDriver());
                break;
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
