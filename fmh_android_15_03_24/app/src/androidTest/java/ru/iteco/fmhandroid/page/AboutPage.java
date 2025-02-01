package ru.iteco.fmhandroid.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.data.TestUtils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.Allure;
import ru.iteco.fmhandroid.R;
import io.qameta.allure.Step;
import ru.iteco.fmhandroid.ValidTest;

public class AboutPage {


    ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    ViewInteraction privacyTitle = onView(withId(R.id.about_privacy_policy_label_text_view));
    ViewInteraction termsOfUseTitle = onView(withId(R.id.about_terms_of_use_label_text_view));

    @Step("Проверить, что заголовок версии отображаеться")
    public void checkVersionTitleDisplayed() {
        versionTitle.check(matches(isDisplayed()));
    }

    @Step("Проверить, что отображается заголовок политики конфеденциальности")
    public void checkPrivacyTitleDisplayed() {
        privacyTitle.check(matches(isDisplayed()));
    }

    @Step("Проверить, что отображается заголовок условий использования")
    public void checkTermsOfUseTitleDisplayed() {
        termsOfUseTitle.check(matches(isDisplayed()));
    }

    @Step("Проверка ожидания загрузки страницы")
    public void waitUntilPageLoaded() {
        onView(isRoot()).perform(waitDisplayed(R.id.about_version_title_text_view, 5000));
    }

    @Step("Переход на страницу о приложении")
    public void goToAboutPage() {
        NavigationPage navigationPage = new NavigationPage();
        navigationPage.goToAboutPage();
    }
}
