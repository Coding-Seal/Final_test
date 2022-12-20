package Pages.Profile;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Avatar {
    private final SelenideElement AVATAR = $x("//img[contains(@id, 'viewImage')]"); // TODO
    private final SelenideElement UPLOAD_AVATAR = $x("//input[@title=\"Добавить фото\"]");
    private final SelenideElement CONFIRM_AVATAR = $x("//div[contains(@class, 'change-avatar-controls')]//button");
    private final SelenideElement DELETE_AVATAR = $x("//div[@tsid=\"avatarShortcut\"]//div[text()='Убрать фото профиля']");
    private final SelenideElement CONFIRM_DELETE_AVATAR = $x("//span[text()='Убрать']");
    private final SelenideElement CANCEL_DELETE_AVATAR = $x("//span[text()='Отменить']");

    public Avatar uploadNew(String path) {
        if (! isPresent()) {
            executeJavaScript("document.getElementsByClassName(\"html5-upload-link\")[4].classList.remove(\"html5-upload-link\")");
            UPLOAD_AVATAR.uploadFile(new File(path));
            CONFIRM_AVATAR.shouldBe(visible).click();
        }
        return this;
    }

    public Avatar delete(boolean cancel) {
        AVATAR.shouldBe(visible).hover();
        DELETE_AVATAR.shouldBe(visible).hover().click();
        if (cancel) {
            CANCEL_DELETE_AVATAR.shouldBe(visible).click();
        } else {
            CONFIRM_DELETE_AVATAR.shouldBe(visible).click();
        }
        return this;
    }
    public Boolean isPresent(){
        return AVATAR.is(visible);
    }
}
