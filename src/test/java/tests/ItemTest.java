package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.Tag;
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

    @ValueSource(strings = {
            "163571936",
            "175440928"
    })
    @ParameterizedTest(name = "после нажатия на кнопку 'В избраное' должно появится модальное окно с выбором размера")
    @Severity(NORMAL)
    void checkModalWindowWithSizesIfNoGoods(String articleNumber) {
        mainPage.openPage();
        mainPage.requestInSearchInput(articleNumber);
        itemPage.checkArticleNumber(articleNumber);
        itemPage.checkTextButton("В избранное");
        itemPage.checkHeaderSizesItemWindow("Выберите размер");
    }
}
