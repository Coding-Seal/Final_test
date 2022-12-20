package Pages;

import Pages.Group.GroupsPage;
import Pages.Profile.ProfilePage;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Лента одноклассников
 */
public class FeedPage {
    private final Toolbar TOOLBAR = new Toolbar();
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement GROUPS_PAGE = $x("//*[contains(@href, '/groups')]");
    /**
     * Кнопка перехода на вкладку с видео
     */
    private final SelenideElement VIDEO_PAGE = $x("//a[@href='/video/showcase']");
    private final SelenideElement BOOKMARKS_PAGE = $x("//*[contains(@href, '/bookmarks')]");

    public VideosPage goToVideoPage() {
        VIDEO_PAGE.shouldBe(visible).click();
        return new VideosPage();
    }
    public GroupsPage goToGroupsPage() {
        GROUPS_PAGE.shouldBe(visible).click();
        return new GroupsPage();
    }
    public ProfilePage goToProfile(){
        return TOOLBAR.goToProfile();
    }
    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(6));
    }
}