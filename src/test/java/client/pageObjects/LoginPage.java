package client.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.pageObjects.basepages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "next-button")
    private WebElement signInOption;

    @FindBy(id = "username")
    private WebElement emailID;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-btn-signin")
    private WebElement loginButton;

    @FindBy(id = "lnkCreateAccount")
    private WebElement createAccountButton;

    @FindBy(id = "gauth-widget-frame-gauth-widget")
    private WebElement loginFrame;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickSignInWithGarmin(){
        signInOption.click();}

    public void setEmailID(String txtEmail) throws InterruptedException {
        switchToFrameForLogin(loginFrame);
        waitElementToBeVisible(emailID);
        setText(emailID, txtEmail);
    }

    public void setPassword(String txtPassword) {
        setText(password, txtPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public void waitCreateAccountToBeVisible() {
        switchToFrameForLogin(loginFrame);
        waitElementToBeVisible(createAccountButton);
        waitElementToBeVisible(createAccountButton);
    }

}
