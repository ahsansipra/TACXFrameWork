package client.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.pageObjects.basepages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "next-button")
    private WebElement signInWithGarmin;

    @FindBy(id = "username")
    private WebElement emailId;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-btn-signin")
    private WebElement btnLogin;

    @FindBy(id = "lnkCreateAccount")
    private WebElement btnCreateAccount;

    @FindBy(id = "gauth-widget-frame-gauth-widget")
    private WebElement loginFrame;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSignInWithGarmin(){signInWithGarmin.click();}

    public void setEmailId(String txtEmail) throws InterruptedException {
        switchToFrameForLogin(loginFrame);
        waitElementToBeVisible(emailId);
        setText(emailId, txtEmail);
    }

    public void setPassword(String txtPassword) {
        setText(password, txtPassword);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickCreateAccount() {
        btnCreateAccount.click();
    }

    public void waitCreateAccountToBeVisible() {
        switchToFrameForLogin(loginFrame);
        waitElementToBeVisible(btnCreateAccount);
        waitElementToBeVisible(btnCreateAccount);
    }

}
