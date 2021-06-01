package com.mobymax.tests;

import com.codeborne.selenide.Selenide;
import com.mobymax.config.ConfigProvider;
import com.mobymax.listeners.TestListener;
import com.mobymax.web.engine.DriverBinaryManager;
import com.mobymax.web.engine.DriverConfigurator;
import com.mobymax.web.engine.DriverUtils;
import lombok.extern.java.Log;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.mobymax.config.ConfigProvider.CONFIG_PROPS;

@Log
@Listeners(TestListener.class)
public class WebBaseTest {

    @BeforeSuite(alwaysRun = true, description = "Download web driver binaries")
    protected void beforeSuite(ITestContext context) {
        DriverBinaryManager.setupWebDriverBinary();//download web driver binary
        if (ConfigProvider.CONFIG_PROPS.threadCount() != null) {
            context.getSuite().getXmlSuite()
                    .setThreadCount(Integer.parseInt(ConfigProvider.CONFIG_PROPS.threadCount()));
        }
    }

    @BeforeMethod(alwaysRun = true, description = "Initialize web driver configuration")
    protected void beforeMethod() {
        DriverConfigurator.configure();//this method doesn't open the browser yet
        Selenide.open(CONFIG_PROPS.baseWebUrl());
    }

    @AfterMethod(alwaysRun = true, description = "Close driver")
    protected void tearDown() {
        DriverUtils.stop();
    }
}
