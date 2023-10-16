import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LogInTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
         public void visitsTheHomePage(){
         navPage.getLanguageButton();
         navPage.clickOnLanguageButton();
         navPage.getEnglishLanguage();
         navPage.clickOnEnglishLanguage();
         navPage.getLoginButton();
         navPage.clickOnLoginButton();
         Assert.assertEquals(driver.getCurrentUrl(),
                    baseUrl + "/login");
    }



}
