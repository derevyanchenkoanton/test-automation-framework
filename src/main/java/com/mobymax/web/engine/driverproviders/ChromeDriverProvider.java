package com.mobymax.web.engine.driverproviders;

import com.mobymax.web.engine.DriverDownloadDirManager;
import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return new ChromeDriver(getChromeOptions());
    }

    public static ChromeOptions getChromeOptions() {
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", DriverDownloadDirManager.clearSetGet().toAbsolutePath().toString());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setExperimentalOption("prefs", chromePrefs);
        return options;
    }
}
