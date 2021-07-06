package com.poppin.web.ui.pages.dashboard;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.poppin.web.ui.pages.dashboard.navigation.SiteNavBar;
import com.poppin.web.ui.pages.dashboard.navigation.TopLinksNavBar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EducatorsDashboardPage {

    private final SelenideElement header = $("#header");

    private final SelenideElement registrationForm = $("#registration"),
            independentTeacherOption = registrationForm.$x(".//span[text()='I teach or tutor independently']"),
            firstNameField = registrationForm.$("input.first-name"),
            lastNameField = registrationForm.$("input.last-name"),
            yourStateField = registrationForm.$("input.state-for-independent-teacher"),
            emailAddressField = registrationForm.$("input.username"),
            passwordField = registrationForm.$("input.password"),
            registerFreeBtn = registrationForm.$("#register-button");

    private final ElementsCollection statesList = $$("div.state-item");

    public SiteNavBar<EducatorsDashboardPage> siteNavBar = new SiteNavBar<>(this);
    public TopLinksNavBar<EducatorsDashboardPage> topLinksNavBar = new TopLinksNavBar<>(this);

    @Step("Verify Educators Dashboard page is opened")
    public boolean isEducatorsDashboardPageOpened() {
        return header.waitUntil(Condition.visible, 10000).isDisplayed();
    }

    @Step("Select 'I teach or tutor independently' option for registration")
    public EducatorsDashboardPage selectIndependentTeacherOption() {
        independentTeacherOption.click();
        return this;
    }

    @Step("Set first name for teacher: {firstName}")
    public EducatorsDashboardPage setFirstNameForTeacher(String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }

    @Step("Set last name for teacher: {lastName}")
    public EducatorsDashboardPage setLastNameForTeacher(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    @Step("Select random state")
    public EducatorsDashboardPage selectRandomState() {
        yourStateField.click();
        statesList.shouldHave(sizeGreaterThan(0))
                .get(Faker.instance().number().numberBetween(1, statesList.size()-1)).click();
        return this;
    }

    @Step("Set email address for teacher: {email}")
    public EducatorsDashboardPage setEmailAddressForTeacher(String email) {
        emailAddressField.setValue(email);
        return this;
    }

    @Step("Set password for teacher: {pwd}")
    public EducatorsDashboardPage setPasswordForTeacher(String pwd) {
        passwordField.setValue(pwd);
        return this;
    }

    @Step("Click Register Free button")
    public EducatorsDashboardPage clickRegisterFreeButton() {
        registerFreeBtn.click();
        return this;
    }
}
