package client.pageObjects;

import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.ByAngularModel;
import commonUtils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import client.pageObjects.basepages.BasePage;

public class CreateWorkoutPage extends BasePage {

    private static Logger logger = LoggerFactory.getLogger(CreateWorkoutPage.class.getName());
    @ByAngularButtonText.FindBy(buttonText = "Power")
    private WebElement power;

    @ByAngularButtonText.FindBy(buttonText = "Distance")
    private WebElement distance;

    @ByAngularButtonText.FindBy(buttonText = "Continue")
    private WebElement btnContinue;

   // @FindBy(xpath = "//*[@id='duration-group']/div[2]/button[1]")
    @FindBy(className = "increase-indicator-value-control")
    private WebElement increaseDistance;

  //  @FindBy(xpath = "//*[@id='duration-group']/div[2]/button[2]")
    @FindBy(className = "decrease-indicator-value-control")
    private WebElement decreaseDistance;

    @FindBy(xpath = "//*[@id='duration-group']/div[1]/span[1]")
    private WebElement distanceValue;

    @FindBy(className = "save-btn")
    private WebElement btnSave;

    @ByAngularModel.FindBy(model = "vm.fieldValue")
    private WebElement inputTitle;

    @ByAngularButtonText.FindBy(buttonText = "Save")
    private WebElement saveTitle;

    @FindBy(tagName = "md-dialog")
    private WebElement alertDialog;

    @FindBy(id = "tacx-dialog-cancel")
    private WebElement alertCancel;

    private String txtTitle;

    public CreateWorkoutPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void clickPower() {
        waitElementToBeVisible(power);
        power.click();
    }

    public void clickDistance() {
        waitElementToBeVisible(distance);
        distance.click();
    }

    public void clickContinue() {
        waitElementToBeVisible(btnContinue);
        btnContinue.click();
    }

    public void clickSaveBtn() {
        btnSave.click();
    }

    public void setTitle() {
        txtTitle = Utils.randomStringGenerator(6);
        System.out.println(txtTitle);
        inputTitle.sendKeys(txtTitle);
    }

    public String getTitle() {
        return txtTitle;
    }

    public void clickSaveTitle() {
        waitElementToBeVisible(saveTitle);
        saveTitle.click();

    }

    public void clickDistanceIndicator(Integer distanceNum) throws InterruptedException {
        switchToAlertAndCancel();
        Integer value = getDistanceValue();
        waitElementToBeVisible(increaseDistance);
        if (distanceNum > value) {
            for (double i = value; i <= distanceNum; i += 0.1) {
                increaseDistance.click();
            }
        } else if (distanceNum < value) {
            for (double d = value; d > distanceNum; d -= 0.1) {
                decreaseDistance.click();
            }
        }
    }

    private Integer getDistanceValue() {
        String txtValue = distanceValue.getText();
        return Integer.valueOf(txtValue.substring(0, 2));
    }

    public void switchToAlertAndCancel() throws InterruptedException {
        waitElementToBeVisible(alertDialog);
        if (alertDialog.isDisplayed()) {
            alertCancel.click();
        }
    }
}
