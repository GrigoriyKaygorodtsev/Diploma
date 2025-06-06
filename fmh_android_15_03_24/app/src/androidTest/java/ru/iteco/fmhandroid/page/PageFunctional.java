package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.data.TestUtils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.Allure;

public class PageFunctional {

    public void selectField(int field) {
        Allure.step("Выбор поля ввода данных");
        onView(withId(field)).perform(click());
    }

    public void clickItem(int item) {
        Allure.step("Клик по выбранному элементу на странице");
        onView(withId(item)).perform(click());
    }

    public void PageIsReached(int pageMarker) {
        Allure.step("Проверка, что отображается страница с указанным элементом");
        ViewInteraction marker = onView(withId(pageMarker)).check(matches(isDisplayed()));
    }

    public void waitPage(int pageMarker) {
        Allure.step("Ожидание загрузки страницы с указанным элементом");
        onView(isRoot()).perform(waitDisplayed(pageMarker,15000));
    }
}
