package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AuthorizationPage;
import pages.BasketPage;
import pages.ItemPage;
import pages.MainPage;

import java.util.List;

import static io.qameta.allure.SeverityLevel.NORMAL;


@Tag("wildberriesTests")

public class WildberriesTests extends TestBase {


    private List<String>
            navMenuItemsText = List.of("Адреса", "Войти", "Корзина");

    BasketPage basketPage = new BasketPage();
    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    ItemPage itemPage = new ItemPage();

    @Test
    @DisplayName("проверка Заголовка пустой корзины")
    @Severity(NORMAL)
    void checkEmptyBasketTest() {
        mainPage.openPage();
        basketPage.movingToBasketPage();
        basketPage.checkBasketTitle("В корзине пока пусто");
    }

    @Test
    @DisplayName("проверка кода мобильно телефона")
    @Severity(NORMAL)
    void checkCodeMobileTest() {
        mainPage.openPage();
        mainPage.movingLoginPage();
        authorizationPage.openMenuMobileCode();
        authorizationPage.choosingMobileCode("Киргизия +996");
        authorizationPage.checkMobileCode("+996 ");
    }

    @Test
    @DisplayName("проверка кнопки 'Работа в Wildberries'")
    @Severity(NORMAL)
    void employmentButtonTest() {
        mainPage.openPage();
        mainPage.checkEmploymentButton();
    }

    @Test
    @DisplayName("проверка правильности ссылки страницы Работа в Wildberries")
    @Severity(NORMAL)
    void checkUrlWorkPageTest() {
        mainPage.openPage();
        mainPage.jobPage();
        mainPage.checkUrl("https://www.wildberries.ru/services/trudoustroystvo");
    }

    @Test
    @DisplayName("проверка заголовка Авторизации")
    @Severity(NORMAL)
    void loginPageTest() {
        mainPage.openPage();
        mainPage.movingLoginPage();
        authorizationPage.checkLoginTitle("Войти или создать профиль");
    }

    @Test
    @DisplayName("проверка текста header menu")
    @Severity(NORMAL)
    void checkHeadersUrls() {
        mainPage.openPage();
        mainPage.checkNavMenuItems(navMenuItemsText);
    }

    @ValueSource(strings = {
            "163571936",
            "175440928"
    })
    @ParameterizedTest(name = "После нажатия на кнопку 'В избраное' должно появится модальное окно с выбором размера")
    @Severity(NORMAL)
    void checkModalWindowWithSizesIfNoGoods(String articleNumber) {
        mainPage.openPage();
        mainPage.requestInSearchInput(articleNumber);
        itemPage.checkArticleNumber(articleNumber);
        itemPage.checkTextButton("В избранное");
        itemPage.checkHeaderSizesItemWindow("Выберите размер");
    }

    @Test
    @DisplayName("добавление товара в корзину, проверка увелечения количества товара, проверка отображения кол-ва")
    @Severity(NORMAL)
     void addedItemAndCheckQuantityOnBasketItem() {
        mainPage.openPage();
        mainPage.requestInSearchInput("Успокоительное");
        mainPage.cheakHeaderSearchInput("Успокоительное");
        mainPage.chooseFirstItem();
        itemPage.addedItemToBasket();
        basketPage.checkNumberOnBasketIcon("1");
        basketPage.movingToBasketPage();
        basketPage.countingPlusItem();
        basketPage.checkPriceInBasketSection();
        basketPage.checkNumberOnBasketIcon("2");
    }

    @Test
    @DisplayName("неудачная попытка авторизации с коротким номером")
    @Severity(NORMAL)
     void checkIncorrectPhoneNumberAuthorisation() {
        mainPage.openPage();
        mainPage.movingLoginPage();
        authorizationPage.setUnsuccessfulPhone("7777");
        authorizationPage.pushedLoginButton();
        authorizationPage.checkErrorMessage("Некорректный формат номера");

    }
}
