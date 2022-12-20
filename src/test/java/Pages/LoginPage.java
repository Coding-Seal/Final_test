package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/*
 * Страница для входа сайта ok.ru
 */
public class LoginPage {

    /**
     * Необхожимые элементы на странице
     */
    private final SelenideElement INPUT_LOGIN = $x("//*[@id='field_email']");
    private final SelenideElement INPUT_PASSWORD = $x("//*[@id='field_password']");
    private final SelenideElement INPUT_BUTTON = $x("//*[@class='login-form-actions']/input");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    /**
     * Вводим логин в поле Login
     * @param login - наш логин
     */
    public LoginPage setLoginOnBlock(String login) {
        INPUT_LOGIN.shouldBe(Condition.visible).setValue(login);
        return this;
    }

    /**
     * Вводим пароль в поле Password
     * @param password - наш пароль
     */
    public LoginPage setPasswordOnBlock(String password) {
        INPUT_PASSWORD.shouldBe(Condition.visible).setValue(password);
        return this;
    }

    /**
     * Нажимаем на кнопку "Войти в одноклассники"
     */
    public void pressInputButton() {
        INPUT_BUTTON.shouldBe(Condition.visible).click();
    }
}