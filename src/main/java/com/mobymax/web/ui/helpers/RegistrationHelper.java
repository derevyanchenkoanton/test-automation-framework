package com.mobymax.web.ui.helpers;

import com.mobymax.models.TeacherRegistrationModel;
import com.mobymax.web.ui.pages.dashboard.EducatorsDashboardPage;
import com.mobymax.web.ui.pages.teacher.TeacherHomePage;

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
