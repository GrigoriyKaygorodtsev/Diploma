package ru.iteco.fmhandroid.test;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.Allure;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ValidTest;
import ru.iteco.fmhandroid.data.AuthorizationData;
import ru.iteco.fmhandroid.data.AuthorizationDataUtils;
import ru.iteco.fmhandroid.page.LoginPage;
import ru.iteco.fmhandroid.page.MainPage;

@Epic("Авторизация")
@Feature("Вход в систему")
public class LoginTests extends ValidTest {

    @Test
    @Story("Успешный вход в аккаунт с валидными данными")
    @Description("Тест успешного входа в аккаунт с валидными данными ")
    public void successfulLoginTest() {
        AuthorizationDataUtils.logIn();
        AuthorizationDataUtils.logOut();
    }


    @Test
    @Story("Вход с невалидным паролем")
    @Description("Проверка входа в систему с невалидным паролем")
    public void appLoginTestInvalidPassword() {
        AuthorizationDataUtils.unsuccessfulLogIn(AuthorizationData.InvalidLoginType, AuthorizationData.InvalidPasswordType);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMassageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }

    @Test
    @Story("Вход с невалидным логином и паролем")
    @Description("Проверка возможности входа с невалидным логином и паролем")
    public void appLoginTestInvalidLoginAndPassword() {
        AuthorizationDataUtils.unsuccessfulLogIn(AuthorizationData.InvalidLoginType, AuthorizationData.InvalidPasswordType);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMassageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }

    @Test
    @Story("Вход с пустым полем ввода логина и пароля")
    @Description("Проверка возможности входа с пустым полем ввода логина и пароля")
    public void appLoginTestEmplyLoginAndPassword() {
        AuthorizationDataUtils.unsuccessfulLogIn(AuthorizationData.EmptyInputType, AuthorizationData.EmptyInputType);
        LoginPage loginPage = new LoginPage();
        loginPage.waitUntilErrorMassageLoaded();

        Allure.step("Убедиться, что остались на странице логина");
        loginPage.validatePageLoaded();
    }
}