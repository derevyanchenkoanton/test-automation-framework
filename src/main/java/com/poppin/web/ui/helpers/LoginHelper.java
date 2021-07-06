package com.poppin.web.ui.helpers;

import com.poppin.web.ui.pages.login.LoginPage;
import com.poppin.web.ui.pages.teacher.TeacherHomePage;

public class LoginHelper {

    public static TeacherHomePage loginAsTeacher(String email, String password) {
        new LoginPage().loginNavBar
                .openLoginFormForTeacher()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButton();
        return new TeacherHomePage();
    }
}
