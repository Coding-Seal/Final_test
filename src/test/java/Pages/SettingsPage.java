package Pages;

import Pages.Profile.ProfilePage;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class SettingsPage {
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement PROFILE_FORM = $x("//a[contains(@data-l, 'profile_form')]");
    private final SelenideElement NAME_FIELD = $x("//input[@id='field_name']");
    private final SelenideElement COMPACT_PROFILE = $x("//a[constains(@class, 'compact-profile')]");
    private final SelenideElement SAVE_CHANGES = $x("//input[@value=\"Сохранить\"]");


    public SettingsPage(){
        check();
    }
    public SettingsPage changeName(String name){
        PROFILE_FORM.shouldBe(visible).click();
        NAME_FIELD.shouldBe(visible).setValue(name);
        SAVE_CHANGES.shouldBe(visible).click();
        return this;
    }
    public String getName(){
        refresh();
        check();
        return COMPACT_PROFILE.shouldBe(visible).text().split(" ")[0];
    }
    public ProfilePage goToProfilePage(){
        COMPACT_PROFILE.shouldBe(visible).click();
        return new ProfilePage();
    }

    public void check() {
        LAST_LOADED_ITEM.shouldHave(image, Duration.ofSeconds(6));
    }
}
