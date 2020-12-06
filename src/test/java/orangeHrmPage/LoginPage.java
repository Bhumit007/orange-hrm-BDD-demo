package orangeHrmPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Utilities;

public class LoginPage extends BasePage{

    public String fullName;

    @FindBy(id = "txtUsername")
    protected WebElement userName;

    @FindBy(id = "txtPassword")
    protected WebElement password;

    @FindBy(id="btnLogin")
    protected WebElement loginBtn;

    @FindBy(id = "welcome")
    protected WebElement txtWelcomeAdmin;

    @FindBy(id = "menu_pim_viewPimModule")
    protected WebElement clickOnPIM;

    @FindBy(id = "menu_pim_addEmployee")
    protected WebElement clickOnAddEmployee;

    @FindBy(id = "firstName")
    protected WebElement txtFirstName;

    @FindBy(id = "lastName")
    protected WebElement txtLastName;

    @FindBy(id = "photofile")
    private WebElement btnChooseFile;

    @FindBy(id = "chkLogin")
    protected WebElement checkBoxLogin;

    @FindBy(id = "user_name")
    protected WebElement txtUserName;

    @FindBy(id = "user_password")
    protected WebElement txtPassword;

    @FindBy(id = "re_password")
    protected WebElement txtConfirmPassword;

    @FindBy(id = "btnSave")
    protected WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'message success')]")
    protected WebElement successMessage;

    @FindBy(id = "personal_txtLicenNo")
    protected WebElement txtDriverLicenceNumber;

    @FindBy(id = "personal_txtLicExpDate")
    protected WebElement txtLicenceExpiryDate;

    @FindBy(id = "personal_txtNICNo")
    protected WebElement txtSSNNumber;

    @FindBy(id = "personal_optGender_2")
    protected WebElement radioBtnGender;

    @FindBy(id = "personal_cmbMarital")
    protected WebElement selectMaritalStatus;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    protected WebElement selectNationality;

    @FindBy(id = "personal_DOB")
    protected WebElement txtDateOfBirth;

    @FindBy(id = "menu_leave_viewLeaveModule")
    protected WebElement clickOnLeave;

    @FindBy(id = "menu_leave_Entitlements")
    protected WebElement clickOnEntitlements;

    @FindBy(id = "menu_leave_addLeaveEntitlement")
    protected WebElement clickAddLeaveEntitlement;

    @FindBy(name = "entitlements[employee][empName]")
    protected WebElement txtEmployeeName;

    @FindBy(xpath = "//li[contains(@class,'ac_even')]")
    protected WebElement selectEmployeeName;

    @FindBy(id = "entitlements_entitlement")
    protected WebElement txtEntitlement;

    @FindBy(id = "menu_leave_assignLeave")
    protected WebElement clickOnAssignLeave;

    @FindBy(name = "assignleave[txtEmployee][empName]")
    public WebElement txtAssignEmployeeName;

    //@FindBy(id = "assignleave_txtLeaveType")
    @FindBy(name = "assignleave[txtLeaveType]")
    public WebElement selectLeaveType;

    @FindBy(id = "assignleave_leaveBalance")
    public WebElement txtLeaveBalance;

    @FindBy(id = "assignleave_txtFromDate")
    public WebElement txtAssignFromDate;

    @FindBy(id = "assignleave_txtToDate")
    public WebElement txtAssignToDate;

    @FindBy(xpath = "//input[@id='assignBtn']")
    protected WebElement btnAssign;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement tabAdmin;

    @FindBy(name = "searchSystemUser[employeeName][empName]")
    public WebElement txtSearchSystemUserEmployeeName;

    @FindBy(id = "searchBtn")
    public WebElement btnSearch;

    @FindBy(name = "chkSelectRow[]")
    public WebElement CheckBoxRow;

    @FindBy(id = "btnDelete")
    public WebElement btnDelete;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement dialogButton;

    /**
     * Check Orange HRM home page.
     * @return
     */
    public LoginPage getOrangeHRMHome(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(driver.getTitle()));
        return this;
    }
    /**
     * Send Username.
     * @return
     */
    public LoginPage sendUserName(String username){
        waitActions.waitForVisibilityElement(userName);
        userName.sendKeys(username);
        return this;
    }

    /**
     * send password.
     * @return
     */
    public LoginPage sendPassword(String pass){
        waitActions.waitForVisibilityElement(password);
        password.sendKeys(pass);
        return this;
    }

    /**
     * Click on login btn.
     * @return
     */
    public LoginPage clickOnLoginBtn(){
        waitActions.waitForVisibilityElement(loginBtn);
        waitActions.waitForClickableElement(loginBtn);
        loginBtn.click();
        return this;
    }

    /**
     * System login.
     * @return
     */
    public LoginPage systemLogin(String username,String password){
        sendUserName(username);
        sendPassword(password);
        clickOnLoginBtn();
        verifyHomePage();
        return this;
    }


    /**
     * Verify home page.
     * @return
     */
    public LoginPage verifyHomePage() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtWelcomeAdmin, driver);
        return this;
    }

    /**
     * click on PIM
     *
     * @return
     */
    public LoginPage clickOnPIM() {
        Utilities.getUtilities().clickOnElement(clickOnPIM, driver);
        return this;
    }

    /**
     * click on Add Employee Tab
     *
     * @return
     */
    public LoginPage clickOnAddEmployee() {
        Utilities.getUtilities().clickOnElement(clickOnAddEmployee, driver);
        return this;
    }

    /**
     * Enter FirstName and LastName in Add Employee tab
     *
     * @return
     */
    public LoginPage enterFirstNameAndLastName() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtFirstName, driver);
        String firstName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtFirstName, firstName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtLastName, driver);
        String lastName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtLastName, lastName);
        fullName = firstName + " " + lastName;
        return this;
    }

    /**
     * File Upload
     *
     * @return
     */
    public LoginPage fileUpload() {
        Utilities.getUtilities().waitForElementTobeClickable(btnChooseFile, driver);
        Utilities.getUtilities().uploadFile(btnChooseFile, prop.getProperty("filePath"));
        return this;
    }

    /**
     * Check box for Create Login Detail
     *
     * @return
     */
    public LoginPage checkBoxCreateLoginDetail() {
        Utilities.getUtilities().clickOnElement(checkBoxLogin, driver);
        return this;
    }

    /**
     * Enter Login Detail
     *
     * @return
     */
    public LoginPage enterLoginDetail() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtUserName, driver);
        String userName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtUserName, userName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtPassword, driver);
        Utilities.getUtilities().sendKey(txtPassword, prop.getProperty("password"));
        Utilities.getUtilities().waitForVisibilityOfElement(txtConfirmPassword, driver);
        Utilities.getUtilities().sendKey(txtConfirmPassword, prop.getProperty("confirmPassword"));
        Utilities.getUtilities().clickOnElement(btnSave, driver);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Verify Success Message
     * @return
     */
    public LoginPage verifySuccessMessage(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessage")));
        return this;
    }

    public LoginPage verifySuccessMessageForAdd(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessageForAdd")));
        return this;
    }
}
