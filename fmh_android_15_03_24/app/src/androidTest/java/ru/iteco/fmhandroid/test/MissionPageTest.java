package ru.iteco.fmhandroid.test;

import static ru.iteco.fmhandroid.data.AuthorizationDataUtils.goToMainPage;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import ru.iteco.fmhandroid.ValidTest;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.MissionPage;

@Epic("Внутренние страницы приложения")
@Feature("Цитаты")
public class MissionPageTest extends ValidTest {
    @Before
    public void LoginType() {
        goToMainPage();
    }

    @Test
    @Story("Переход на страницу Цитаты")
    @Description("Переход на страницу Цитаты с экрана Main")
    public void goToAboutPageTest() {
        Allure.step("Перейти на экран Main");
        MainPage mainPage = new MainPage();

        mainPage.waitUntilPageLoaded();
        mainPage.validatePageLoaded();

        Allure.step("Перейти на страницу с цитатами");
        mainPage.goToMissionPage();

        MissionPage missionPage = new MissionPage();
        missionPage.waitUntilPageLoaded();
        missionPage.validatePageLoaded();
    }
}