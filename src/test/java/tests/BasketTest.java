package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BasketPage;
import pages.ItemPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("basketTests")
public class BasketTest extends TestBase {
    BasketPage basketPage = new BasketPage();
    MainPage mainPage = new MainPage();
    ItemPage itemPage = new ItemPage();

    @Test
    @DisplayName("проверка Заголовка пустой корзины")
    @Severity(NORMAL)
    void checkEmptyBasketTest() {
        mainPage.openPage();
        basketPage.moveToBasketPage();
        basketPage.checkBasketTitle("В корзине пока пусто");
    }

    @Test
    @DisplayName("добавление товара в корзину, проверка увеличения количества товара, проверка отображения кол-ва")
    @Severity(NORMAL)
    void addItemAndCheckQuantityOnBasketItem() {
        mainPage.openPage();
        mainPage.requestInSearchInput("Успокоительное");
        mainPage.checkHeaderSearchInput("Успокоительное");
        mainPage.chooseFirstItem();
        itemPage.addItemToBasket();
        basketPage.checkNumberOnBasketIcon("1");
        basketPage.moveToBasketPage();
        basketPage.countPlusItem();
        basketPage.checkAmountInBasketSection("Товары, 2 шт.");
        basketPage.checkNumberOnBasketIcon("2");
    }
}
