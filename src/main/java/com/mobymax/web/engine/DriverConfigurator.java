package com.mobymax.web.engine;

import com.codeborne.selenide.Configuration;
import com.mobymax.config.ConfigProvider;
import com.mobymax.web.engine.driverproviders.*;

import java.time.Duration;
import java.util.Arrays;

public class DriverConfigurator {

    public static void configure() {
        Configuration.timeout = Duration.ofSeconds(60).toMillis();
        Configuration.startMaximized = true;
        Configuration.reopenBrowserOnFail = true;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.browser = getDriverClassName();
    }

    public static DriverType getDriverType() {
        String driverType = ConfigProvider.CONFIG_PROPS.driverType();
        return Arrays.stream(DriverType.values())
                .filter(it -> it.name().equals(driverType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Provided driver type is not supported\n" +
                        "Driver Type: " + driverType));
    }

    private static String getDriverClassName() {
        DriverType driverType = getDriverType();
        switch (driverType) {
            case chrome: {
                return ChromeDriverProvider.class.getName();
            }
            case firefox: {
                return FireFoxDriverProvider.class.getName();
            }
            default:
                throw new IllegalArgumentException(String.format("No implementation for provided driver type: " +
                        "Driver Type[%s]", driverType));
        }
    }
}
