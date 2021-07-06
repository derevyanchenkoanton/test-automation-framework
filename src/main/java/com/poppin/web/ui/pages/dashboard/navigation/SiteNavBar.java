package com.poppin.web.ui.pages.dashboard.navigation;

import com.codeborne.selenide.SelenideElement;
import com.poppin.web.ui.pages.dashboard.EducatorsDashboardPage;
import com.poppin.web.ui.pages.dashboard.FamiliesDashboardPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SiteNavBar<T> {

    private final T page;

    private final SelenideElement navBar = $("div.site-selector");

    public SiteNavBar(T page) {
        this.page = page;
    }

    @Step("Navigate to MobyMax for Educators dashboard")
    public EducatorsDashboardPage navigateToMobyMaxForEducatorsDashboard() {
        navBar.$x(".//a[text()='MobyMax for Educators']").click();
        return new EducatorsDashboardPage();
    }

    @Step("Navigate to MobyMax for Families dashboard")
    public FamiliesDashboardPage navigateToMobyMaxForFamiliesDashboard() {
        navBar.$x(".//a[text()='MobyMax for Families']").click();
        return new FamiliesDashboardPage();
    }
}
