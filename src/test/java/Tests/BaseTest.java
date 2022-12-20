package Tests;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


/**
 * Базовый класс для всех тестов
 */
abstract public class BaseTest {
    private static final String OK_BASE_URL = "https://ok.ru/";
    static final String LOGIN = "technoPol13";
    private static final String PASSWORD = "technoPolis2022";
    /**
     * Инициализация браузера
     */
    public void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;

    }

    @BeforeEach
    public void initTest() {
        init();
        LoginPage loginPage = new LoginPage(OK_BASE_URL);
        loginPage.setLoginOnBlock(LOGIN).setPasswordOnBlock(PASSWORD).pressInputButton();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}