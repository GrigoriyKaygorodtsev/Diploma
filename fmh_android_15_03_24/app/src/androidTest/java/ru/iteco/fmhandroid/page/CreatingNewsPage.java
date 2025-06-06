package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import android.view.View;

import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.CoreMatchers;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class CreatingNewsPage {

    private static final int saveNewsButton = R.id.save_button;   //сохранить новую новость
    private static final int categoryButton = R.id.text_input_end_icon;//кнопка выпадающего меню категория
    private static final int datePublication = R.id.news_item_publish_date_text_input_edit_text;//дата публикации
    private static final int timePublication = R.id.news_item_publish_time_text_input_edit_text;//время публикации
    private static final int descriptionField = R.id.news_item_description_text_input_edit_text;//поле для описания новости
    private static final int okButton = android.R.id.button1; //кнопка ОК

    static PageFunctional pageFunctional = new PageFunctional();

    public void chooseCategory(String title) {
        Allure.step("Выбрать категорию новости: " + title);
        onView(allOf(withId(categoryButton), withContentDescription("Show dropdown menu"))).perform(click());
        onView(withText(title))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());
    }

    public void addNewsCurrentDate() {
        Allure.step("Выбрать текущую дату новой Новости");
        pageFunctional.clickItem(datePublication);
        pageFunctional.clickItem(okButton);
    }

    public void addNewsCurrentTime() {
        Allure.step("Выбрать текущее время новой Новости");
        onView((withId(timePublication))).perform(click());
        onView((withId(okButton))).perform(click());
    }

    public void addNewsDescription(String description) {
        Allure.step("Добавить описание новой новости " + description);
        onView(withId(descriptionField))
                .perform(replaceText(description), closeSoftKeyboard());
    }

    public void saveFreshNews() {
        Allure.step("Сохранение новой Новости");
        onView((withId(saveNewsButton))).perform(scrollTo(), click());
    }

    public void checkToastErrorMessage(String messageError, View decorView) {
        Allure.step("Появление всплывающего сообщения об ошибке Неверные данные");
        onView(withText(messageError))
                .inRoot(withDecorView(CoreMatchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    public void addNewsInvalidDate(String date) {
        Allure.step("Добавить некорректную дату новой Новости");
        onView((withId(datePublication))).perform(longClick()).perform(replaceText(date), closeSoftKeyboard());
    }

    public static void addNewsInvalidTime(String time) {
        Allure.step("Добавить некорректное время новой Новости");
        onView((withId(timePublication))).perform(longClick()).perform(replaceText(time), closeSoftKeyboard());
    }
}