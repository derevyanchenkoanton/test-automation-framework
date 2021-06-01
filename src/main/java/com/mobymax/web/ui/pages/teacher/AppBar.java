package com.mobymax.web.ui.pages.teacher;

import com.codeborne.selenide.SelenideElement;
import com.mobymax.enums.UserMenuOption;
import com.mobymax.web.ui.pages.login.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AppBar<T> {

    private final T page;

    private final SelenideElement appBar = $("div[class*=header--AppBarContainer]"),
            userMenuBtn = appBar.$x(".//span[text()='More']").closest("button"),
            userMenu = $("div[role='menu']");

    public AppBar(T page) {
        this.page = page;
    }

    private AppBar<T> openUserMenu() {
        userMenuBtn.click();
        return this;
    }

    @Step("Log out")
    public LoginPage logout() {
        openUserMenu()
                .clickUserMenuOption(UserMenuOption.LOG_OUT);
        return new LoginPage();
    }

    private void clickUserMenuOption(UserMenuOption option) {
        userMenu.$$("span[role=menuitem]")
                .findBy(text(option.getOption())).click();
    }
}
