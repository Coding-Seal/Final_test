package Pages.Profile;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.image;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Cover {
    private final SelenideElement COVER = $x("//div[contains(@class, 'profile-cover_img')]");
    private final SelenideElement INSTALL_COVER = $x("//button[contains(@class, 'cover-install')]");
    private final SelenideElement COVER_DROPDOWN = $x("//ul[@class='dropdown-controls']");
    private SelenideElement UPLOAD_COVER = COVER_DROPDOWN.$x(".//input[@title='Загрузить новую']");
    // private final SelenideElement PICK_COVER = COVER_DROPDOWN.$x(".//input[@class='html5-upload-link']");
    private final SelenideElement DELETE_COVER = COVER_DROPDOWN.$x(".//a[@class='control_remove']");
    private final SelenideElement CONFIRM_DELETE_COVER = $x("//input[@value='Убрать']");
    private final SelenideElement SAVE_COVER = $x("//button[contains(@class, 'control_save')]");
    private final SelenideElement CANCEL_COVER = $x("//button[contains(@class, 'control_cancel')]");

    public Cover uploadNew(String path, boolean cancel) {
        INSTALL_COVER.shouldBe(visible).click();
        executeJavaScript("document.getElementsByClassName(\"html5-upload-link\")[1].classList.remove(\"html5-upload-link\")");
        UPLOAD_COVER.shouldBe(visible).uploadFile(new File(path));
        if (cancel) {
            CANCEL_COVER.shouldBe(visible).click();
        } else {
            SAVE_COVER.shouldBe(visible).click();
        }
        return this;
    }

    public Cover delete() {
        if (isPresent()) {
            INSTALL_COVER.shouldBe(visible).click();
            DELETE_COVER.shouldBe(visible).hover().click();
            CONFIRM_DELETE_COVER.shouldBe(visible).hover().click();
        }
        return this;
    }
    public Boolean isPresent(){ //FIXME Does literally nothing
        return COVER.has(image);
    }
    public File getImage() throws FileNotFoundException {
        return COVER.download();
    }
}
