package google.abstract_test;

import com.pages.MainGooglePage;
import com.site.Google;
import driver.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by dante on 3/11/17.
 */
public abstract class AbstractGoogleTest {

    public MainGooglePage mainGooglePage;

    @BeforeMethod
    public void openChromeAndGoToGoogle(){
        Browser.startChrome();
        mainGooglePage = new Google().openMainGooglePage();
    }

    @AfterMethod
    public void closeChrome(){
        Browser.tearDown();
    }
}
