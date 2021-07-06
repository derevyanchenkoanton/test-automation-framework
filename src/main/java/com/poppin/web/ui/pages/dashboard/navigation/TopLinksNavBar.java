package com.poppin.web.ui.pages.dashboard.navigation;

import com.codeborne.selenide.SelenideElement;
import com.poppin.web.ui.pages.login.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TopLinksNavBar<T> {

    private final T page;

    private final SelenideElement navBar = $("#toplinks");

    public TopLinksNavBar(T page) {
        this.page = page;
    }

    @Step("Open Login page")
    public LoginPage openLoginPage() {
        navBar.$("a.btn-signin").click();
        return new LoginPage();
    }
}
