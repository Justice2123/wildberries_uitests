package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("loginTests")
@Tag("wildberriesTests")
public class LoginTest extends TestBase {

    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test
    @DisplayName("неудачная попытка авторизации с коротким номером")
    @Severity(NORMAL)
    void checkIncorrectPhoneNumberAuthorisation() {
        mainPage.openPage();
        mainPage.clickLoginIcon();
        authorizationPage.setPhone("7777");
        authorizationPage.clickLoginButton();
        authorizationPage.checkErrorMessage("Некорректный формат номера");
    }

    @Test
    @DisplayName("проверка кода мобильного телефона")
    @Severity(NORMAL)
    void checkCodeMobileTest() {
        mainPage.openPage();
        mainPage.clickLoginIcon();
        authorizationPage.openMenuMobileCode();
        authorizationPage.chooseMobileCode("Киргизия +996");
        authorizationPage.checkMobileCode("+996 ");
    }

    @Test
    @DisplayName("проверка заголовка Авторизации")
    @Severity(NORMAL)
    void loginPageTest() {
        mainPage.openPage();
        mainPage.clickLoginIcon();
        authorizationPage.checkLoginTitle("Войти или создать профиль");
    }
}
