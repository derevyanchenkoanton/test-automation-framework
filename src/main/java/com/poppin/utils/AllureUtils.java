package com.poppin.utils;

import com.poppin.web.engine.DriverUtils;
import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment("{name}")
    public static byte[] takeScreenshot(String name) {
        return DriverUtils.getScreenshot();
    }
}
