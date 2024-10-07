package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import java.util.List;

import static io.qameta.allure.SeverityLevel.NORMAL;

@Tag("mainTests")
public class MainTest extends TestBase {

    MainPage mainPage = new MainPage();

    private final List<String>
            navMenuItemsText = List.of("Адреса", "Войти", "Корзина");

    @Test
    @DisplayName("проверка текста меню на главной странице")
    @Severity(NORMAL)
    void checkHeadersUrls() {
        mainPage.openPage();
        mainPage.checkNavMenuItems(navMenuItemsText);
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
        mainPage.clickOnButtonJob();
        mainPage.checkUrl("https://www.wildberries.ru/services/trudoustroystvo");
    }
}
