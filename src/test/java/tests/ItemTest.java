package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ItemPage;
import pages.MainPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("itemTests")
@Tag("wildberriesTests")
public class ItemTest extends TestBase {

    MainPage mainPage = new MainPage();
    ItemPage itemPage = new ItemPage();

    @Test
    @DisplayName("после нажатия на кнопку 'В избраное' должно появится модальное окно с выбором размера")
    @Severity(NORMAL)
    void checkModalWindowWithSizesIfNoGoods() {
        mainPage.openPage();
        mainPage.expectLoadingContainer();
        mainPage.requestInSearchInput("163571936");
        itemPage.checkArticleNumber("163571936");
        itemPage.checkTextButton("В избранное");
        itemPage.checkHeaderSizesItemWindow("Выберите размер");
    }
}
