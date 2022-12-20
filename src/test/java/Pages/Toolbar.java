package Pages;

import static com.codeborne.selenide.Condition.visible;

import Pages.Profile.ProfilePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Toolbar {
    private final SelenideElement BAR = $x("//div[@class='toolbar_c']").shouldBe(visible);
    private final SelenideElement LOGO = BAR.$x(".//div[@class='toolbar_logo_img']").shouldBe(visible);
    private final SelenideElement DISCUSSIONS = BAR.$x(".//div[@aria-label='Обсуждения']").shouldBe(visible);
    private final SelenideElement NOTIFICATIONS = BAR.$x(".//div[@aria-label='Оповещения']").shouldBe(visible);
    private final SelenideElement GUESTS = BAR.$x(".//a[@aria-label='Гости']").shouldBe(visible);
    private final SelenideElement MARKS = BAR.$x(".//span[@aria-label='События']").shouldBe(visible);
    private final SelenideElement VIDEOS = BAR.$x(".//a[@aria-label='Видео']").shouldBe(visible);
    private final SelenideElement MUSIC = BAR.$x(".//div[@aria-label='Музыка']").shouldBe(visible);
    private final SelenideElement VK = BAR.$x(".//span[contains(@class, 'vk_ecosystem')]").shouldBe(visible);
    private final SelenideElement SEARCH = BAR.$x(".//input[@*='Искать на сайте']").shouldBe(visible);
    private final SelenideElement PROFILE_BUTTON = BAR.$x(".//div[contains(@class, 'ucard-mini')]").shouldBe(visible);
    private final SelenideElement TO_PROFILE = $x("//div[contains(@class, 'user_name')]");


    public FeedPage goToFeed() {
        LOGO.shouldBe(visible).click();
        return new FeedPage();
    }
    public void goToDiscussions() {
        DISCUSSIONS.shouldBe(visible).click();
    }
    public void goToGuests() {
        GUESTS.shouldBe(visible).click();
    }
    public void goToMarks() {
        MARKS.shouldBe(visible).click();
    }
    public void goToVideos() {
        VIDEOS.shouldBe(visible).click();
    }
    public void openMusic() {
        MUSIC.shouldBe(visible).click();
    }
    public void openVK() {
        VK.shouldBe(visible).click();
    }

    public ProfilePage goToProfile() {
        PROFILE_BUTTON.shouldBe(visible).click();
        TO_PROFILE.shouldBe(visible).hover().click();
        return new ProfilePage();
    }
}
