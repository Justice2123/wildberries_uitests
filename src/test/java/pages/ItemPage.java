package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ItemPage {
    private final SelenideElement
        orderForFixedButton = $(".order__for-fixed",1),
        headerSizesItemWindow = $(".popup__header"),
        articleNumber = $(".product-params__table");

    @Step("добавление товара в корзину")
    public ItemPage addedItemToBasket() {
        orderForFixedButton.click();
        return this;
    }

    @Step("проверка Артикула на странице товара")
    public ItemPage checkArticleNumber(String value) {
        articleNumber.shouldHave(text(value));
        return this;
    }

    @Step("проверка текста кнопки В избраное")
    public ItemPage checkTextButton(String value) {
        orderForFixedButton.shouldHave(text(value)).click();
        return this;
    }

    @Step("проверка заголовка модального окна, если товар отсутствует")
    public ItemPage checkHeaderSizesItemWindow(String value) {
        headerSizesItemWindow.shouldHave(text(value));
        return this;
    }
}
