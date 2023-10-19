package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getErrorPopupMessageText(){
        WebElement errorElement = driver.findElement(By.cssSelector("div > div.v-snack__content > ul > li"));
        return errorElement.getText();
    }

    public void waitForErrorPopupToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__content")));
    }

    public void waitForVerifyPopUpMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".black--text.dlgVerifyAccount > i")));
    }

    public String getTextForVerifPopupMessage(){
        WebElement verifyPopupText = driver.findElement(By.cssSelector(".black--text.dlgVerifyAccount"));
        return verifyPopupText.getText();
    }

    public WebElement getVerifyPopupCloseButton(){
       return driver.findElement(By.cssSelector(".btnClose"));
    }

    public void clickOnVerifyPopupCloseButton(){
        getVerifyPopupCloseButton().click();
    }

    public void waitForMessagePopupToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div")));
    }

    public WebElement getDeletedSuccessfullyPopup(){
       return driver.findElement(By.cssSelector("#app div > div:nth-child(3) div > div.v-snack__content"));
    }

    public String getDeletedSuccessfullyText(){
        return getDeletedSuccessfullyPopup().getText();
    }
    public WebElement getPopUpMessageForSuccessfulActions() {
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }
    public void waitUntilPopUpMessageForSuccessfulProfileUpdateIsVisible () {
        wait
                .withMessage("Pop-up message for successful profile update should be visible.")
                .until(ExpectedConditions.visibilityOf(getPopUpMessageForSuccessfulActions()));
    }
    public boolean getTextFromPopUpMessageForSuccessfulProfileUpdate () {
        return getPopUpMessageForSuccessfulActions().getText().contains("Profile saved successfuly");
    }
}
