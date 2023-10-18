import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities(){
        String username= "admin@admin.com";
        String password = "12345";

        loginPage.autoLogin(username,password);
        
        navPage.clickOnAdminButton();
        
        navPage.waitUntilCitiesIsVisible();
        
        navPage.clickOnCitiesButton();
        
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+ "/admin/cities", "Url should contains \"/admin/cities\" after base url.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {


        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        citiesPage.clickOnNewItemButton();

        citiesPage.waitForCreateEditCityDialogToAppear();


        WebElement cityInputField = citiesPage.getCityInputField();
        Assert.assertEquals(cityInputField.getAttribute("type"), "text");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity(){
        String city = "Kursumlija's city";

        navPage.clickOnAdminButton();
        
        citiesPage.clickOnCitiesButton();
        
        citiesPage.clickOnNewItemButton();
        
        citiesPage.waitForCreateEditCityDialogToAppear();
        
        citiesPage.enterCityName(city);
        
        citiesPage.clickOnSaveButton();
        
        messagePopUpPage.waitForSavedSuccefulyPopup();

        Assert.assertTrue(citiesPage.getMessagePopupText().contains("Saved successfully"));

    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity(){
        String oldCityName = "Kursumlija's city";
        String editedCityName = "Dubrava's city";

        navPage.clickOnAdminButton();
        
        citiesPage.clickOnCitiesButton();
        
        citiesPage.sendValueOnSearchField(oldCityName);
        
        citiesPage.waitForNumberOfRowsInTableToBe(1);
        
        citiesPage.clickOnEditButtonForFirstRow();
        
        citiesPage.enterCityName(editedCityName);
        
        citiesPage.clickOnSaveButton();
        
        messagePopUpPage.waitForSavedSuccefulyPopup();
        
        Assert.assertTrue(citiesPage.getMessagePopupText().contains("Saved successfully"));
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity(){
        String editedCityName = "Dubrava's city";
        navPage.clickOnAdminButton();
        
        citiesPage.clickOnCitiesButton();
        
        citiesPage.sendValueOnSearchField(editedCityName);

        citiesPage.waitForNumberOfRowsInTableToBe(1);

        String firstRowCityName = citiesPage.getFirstRowName();
        Assert.assertEquals(editedCityName, firstRowCityName);
    }
}
