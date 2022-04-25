package client.pageObjects;

import commonUtils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import client.pageObjects.basepages.BasePage;

import java.util.List;

public class WorkoutsPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'workouts-cards']/div")
    private List<WebElement> workOutsList;

  //  @FindBy(id = "workouts-cards")
  //  private WebElement workoutCards;

    public WorkoutsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean ifTitleFoundOnWorkout(String title) {
        String active = "notificationType == 'uploadWorkout'";
        WebElement state = webDriver.findElement(By.xpath("//div[@ng-if=\"" + active + "\"]"));
        waitElementToBeInvisible(state);
        return Utils.isListContainsValue(workOutsList, title);
    }
}
