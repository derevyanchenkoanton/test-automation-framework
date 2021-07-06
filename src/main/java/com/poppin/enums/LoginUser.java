package com.poppin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LoginUser {

    STUDENT("As a Student"),
    TEACHER("As a Teacher"),
    PARENT("As a Parent"),
    SCHOOL_ADMINISTRATOR("As a School Administrator"),
    DISTRICT_ADMINISTRATOR("As a District Administrator");

    private final String user;
}
