package com.mobymax.config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:${env.config.path}"})
public interface ConfigProps extends Config {

    @Key("mobymax.url")
    String mobyMaxUrl();

    @Key("driver.type")
    String driverType();

    @Key("thread.count")
    String threadCount();
}
