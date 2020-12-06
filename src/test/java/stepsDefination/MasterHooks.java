package stepsDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import orangeHrmPage.BasePage;


public class MasterHooks extends BasePage {

    public MasterHooks(){
        super();
    }

    @Before
    public void setup() {
        setUp();
    }

    @After
    public void quit() {
        tearDown();
    }

}





















/*    public void tearDownAndScreenshotOnSuccess(Scenario scenario) {
        try {
            if (driver != null && !scenario.isFailed()) {
                //scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
                BasePage.captureScreenshot();
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
        }
    }*/




