package com.poppin.utils;

import io.qameta.allure.TmsLink;
import org.testng.IInvokedMethod;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class TestReflectionUtil {

    public static int getTestId(IInvokedMethod method) {
        Annotation annotation = Arrays.stream(method.getTestMethod().getConstructorOrMethod()
                .getMethod().getDeclaredAnnotations())
                .filter(a -> a instanceof TmsLink)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Annotation '" + TmsLink.class + "' hasn't been provided on method " + method));
        return Integer.parseInt(((TmsLink) annotation).value());
    }
}
