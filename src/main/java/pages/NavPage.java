package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.cssSelector(".v-btn__content >.mdi-earth"));
    }
    public void clickOnLanguageButton(){
        getLoginButton().click();
    }
    public WebElement getEnglishLanguage(){
        return driver.findElement(By.cssSelector(".btnLocaleActivation"));
    }
    public void clickOnEnglishLanguage(){
        getEnglishLanguage().click();
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.cssSelector(" div.v-toolbar__items > a:nth-child(3) > span"));
    }
    public void clickOnLoginButton () {
        getLoginButton().click();
    }
}
