import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class SignupTests extends BasicTest {
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage(){
        navPage.clickOnSingupButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "Urls should be similar.");
    }

}
