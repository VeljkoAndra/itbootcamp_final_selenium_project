package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BasicPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasicPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean elementExists(By by) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        boolean elementExists = !driver.findElements(by).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return elementExists;
    }

}
