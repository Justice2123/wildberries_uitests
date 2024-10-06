package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    private final SelenideElement
            loginButton = $("#requestCode"),
            errorPhone = $(".j-error-full-phone"),
            phoneInput = $(".input-item"),
            formMobileCodes = $(".form-block__dropdown"),
            menuMobileCode = $(".drop-select", 4),
            mobileCode = $(".form-block__mask"),
            loginTitle = $(".sign-in-page__title");

    @Step("ввод некорректного номера телефона")
    public AuthorizationPage setUnsuccessfulPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    @Step("нажатие на кнопку Отправить код")
    public AuthorizationPage pushedLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("проверка текста ошибки")
    public AuthorizationPage checkErrorMessage(String value) {
        errorPhone.shouldHave(text(value));
        return this;
    }

    @Step("Проверка заголовка окна авторизации")
    public AuthorizationPage checkLoginTitle(String value) {
        loginTitle.shouldHave(text(value));
        return this;
    }

    @Step("открытие меню с кодами стран")
    public AuthorizationPage openMenuMobileCode() {
        formMobileCodes.click();
        return this;
    }

    @Step("выбор кода")
    public AuthorizationPage choosingMobileCode(String value) {
        menuMobileCode.find(byText(value)).click();
        return this;
    }

    @Step("проверка правильности отображения нужного кода страны")
    public AuthorizationPage checkMobileCode(String value) {
        mobileCode.shouldHave(text(value));
        return this;
    }
}
