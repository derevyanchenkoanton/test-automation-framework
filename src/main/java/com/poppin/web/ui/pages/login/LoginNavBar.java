package com.poppin.web.ui.pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.poppin.enums.LoginUser;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.poppin.enums.LoginUser.TEACHER;

public class LoginNavBar<T> {

    private final T page;

    private final SelenideElement navBar = $("div.header-menu");

    public LoginNavBar(T page) {
        this.page = page;
    }

    @Step("Open Login form for teacher")
    public T openLoginFormForTeacher() {
        navigateToUserForLogin(TEACHER);
        return page;
    }

    private void navigateToUserForLogin(LoginUser loginUser) {
        navBar.$$(".header-menu-item")
                .findBy(Condition.text(loginUser.getUser())).click();
    }
}
