package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.AuthorizationPage;
import pages.BasketPage;
import pages.ItemPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class ItemTest extends TestBase{

    MainPage mainPage = new MainPage();
    ItemPage itemPage = new ItemPage();

    @ValueSource(strings = {
            "163571936",
            "175440928"
    })
    @ParameterizedTest(name = "После нажатия на кнопку 'В избраное' должно появится модальное окно с выбором размера")
    @Severity(NORMAL)
    void checkModalWindowWithSizesIfNoGoods(String articleNumber) {
        mainPage.openPage();
        mainPage.bannerShouldBeVisible();
        mainPage.requestInSearchInput(articleNumber);
        itemPage.checkArticleNumber(articleNumber);
        itemPage.checkTextButton("В избранное");
        itemPage.checkHeaderSizesItemWindow("Выберите размер");
    }
}
