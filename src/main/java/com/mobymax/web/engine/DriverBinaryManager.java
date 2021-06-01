package com.mobymax.web.engine;

import com.mobymax.config.ConfigProvider;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Arrays;

public class DriverBinaryManager {

    public static void setupWebDriverBinary() {
        String driverType = ConfigProvider.CONFIG_PROPS.driverType();
        DriverType driver = Arrays.stream(DriverType.values())
                .filter(it -> it.name().equals(driverType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provided driver type is not supported\n" +
                        "Driver Type: " + driverType));
        switch (driver) {
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                break;
            case chrome:
                WebDriverManager.chromedriver().setup();
                break;
            default:
                throw new IllegalArgumentException(String.format("No implementation for provided driver type: " +
                        "Driver Type[%s]", driverType));
        }
    }
}
