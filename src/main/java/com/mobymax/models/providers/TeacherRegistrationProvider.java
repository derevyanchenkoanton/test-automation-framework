package com.mobymax.models.providers;

import com.github.javafaker.Faker;
import com.mobymax.models.TeacherRegistrationModel;

public class TeacherRegistrationProvider {

    private Faker faker = new Faker();

    public TeacherRegistrationModel getIndependentTeacherModel() {
        return TeacherRegistrationModel.builder()
                .withFirstName(faker.name().firstName())
                .withLastName(faker.name().lastName())
                .withEmail(faker.bothify("#####.#####@wtfqa.us"))
                .withPassword(faker.internet().password())
                .build();
    }
}
