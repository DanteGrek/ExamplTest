package com.site;

import com.pages.MainGooglePage;
import driver.Browser;

/**
 * Created by dante on 3/11/17.
 */
public class Google {

    private final String url = "http://www.google.com";

    public MainGooglePage openMainGooglePage(){
        Browser.getInstance().get(url);
        return new MainGooglePage();
    }
}
