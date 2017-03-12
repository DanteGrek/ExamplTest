package google.test;

import google.abstract_test.AbstractGoogleTest;
import org.testng.annotations.Test;

/**
 * Created by dante on 3/11/17.
 */
public class GoogleTest extends AbstractGoogleTest{
    @Test
    public void firstTest(){
        System.out.println("test1");
        mainGooglePage.refreshPage();
    }
    @Test
    public void secondTest(){
        System.out.println("test2");
        mainGooglePage.refreshPage();
    }
}
