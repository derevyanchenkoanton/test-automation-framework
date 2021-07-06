package com.poppin.tests.web;

import com.poppin.constants.TestNgGroups;
import com.poppin.models.TeacherRegistrationModel;
import com.poppin.models.providers.TeacherRegistrationProvider;
import com.poppin.tests.WebBaseTest;
import com.poppin.web.ui.pages.teacher.TeacherHomePage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.poppin.web.ui.helpers.LoginHelper.loginAsTeacher;
import static com.poppin.web.ui.helpers.RegistrationHelper.registerNewIndependentTeacher;
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

    @TmsLink("AU")
    @Test(description = "Teacher login", groups = {TestNgGroups.REGRESSION})
    public void testTeacherLogin() {
        TeacherHomePage teacherHomePage = loginAsTeacher(teacherRegistrationModel.getEmail(), teacherRegistrationModel.getPassword());

        assertThat(teacherHomePage.isTeacherHomePageOpened())
                .as("Teacher home page not loaded")
                .isTrue();
    }
}
