package Pages.Profile;

import Pages.SettingsPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement GO_TO_SETTINGS = $x("//a[@href='/settings']");
    private final Cover COVER = new Cover();
    private final Avatar AVATAR = new Avatar();

    public ProfilePage() {
        check();
    }

    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(6));
    }

    public ProfilePage uploadNewCover(String path, boolean cancel) {
        COVER.uploadNew(path, cancel);
        return this;
    }

    public ProfilePage deleteCover() {
        COVER.delete();
        return this;
    }
    public Boolean coverPresent(){
        return COVER.isPresent();
    }
    public ProfilePage uploadNewAvatar(String path) {
        AVATAR.uploadNew(path);
        return this;
    }

    public ProfilePage deleteAvatar(boolean cancel) {
        AVATAR.delete(cancel);
        return this;
    }
    public Boolean avatarPresent(){
        refresh();
        check();
        return AVATAR.isPresent();
    }
    public void deleteRecentImages(){
        ElementsCollection recentImages;
        SelenideElement moreButton = $x("//span[text()='Ещё']");
        SelenideElement deleteRecentImage = $x("//span[text()='Удалить фотографию']");
        SelenideElement crossButton = $x("//button[@class=\"control__4rmea\"]");
        do {
            refresh();
            check();
            recentImages = $$x("//img[@class='photo_img']");
            for (SelenideElement recentImage : recentImages) {
                recentImage.shouldBe(visible).click();
                moreButton.shouldBe(visible).click();
                deleteRecentImage.shouldBe(visible).click();
                crossButton.shouldBe(visible).click();
            }
        }
        while (recentImages.size() > 0);
    }

    public File getCoverImage() throws FileNotFoundException {
        return COVER.getImage();
    }
    public SettingsPage goToSettingsPage() {
        GO_TO_SETTINGS.shouldBe(visible).click();
        return new SettingsPage();
    }

}