package com.mobymax.config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:config/${env}-profile.properties")
public interface ConfigProps extends Config {

    @Key("driver.type")
    String driverType();

    @Key("thread.count")
    String threadCount();

    @Key("env.profile.name")
    String envProfileName();

    @Key("base.web.url")
    String baseWebUrl();
}
