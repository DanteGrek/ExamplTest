package com.site;

import com.pages.MainGooglePage;
import driver.BrowserManager;

/**
 * Created by dante on 3/11/17.
 */
public class Google {

    private final String url = "http://www.google.com";

    public MainGooglePage openMainGooglePage(){
        BrowserManager.getBrowserInstance().get(url);
        return new MainGooglePage();
    }
}
