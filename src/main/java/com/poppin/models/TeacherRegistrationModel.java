package com.poppin.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder(setterPrefix = "with")
public class TeacherRegistrationModel {

    private String firstName;
    private String lastName;
    private String state;
    private String email;
    private String password;
}
