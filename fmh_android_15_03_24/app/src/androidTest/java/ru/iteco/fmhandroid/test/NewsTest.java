package ru.iteco.fmhandroid.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.data.TestUtils.waitDisplayed;

import android.view.View;

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
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.data.AuthorizationData;
import ru.iteco.fmhandroid.data.TestUtils;
import ru.iteco.fmhandroid.page.CreatingNewsPage;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.NewsPage;
import ru.iteco.fmhandroid.page.PageFunctional;
import ru.iteco.fmhandroid.ui.AppActivity;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Проведение тестирования вкладки Новости мобильного приложения 'Мобильный хоспис'")

public class NewsTest {
    @Rule
    public ScreenshotRule screenshotRule = new ScreenshotRule(ScreenshotRule.Mode.FAILURE,
            String.valueOf(System.currentTimeMillis()));
    static LoginPage loginPage = new LoginPage();
    static PageFunctional pageFunctional = new PageFunctional();
    static NewsPage newsPage = new NewsPage();
    static CreatingNewsPage creatingNewsPage = new CreatingNewsPage();
    static MainPage mainPage = new MainPage();

    private final String NewsTitle = "Объявление";
    private final String newsMenuItem = "News";

    private final String invalidDate = "11.11.1111";
    private final String invalidTime = "26:75";
    private final String errorMessageWrongDate = "Invalid date!";
    private final String errorMessageWrongTime = "Invalid time!";

    public View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Before
    public void setUp() {
        try {
            pageFunctional.waitPage(MainPage.mainPageTag);
        } catch (Exception e) {
            pageFunctional.waitPage(LoginPage.loginPageTag);
            pageFunctional.selectField(LoginPage.loginField);
            loginPage.feelField(LoginPage.loginField, AuthorizationData.LoginType);
            pageFunctional.selectField(LoginPage.passwordField);
            loginPage.feelField(LoginPage.passwordField,AuthorizationData.PasswordType);
            pageFunctional.clickItem(LoginPage.signInButton);
            pageFunctional.waitPage(MainPage.mainPageTag);
            pageFunctional.PageIsReached(MainPage.mainPageTag);
        }
    }

    @Story("Добавление новой новости с текущей датой и временем через 'Главное меню'")
    @Description("Создание новой новости с текущей датой и временем через вкладку 'Главное меню' мобильного приложения 'Мобильный хоспис'")
    @Test
    public void addFreshNewsCurrentDataMainMenuTest() {   //добавление новой новости через главное меню с текущей датой и временем
        String newsDescription = TestUtils.getRandomNewsDescription();
        mainPage.clickMainMenuItem(newsMenuItem);
        pageFunctional.waitPage(NewsPage.newsList);
        pageFunctional.clickItem(NewsPage.editNewsButton);
        pageFunctional.clickItem(NewsPage.addNewsButton);
        creatingNewsPage.chooseCategory(NewsTitle);
        creatingNewsPage.addNewsCurrentDate();
        creatingNewsPage.addNewsCurrentTime();
        creatingNewsPage.addNewsDescription(newsDescription);
        creatingNewsPage.saveFreshNews();
        pageFunctional.waitPage(MainPage.mainPageTag);
        mainPage.clickMainMenuItem(newsMenuItem);
        pageFunctional.waitPage(NewsPage.newsList);
        newsPage.clickFreshNews();
        newsPage.findAddedNews(newsDescription);

    }

    @Story("Добавление новой новости с текущей датой и временем")
    @Description("Создание новой новости с текущей датой и временем во вкладке 'Новости' мобильного приложения 'Мобильный хоспис'")
    @Test
    public void addFreshNewsCurrentDataTest() {
        String newsDescription = TestUtils.getRandomNewsDescription();
        pageFunctional.clickItem(MainPage.allNewsHeadline); //all news
        pageFunctional.clickItem(NewsPage.editNewsButton);
        pageFunctional.clickItem(NewsPage.addNewsButton);
        creatingNewsPage.chooseCategory(NewsTitle);
        creatingNewsPage.addNewsCurrentDate();
        creatingNewsPage.addNewsCurrentTime();
        creatingNewsPage.addNewsDescription(newsDescription);
        creatingNewsPage.saveFreshNews();
        pageFunctional.waitPage(MainPage.mainPageTag);
        mainPage.clickMainMenuItem(newsMenuItem);
        pageFunctional.waitPage(NewsPage.newsList);
        newsPage.clickFreshNews();
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_description_text_view, 5000));
        newsPage.findAddedNews(newsDescription);
    }

    @Story("Фильтр новостей по категориям")
    @Description("Фильтр новостей по выбранной категории во вкладке 'Новости' с помощью кнопки 'Фильтр' мобильного приложения 'Мобильный хоспис'")
    @Test
    public void newsFilteringByCategoryTest() {
        pageFunctional.clickItem(MainPage.allNewsHeadline); //all news
        pageFunctional.waitPage(NewsPage.newsList);
        pageFunctional.clickItem(NewsPage.filterNewsButton);
        newsPage.chooseCategoryOfNews(NewsTitle);
        newsPage.selectStartFilterTimeInterval();
        newsPage.selectEndFilterTimeInterval();
        pageFunctional.clickItem(NewsPage.applyFilterButton);
        pageFunctional.waitPage(NewsPage.newsList);
        newsPage.checkNewsCategory(NewsTitle, 0);
    }


    @Story("Добавление новой новости с некорректной датой и корректным временем")
    @Description("Попытка создания новой новости с некорректной датой и корректным временем во вкладке 'Новости' мобильного приложения 'Мобильный хоспис'")
    @Test
    public void addFreshNewsInvalidDateTest() {
        String newsDescription = TestUtils.getRandomNewsDescription();
        pageFunctional.clickItem(MainPage.allNewsHeadline); //all news
        pageFunctional.clickItem(NewsPage.editNewsButton);
        pageFunctional.clickItem(NewsPage.addNewsButton);
        creatingNewsPage.chooseCategory(NewsTitle);
        creatingNewsPage.addNewsInvalidDate(invalidDate);
        creatingNewsPage.addNewsCurrentTime();
        creatingNewsPage.addNewsDescription(newsDescription);
        creatingNewsPage.saveFreshNews();
        creatingNewsPage.checkToastErrorMessage(errorMessageWrongDate, decorView);
    }

    @Story("Добавление новой новости с корректной датой и некорректным временем")
    @Description("Попытка создания новой новости с корректной датой и некорректным временем во вкладке 'Новости' мобильного приложения 'Мобильный хоспис'")
    @Test
    public void addFreshNewsInvalidTimeTest() {
        String newsDescription = TestUtils.getRandomNewsDescription();
        pageFunctional.clickItem(MainPage.allNewsHeadline); //all news
        pageFunctional.clickItem(NewsPage.editNewsButton);
        pageFunctional.clickItem(NewsPage.addNewsButton);
        creatingNewsPage.chooseCategory(NewsTitle);
        creatingNewsPage.addNewsCurrentDate();
        creatingNewsPage.addNewsInvalidTime(invalidTime);
        creatingNewsPage.addNewsDescription(newsDescription);
        creatingNewsPage.saveFreshNews();
        creatingNewsPage.checkToastErrorMessage(errorMessageWrongTime, decorView);
    }
}