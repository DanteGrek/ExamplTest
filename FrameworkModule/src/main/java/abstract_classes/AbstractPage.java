package abstract_classes;

import driver.Browser;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by dante on 3/11/17.
 */
public abstract class AbstractPage<T extends AbstractPage> {

    public AbstractPage() {
        HtmlElementLoader.populatePageObject(this, Browser.getInstance());
    }

    public T refreshPage(){
        Browser.getInstance().navigate().refresh();
        return (T) this;
    }

    protected AbstractPage click(WebElement element){
        waitForElementToBeClickable(element).click();
        return this;
    }

    protected AbstractPage doubleClick(WebElement element){
        waitForElementToBeClickable(element);
        initActions().doubleClick(element).perform();
        return this;
    }

    protected AbstractPage inputText(WebElement element, String text){
        waitForElementToBeClickable(element).sendKeys(text);
        return this;
    }

    protected AbstractPage moveToElement(WebElement element){
        waitForElementToBeClickable(element);
        initActions().moveToElement(element).perform();
        return this;
    }

    private Actions initActions(){
        return new Actions(Browser.getInstance());
    }

    private WebElement waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Browser.getInstance(),5);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
