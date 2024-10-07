package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private final SelenideElement
            basketTitle = $(".basket-empty__title"),
            countPlus = $(".count__plus"),
            numberOnBasket = $(".navbar-pc__notify"),
            basketIcon = $(".j-item-basket"),
            priceInBasketSection = $(".b-top__count");

    @Step("проверка отображения количества товара на картинке Корзины")
    public BasketPage checkNumberOnBasketIcon(String value) {
        numberOnBasket.shouldHave(text(value));
        return this;
    }

    @Step("переход на страницу Корзины")
    public BasketPage moveToBasketPage() {
        basketIcon.click();
        return this;
    }

    @Step("увеличение количества товара в корзине")
    public BasketPage countPlusItem() {
        countPlus.click();
        return this;
    }

    @Step("проверка количества товара в секции заказа")
    public BasketPage checkAmountInBasketSection(String value) {
        priceInBasketSection.shouldHave(text(value));
        return this;
    }

    @Step("проверка Заголовка пустой корзины")
    public BasketPage checkBasketTitle(String value) {
        basketTitle.shouldHave(text(value));
        return this;
    }
}
