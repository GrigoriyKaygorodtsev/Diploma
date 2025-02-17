package ru.iteco.fmhandroid.test;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.Story;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import ru.iteco.fmhandroid.data.AuthorizationData;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;
import ru.iteco.fmhandroid.page.PageFunctional;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Авторизация")
@Feature("Вход в систему")
public class LoginTests  {
    static LoginPage loginPage = new LoginPage();
    static PageFunctional pageFunctional = new PageFunctional();
    static MainPage mainPage = new MainPage();
    public View decorView;

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void goToLoginPage() {
        loginPage.waitLoginPage();
        try {
            pageFunctional.waitPage(LoginPage.loginPageTag);
        } catch (Exception e) {
            mainPage.logOut();
        }
    }

    @Test
    @Story("Успешный вход в аккаунт с валидными данными")
    @Description("Тест успешного входа в аккаунт с валидными данными ")
    public void successfulLoginTest() {
        pageFunctional.waitPage(LoginPage.loginPageTag);
        pageFunctional.selectField(LoginPage.loginInputText);
        loginPage.feelField(LoginPage.loginInputText, AuthorizationData.LoginType);
        pageFunctional.selectField(LoginPage.passwordInputText);
        loginPage.feelField(LoginPage.passwordInputText,AuthorizationData.PasswordType);
        pageFunctional.clickItem(LoginPage.signInButton);
        pageFunctional.waitPage(MainPage.mainPageTag);
        pageFunctional.PageIsReached(MainPage.mainPageTag);
    }

    @Test
    @Story("Вход с невалидным паролем")
    @Description("Проверка входа в систему с невалидным паролем")
    public void appLoginTestInvalidPassword() {
        pageFunctional.waitPage(LoginPage.loginPageTag);
        pageFunctional.selectField(LoginPage.loginInputText);
        loginPage.feelField(LoginPage.loginInputText, AuthorizationData.LoginType);
        pageFunctional.selectField(LoginPage.passwordInputText);
        loginPage.feelField(LoginPage.passwordInputText, AuthorizationData.InvalidPasswordType);
        pageFunctional.clickItem(LoginPage.signInButton);
        loginPage.isNotLogin();
    }

    @Test
    @Story("Вход с невалидным логином и паролем")
    @Description("Проверка возможности входа с невалидным логином и паролем")
    public void appLoginTestInvalidLoginAndPassword() {
        pageFunctional.waitPage(LoginPage.loginPageTag);
        pageFunctional.selectField(LoginPage.loginInputText);
        loginPage.feelField(LoginPage.loginInputText, AuthorizationData.InvalidLoginType);
        pageFunctional.selectField(LoginPage.passwordInputText);
        loginPage.feelField(LoginPage.passwordInputText, AuthorizationData.InvalidPasswordType);
        pageFunctional.clickItem(LoginPage.signInButton);
        loginPage.isNotLogin();
    }

    @Test
    @Story("Вход с пустым полем ввода логина и пароля")
    @Description("Проверка возможности входа с пустым полем ввода логина и пароля")
    public void appLoginTestEmplyLoginAndPassword() {
        pageFunctional.waitPage(LoginPage.loginPageTag);
        pageFunctional.selectField(LoginPage.loginInputText);
        loginPage.feelField(LoginPage.loginInputText, AuthorizationData.EmptyInputType);
        pageFunctional.selectField(LoginPage.passwordInputText);
        loginPage.feelField(LoginPage.passwordInputText, AuthorizationData.EmptyInputType);
        pageFunctional.clickItem(LoginPage.signInButton);
        loginPage.isNotLogin();
    }
}