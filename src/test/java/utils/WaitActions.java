package utils;

import orangeHrmPage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions extends BasePage {

    /**
     * Visibility of element.
     * @param element
     * @return
     */
    public boolean waitForVisibilityElement(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Clickable of element.
     * @param element
     * @return
     */
    public boolean waitForClickableElement(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
