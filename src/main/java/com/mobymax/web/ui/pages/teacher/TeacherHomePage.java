package com.mobymax.web.ui.pages.teacher;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TeacherHomePage {

    private final SelenideElement registerBox =
            $x("//div[contains(@class, 'register-box') and text()='Welcome to MobyMax!']");

    public AppBar<TeacherHomePage> appBar = new AppBar<>(this);

    @Step("Verify Teacher Home page is opened")
    public boolean isTeacherHomePageOpened() {
        return registerBox.waitUntil(Condition.visible, 10000).isDisplayed();
    }
}
