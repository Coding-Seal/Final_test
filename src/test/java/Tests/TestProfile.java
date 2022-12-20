package Tests;

import Pages.FeedPage;
import Pages.Profile.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import Utility.Images;

import java.io.File;
import java.io.FileNotFoundException;

import static com.google.common.truth.Truth.assertWithMessage;

public class TestProfile extends BaseTest{
    private ProfilePage profilePage;

    @Disabled
    @DisplayName("Try different images for cover")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void installNewCover(String name, String path) throws FileNotFoundException {
        FeedPage feedPage = new FeedPage();
        profilePage = feedPage.goToProfile();
        profilePage.uploadNewCover(path, false);
//        assertWithMessage("Comparing IDs of groups (should equal)").
//                that(Images.compareImages(profilePage.getCoverImage(), new File(path))).isWithin(0.1).of(1); //TODO
    }
    @Disabled // FIXME
    @DisplayName("Cover uploading canceled")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void CancelInstallNewCover(String name, String path){
        FeedPage feedPage = new FeedPage();
        profilePage = feedPage.goToProfile();
        profilePage.uploadNewCover(path, true);
//        assertWithMessage("Cover canceled should not have image").
//                that(profilePage.coverPresent()).isFalse();
    }

    @Disabled
    @DisplayName("Try different images for avatar")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void installNewAvatar(String name, String path){
        FeedPage feedPage = new FeedPage();
        profilePage = feedPage.goToProfile();
        profilePage.uploadNewAvatar(path);
//        assertWithMessage("Comparing IDs of groups (should equal)").
//                that(Images.compareImages(,)).isWithin(0.1).of(1); //TODO
    }

    @DisplayName("Avatar deleted")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void DeleteNewAvatar(String name, String path){
        FeedPage feedPage = new FeedPage();
        profilePage = feedPage.goToProfile();
        profilePage.uploadNewAvatar(path);
        profilePage.deleteAvatar(false);
        assertWithMessage("Image should be deleted").
                that(profilePage.avatarPresent()).isFalse();
    }
    @DisplayName("Avatar deletion canceled")
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(resources = "/Users.csv", useHeadersInDisplayName = true)
    public void CancelDeleteNewAvatar(String name, String path){
        FeedPage feedPage = new FeedPage();
        profilePage = feedPage.goToProfile();
        profilePage.uploadNewAvatar(path);
        profilePage.deleteAvatar(true);
        assertWithMessage("Cover canceled should not have image").
                that(profilePage.avatarPresent()).isTrue();
    }
    @AfterEach()
    public void tidyUp(){
        profilePage.deleteRecentImages();
    }
}
