package com.mobymax.tests.web;

import com.mobymax.constants.TestNgGroups;
import com.mobymax.models.TeacherRegistrationModel;
import com.mobymax.models.providers.TeacherRegistrationProvider;
import com.mobymax.tests.WebBaseTest;
import com.mobymax.web.ui.pages.teacher.TeacherHomePage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.mobymax.web.ui.helpers.LoginHelper.loginAsTeacher;
import static com.mobymax.web.ui.helpers.RegistrationHelper.registerNewIndependentTeacher;
import static org.assertj.core.api.Assertions.assertThat;

public class TeacherLoginTest extends WebBaseTest {

    private final TeacherRegistrationModel teacherRegistrationModel =
            new TeacherRegistrationProvider().getIndependentTeacherModel();

    @BeforeMethod(alwaysRun = true)
    public void preRequisites() {
        registerNewIndependentTeacher(teacherRegistrationModel)
                .appBar
                .logout();
    }

    @TmsLink("AU-202")
    @Test(description = "Teacher login", groups = {TestNgGroups.REGRESSION})
    public void testTeacherLogin() {
        TeacherHomePage teacherHomePage = loginAsTeacher(teacherRegistrationModel.getEmail(), teacherRegistrationModel.getPassword());

        assertThat(teacherHomePage.isTeacherHomePageOpened())
                .as("Teacher home page not loaded")
                .isTrue();
    }
}
