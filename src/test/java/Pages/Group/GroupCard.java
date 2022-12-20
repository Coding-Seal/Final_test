package Pages.Group;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class GroupCard {
    private final SelenideElement ITEM;
    private final SelenideElement CAPTION_ELEM;
    private final SelenideElement ADD_TO_BOOKMARKS = $x("//a[contains(@href, 'addBookmark')]");

    public GroupCard(SelenideElement item) {
        ITEM = item.shouldBe(visible);
        CAPTION_ELEM = ITEM.$x(".//a[@class='group-detailed-card_name']").shouldBe(visible);
    }
    public String getGroupID(){
        String href = ITEM.shouldBe(visible).getAttribute("data-l");
        assert href != null;
        return href.substring(href.lastIndexOf(",")+1);
    }
    public void addToGroupToBookMarks(){
        CAPTION_ELEM.shouldBe(visible).hover();
        ADD_TO_BOOKMARKS.shouldBe(visible).hover().click();
    }


}
