package client.pageObjects;

import commonUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.pageObjects.basepages.BasePage;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "name")
    private WebElement customerName;

    @FindBy(id = "email")
    private WebElement emailId;

    @FindBy(id = "emailMatch")
    private WebElement repeatEMail;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "passwordMatch")
    private WebElement repeatPassword;

    @FindBy(id = "globalOptIn")
    private WebElement acceptTerms;

    @FindBy(id = "termsOfUse")
    private WebElement acceptTermsUse;

    @FindBy(id = "confirmAge")
    private WebElement confirmAge;

    @FindBy(id = "submitBtn")
    private WebElement signUp;

    String emailAddress = createEmailAddress();

    public CreateAccountPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void fillCreateAccountForm(String txtName, String txtPassword, String txtRepeatPassword) {
        switchFrameToCreateAccount();
        waitElementToBeVisible(customerName);
        setName(txtName);
        setEmailId();
        setRepeatEMail();
        setPassword(txtPassword);
        setRepeatPassword(txtRepeatPassword);
        acceptTerms.click();
        acceptTermsUse.click();
        confirmAge.click();
        signUp.click();
    }

    public void setName(String txtFirstName) {
        setText(customerName, txtFirstName);
    }

    public void setEmailId() {
        setText(emailId, emailAddress);
    }

    public void setRepeatEMail() {
        setText(repeatEMail, emailAddress);
    }

    public void setPassword(String txtPassword) {
        setText(password, txtPassword);
    }

    public void setRepeatPassword(String txtRepeatPassword) {
        setText(repeatPassword, txtRepeatPassword);
    }

    public String createEmailAddress() {
        String randomString = Utils.randomStringGenerator(6);
        return randomString + "@email.com";
    }
}
