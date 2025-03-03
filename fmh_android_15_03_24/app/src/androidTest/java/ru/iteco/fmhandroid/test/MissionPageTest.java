package ru.iteco.fmhandroid.test;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.rules.ScreenshotRule;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.data.AuthorizationData;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.MissionPage;
import ru.iteco.fmhandroid.page.PageFunctional;
import ru.iteco.fmhandroid.ui.AppActivity;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("проведения функционального тестирования вкладки 'Цитаты' мобильного приложения 'Мобильный хоспис'")
public class MissionPageTest {

    static LoginPage loginPage = new LoginPage();
    static MissionPage quotesPage = new MissionPage();
    static PageFunctional pageFunctional = new PageFunctional();

    private final String title = "\"Хоспис в своем истинном понимании - это творчество\"";
    private final String description = "Нет шаблона и стандарта, есть только дух, который живет " +
            "в разных домах по-разному. Но всегда он добрый, любящий и помогающий.";
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));


    @Before
    public void setUp() {
        try {
            pageFunctional.waitPage(MainPage.mainPageTag);
        } catch (Exception e) {
            pageFunctional.waitPage(LoginPage.loginPageTag);
            pageFunctional.selectField(LoginPage.loginField);
            loginPage.feelField(LoginPage.loginField, AuthorizationData.LoginType);
            pageFunctional.selectField(LoginPage.passwordField);
            loginPage.feelField(LoginPage.passwordField, AuthorizationData.PasswordType);
            pageFunctional.clickItem(LoginPage.signInButton);
            pageFunctional.waitPage(MainPage.mainPageTag);
            pageFunctional.PageIsReached(MainPage.mainPageTag);
        }
    }
    @Test
    @Story("Открытие цитаты")
    @Description("Открытие цитаты в развернутом виде во вкладке 'Цитаты' мобильного приложения 'Мобильный хоспис'")
    public void openingMissionPageTest() {
        pageFunctional.clickItem(MainPage.quotesButton);
        pageFunctional.waitPage(MissionPage.missionLogo);
        quotesPage.openQuote(0);
        quotesPage.checkTextQuote(description);
    }
}