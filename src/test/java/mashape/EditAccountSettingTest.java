package mashape;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Silvia Coca on 3/20/2015.
 */
public class EditAccountSettingTest {
    String expectedEmail = "scoca@pros.com";
    String password = "aleisa08";
    Dashboard dashboard;
    String userEdited = "Aleisa08 Edited";
    ContextMenuSettings contextMenuSettings;
    AccountContainer accountContainer;

    @BeforeMethod
    public void setUp() {
        Home homepage = new Home();
        dashboard = homepage.loginAs(expectedEmail, password);
    }

    @Test
    public void EditAccountSetting() {

        contextMenuSettings = dashboard.clickSettings();
        SettingContainer settingContainer = contextMenuSettings.clickSettingsMenu();
        accountContainer = settingContainer.clickAccountTab();
        accountContainer.clickEditLink(userEdited);
        accountContainer.clickSaveAccount();

        Assert.assertTrue(accountContainer.isUserEditedDisplayed(userEdited));
        accountContainer.closedModalDialog();
    }

    @AfterMethod
    public void tearDown() {
        contextMenuSettings = dashboard.clickSettings();
        SettingContainer settingContainer = contextMenuSettings.clickSettingsMenu();
        accountContainer = settingContainer.clickAccountTab();
        accountContainer.clickEditLink("Aleisa08");
        accountContainer.clickSaveAccount();
        accountContainer.closedModalDialog();

    }


}
