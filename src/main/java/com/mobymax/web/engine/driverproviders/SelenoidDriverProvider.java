package com.mobymax.web.engine.driverproviders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.WebDriverProvider;


public class SelenoidDriverProvider implements WebDriverProvider {

    private static final String URL = System.getProperty("selenoid.url");

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setVersion("87.0");
        caps.setCapability("sessionTimeout", "5m");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        options.addArguments("disable-dev-shm-usage");
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            return new RemoteWebDriver(new URL(Objects.requireNonNull(URL)), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Selenoid configuration is illegal. Please check remote url.", e);
        }

    }
}
