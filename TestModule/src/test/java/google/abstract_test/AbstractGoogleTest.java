package google.abstract_test;

import com.pages.MainGooglePage;
import com.site.Google;
import driver.BrowserManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by dante on 3/11/17.
 */
public abstract class AbstractGoogleTest {

    public MainGooglePage mainGooglePage;

    @BeforeClass
    public void openChromeAndGoToGoogle(){
        BrowserManager.startChrome();
        mainGooglePage = new Google().openMainGooglePage();
    }

    @AfterClass
    public void closeChrome(){
        BrowserManager.tearDown();
    }
}
