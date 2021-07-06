package com.poppin.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static final ConfigProps CONFIG_PROPS;

    static {
        String configDir = "src/test/resources/config/";
        String key = "env.config.path";
        ConfigFactory.setProperty(key, configDir + "config.properties");
        CONFIG_PROPS = ConfigFactory.create(ConfigProps.class, System.getProperties());
    }
}
