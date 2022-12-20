package Pages.Group;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsPage {
    private final SelenideElement LAST_LOADED_ITEM = $x("//div[@class='mailru-visibility-check']");
    private final SelenideElement BACK_TO_FEED_BUTTON = $x("//*[contains(@href, '/feed')]");
    private final List<GroupCard> GROUP_CARDS;
    public GroupsPage() {
        check();
        ElementsCollection cardElements = $$x("//div[@class='ucard-v __h __none-border soh-s __trimmed']");
        GROUP_CARDS = cardElements.asFixedIterable().stream().map(GroupCard::new).collect(Collectors.toList());
    }

    public String getFirstGroupID() {
        return GROUP_CARDS.get(0).getGroupID();
    }
    public GroupsPage addFirstGroupToBookmarks(){
        GROUP_CARDS.get(0).addToGroupToBookMarks();
        return this;
    }

    public void goToFeedPage() {
        BACK_TO_FEED_BUTTON.shouldBe(visible).click();
    }
    public void check() {
        LAST_LOADED_ITEM.shouldBe(visible, Duration.ofSeconds(4));
    }
}
