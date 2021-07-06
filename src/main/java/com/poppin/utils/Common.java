package com.poppin.utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.executeJavaScript;


public class Common {

    public static void clickViaJS(SelenideElement element) {
        executeJavaScript("arguments[0].click()", element);
    }

    public static void clearInputByKeys(SelenideElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
}
