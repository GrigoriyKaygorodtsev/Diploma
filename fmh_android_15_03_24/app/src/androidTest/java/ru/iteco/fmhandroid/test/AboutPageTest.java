package ru.iteco.fmhandroid.test;

import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.page.AboutPage;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.PageFunctional;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки 'О приложении' мобильного приложения 'Мобильный хоспис'")
public class AboutPageTest {
    static LoginPage loginPage = new LoginPage();
    static PageFunctional pageFunctional = new PageFunctional();
    static MainPage mainPage = new MainPage();
    private final String aboutMenuItem = "About";

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

    @Story("Переход по ссылке 'Политика конфиденциальности'")
    @Description("Перейти по ссылке 'Политика конфиденциальности' во вкладке 'О приложении' мобильного приложения 'Мобильный хоспис' и дождаться загрузки информации")
    @Test
    public void followTheLinkPrivacyPolicyTest() {
        mainPage.clickMainMenuItem(aboutMenuItem);
        pageFunctional.clickItem(AboutPage.privacyPolicyLink);
        // Ожидание загрузки текста политики
        pageFunctional.waitPage(AboutPage.privacyPolicyLink);
        AboutPage.policyText.check(matches(isDisplayed()));
        pressBack();
    }

    @Story("Переход по ссылке 'Правила использования'")
    @Description("Перейти по ссылке 'Правила использования' во вкладке 'О приложении' мобильного приложения 'Мобильный хоспис' и дождаться загрузки информации")
    @Test
    public void followTheLinkTermsOfUseTest() {
        mainPage.clickMainMenuItem(aboutMenuItem);
        pageFunctional.clickItem(AboutPage.termsOfUseLink);
        // Ожидание загрузки текста правил использования
        pageFunctional.waitPage(AboutPage.termsOfUseLink);
        AboutPage.termsOfUseText.check(matches(isDisplayed()));
        pressBack();
    }
}
