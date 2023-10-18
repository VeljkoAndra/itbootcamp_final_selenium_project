import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LogInTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
         public void visitsTheHomePage(){
         navPage.clickOnLanguageButton();
         navPage.clickOnEnglishLanguage();
         navPage.clickOnLoginNavButton();
         Assert.assertEquals(driver.getCurrentUrl(),
                    baseUrl + "/login");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
        public void checksInputTypes(){
        navPage.clickOnLoginNavButton();
        String attributeEmail = loginPage.getEmailInput().getAttribute("type");
        String attributePassword =loginPage.getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The email field should have the value \"email\" in the \"type\" attribute." );
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        loginPage.autoLogin(email,password);
        messagePopUpPage.waitForErrorPopupToBeVisible();

        String errorMessage = messagePopUpPage.getErrorPopupMessageText();
        Assert.assertEquals(errorMessage, "User does not exists", "Message from popup should be like expected message");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }

    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";
        loginPage.autoLogin(email, password);
        messagePopUpPage.waitForErrorPopupToBeVisible();

        String errorMessage = messagePopUpPage.getErrorPopupMessageText();
        Assert.assertEquals(errorMessage, "Wrong password", "Message from popup should be contains \"Wrong password\"" );

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }

    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void correctLogin(){
        String email = "admin@admin.com";
        String password = "12345";

        loginPage.autoLogin(email,password);
        wait
                .withMessage("Url should be for home page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void logout(){
        navPage.waitUntilLogoutButtonIsVisible();
        navPage.clickOnLogoutButton();
    }

}
