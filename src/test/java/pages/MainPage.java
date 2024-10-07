package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.containExactTextsCaseSensitive;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    private final SelenideElement
            searchInput = $("#searchInput"),
            productCartList = $(".product-card-list article", 0),
            headerAfterRequestSearchInput = $(".searching-results__title"),
            loginIcon = $(".j-main-login"),
            jobButton = $(".simple-menu__link--employment"),
            mainPageBanner = $(".main-page__banner-info"),
            jobPageButton = $(byTagAndText("a", "Работа в Wildberries"));

    private final ElementsCollection
            navMenuItems = $$x("//div[@id='basketContent']/div/a");

    @Step("открытие главной страницы")
    public void openPage() {
        open("");
    }

    @Step("переход на страницу Авторизации")
    public MainPage moveLoginPage() {
        loginIcon.click();
        return this;
    }

    @Step("проверка загрузки банера")
    public MainPage bannerShouldBeVisible() {
        mainPageBanner.shouldBe(visible);
        return this;
    }

    @Step("запрос в поисковом окне")
    public MainPage requestInSearchInput(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    @Step("проверка Заголовка {value}")
    public MainPage checkHeaderSearchInput(String value) {
        headerAfterRequestSearchInput.shouldHave(text(value));
        return this;
    }

    @Step("выбор первого товара")
    public MainPage chooseFirstItem() {
        productCartList.click();
        return this;
    }

    @Step("переход на страницу 'Работа в Wildberries'")
    public MainPage jobPage() {
        jobPageButton.click();
        return this;
    }

    @Step("проверка кнопки 'Работа в Wildberries'")
    public MainPage checkEmploymentButton() {
        jobButton.shouldBe(visible).click();
        return this;
    }

    @Step("проверка url")
    public MainPage checkUrl(String value) {
        webdriver().shouldHave(currentFrameUrl(value));
        return this;
    }

//    @Step("проверка корректного отображения пунктов меню на главной странице")
//    public MainPage checkNavMenuItems(List<String> items) {
//        for (int i = 0; i < items.size(); i++) {
//            assertEquals(items.get(i), navMenuItems.get(i).text());
//        }
//        return this;
//    }

    @Step("проверка корректного отображения пунктов меню на главной странице")
    public MainPage checkNavMenuItems(List<String> array) {
         navMenuItems.should(containExactTextsCaseSensitive(array));
        return this;
    }

}

