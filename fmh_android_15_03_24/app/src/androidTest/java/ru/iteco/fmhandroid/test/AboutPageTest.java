package ru.iteco.fmhandroid.test;

import static ru.iteco.fmhandroid.data.AuthorizationDataUtils.goToMainPage;

import androidx.test.espresso.Espresso;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ValidTest;
import ru.iteco.fmhandroid.page.AboutPage;
import ru.iteco.fmhandroid.page.NavigationPage;

@Epic("Внутренние страницы приложения")
@Feature("О приложении")
public class AboutPageTest extends ValidTest {

    @Before
    public void LoginType() {
        goToMainPage();
    }

    @Test
    @Story("Переход на страницу О Приложении")
    @Description("Переход на страницу О Приложении с экрана Main")
    public void goToAboutPageFromMainTest() {
        goToAboutPageFromMainTestSteps();
    }

    @Step("Вызвать меню и перейти на страницу О Приложении")
    public void goToAboutPageFromMainTestSteps() {
        NavigationPage navigationPage = new NavigationPage();
        navigationPage.goToAboutPage();

        AboutPage aboutPage = new AboutPage();
        aboutPage.waitUntilPageLoaded();
        aboutPage.checkPrivacyTitleDisplayed();
        aboutPage.checkTermsOfUseTitleDisplayed();

        Espresso.pressBack();
    }

    @Test
    @Story("Переход на страницу О Приложении")
    @Description("Переход на страницу О Приложении с экрана News")
    public void goToAboutPageFromNewsTest() {
        goToAboutPageFromNewsTestSteps();
    }

    @Step("Перейти на экран News и перейти на страницу О Приложении")
    public void goToAboutPageFromNewsTestSteps() {
        NavigationPage navigationPage = new NavigationPage();
        navigationPage.goToNewsPage();

        navigationPage.goToAboutPage();

        AboutPage aboutPage = new AboutPage();
        aboutPage.waitUntilPageLoaded();
        aboutPage.checkVersionTitleDisplayed();
        aboutPage.checkPrivacyTitleDisplayed();
        aboutPage.checkTermsOfUseTitleDisplayed();

        Espresso.pressBack();
    }
}