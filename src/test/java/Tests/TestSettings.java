package Tests;

import Pages.FeedPage;
import Pages.SettingsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.google.common.truth.Truth.assertWithMessage;

public class TestSettings extends BaseTest{
    private final String BOT_NAME = "technoPol13";
    private SettingsPage settingsPage;

    @Disabled
    @DisplayName("Change name of the user")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void DeleteNewAvatar(String name, String path) {
        FeedPage feedPage = new FeedPage();
        SettingsPage settingsPage = feedPage.goToProfile().goToSettingsPage();
        settingsPage.changeName(name);
        assertWithMessage("Name should change").
                that(settingsPage.getName()).contains(name);
    }
    @AfterEach()
    public void tidyUp(){
        settingsPage.changeName(BOT_NAME);
    }

}
