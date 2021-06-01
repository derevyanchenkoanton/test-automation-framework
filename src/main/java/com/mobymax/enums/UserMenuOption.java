package com.mobymax.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserMenuOption {

    CURRICULUM_SETTINGS("Curriculum Settings"),
    MESSENGER("Messenger"),
    MY_ACCOUNT("My Account"),
    LOG_OUT("Log Out");

    private final String option;
}
