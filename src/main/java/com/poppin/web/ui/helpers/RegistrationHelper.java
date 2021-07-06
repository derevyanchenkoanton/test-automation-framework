package com.poppin.web.ui.helpers;

import com.poppin.models.TeacherRegistrationModel;
import com.poppin.web.ui.pages.dashboard.EducatorsDashboardPage;
import com.poppin.web.ui.pages.teacher.TeacherHomePage;

public class RegistrationHelper {

    public static TeacherHomePage registerNewIndependentTeacher(TeacherRegistrationModel model) {
        new EducatorsDashboardPage()
                .selectIndependentTeacherOption()
                .setFirstNameForTeacher(model.getFirstName())
                .setLastNameForTeacher(model.getLastName())
                .selectRandomState()
                .setEmailAddressForTeacher(model.getEmail())
                .setPasswordForTeacher(model.getPassword())
                .clickRegisterFreeButton();
        return new TeacherHomePage();
    }
}
