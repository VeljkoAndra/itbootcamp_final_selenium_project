import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES(){
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnSpanishLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Página de aterrizaje",
                "Text in header should be 'Página de aterrizaje'.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickOnEnglishLanguage();
        Assert.assertEquals(navPage.getHeaderText(), "Landing", "Text in header should be 'Landing'.");
    }
}
