package drivermanager;

import driver.BrowserManager;
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

        BrowserManager.startFirefox().get("http://google.com");
    }

//    @Test
    public void firstTest(){
        Assert.assertTrue(BrowserManager.startFirefox().getCurrentUrl() != null);
        BrowserManager.tearDown();
        BrowserManager.startChrome();
        Assert.assertTrue(BrowserManager.startChrome().getCurrentUrl() != null);
    }

    @AfterClass
    public void closeBrowser(){
        BrowserManager.tearDown();
    }
}
