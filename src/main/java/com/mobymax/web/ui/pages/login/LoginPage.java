package com.mobymax.web.ui.pages.login;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement header = $("div.header-sign-in-text"),
            emailField = $("#UserUsername"),
            passwordField = $("#UserPassword"),
            signInBtn = $("#signin-btn");

    public LoginNavBar<LoginPage> loginNavBar = new LoginNavBar<>(this);

    @Step("Verify Login page is opened")
    public boolean isLoginPageOpened() {
        return header.waitUntil(Condition.visible, 10000).isDisplayed();
    }

    @Step("Set email: {email}")
    public LoginPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Set password: {pwd}")
    public LoginPage setPassword(String pwd) {
        passwordField.setValue(pwd);
        return this;
    }

    @Step("Click Sign In button")
    public LoginPage clickSignInButton() {
        signInBtn.click();
        return this;
    }
}
