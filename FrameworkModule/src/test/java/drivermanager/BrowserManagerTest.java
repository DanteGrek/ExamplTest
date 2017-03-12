package drivermanager;

import driver.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by dante on 3/11/17.
 */
public class BrowserManagerTest {
    @BeforeMethod
    public void startBrowser(){

        Browser.startFirefox().get("http://google.com");
    }

    @Test
    public void firstTest(){
        System.out.println("FM test");
        Assert.assertTrue(Browser.startFirefox().getCurrentUrl() != null);
        Browser.tearDown();
        Browser.startChrome();
        Assert.assertTrue(Browser.startChrome().getCurrentUrl() != null);
    }

    @AfterClass
    public void closeBrowser(){
        Browser.tearDown();
    }
}
