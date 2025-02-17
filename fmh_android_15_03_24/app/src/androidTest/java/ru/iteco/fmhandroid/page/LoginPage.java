package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.data.TestUtils.childAtPosition;
import static ru.iteco.fmhandroid.data.TestUtils.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class LoginPage {

    public static final int loginInputText = R.id.login_text_input_layout;
    public static final int loginPageTag = loginInputText;
    public static final int passwordInputText = R.id.password_text_input_layout;
    public static final int signInButton = R.id.enter_button;


    static PageFunctional pageFunctional = new PageFunctional();

    public void waitLoginPage() {
        onView(isRoot()).perform(waitDisplayed(R.id.splashscreen_image_view, 8_000));

    }

    public void feelField(int field, String inputText) {
        Allure.step("Заполнение выбранного поля текстом: {inputText}");
        onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(field),
                                0),
                        0)))
                .perform(replaceText(inputText), closeSoftKeyboard());
    }

    public void isNotLogin() {
        Allure.step("Проверка того, что войти в приложение (логин) НЕ удалось");
        try {
            pageFunctional.waitPage(MainPage.mainPageTag);
        } catch (Exception e) {

        } finally {
            pageFunctional.PageIsReached(loginPageTag);
        }
    }

}
