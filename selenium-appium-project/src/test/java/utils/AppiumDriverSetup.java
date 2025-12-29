package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumDriverSetup {
    public static AndroidDriver driver;
    private static Properties properties;

    public static void initializeDriver() throws IOException {
        properties = new Properties();
        FileInputStream configFile = new FileInputStream("src/test/resources/config.properties");
        properties.load(configFile);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(properties.getProperty("mobile.platform.name"));
        options.setDeviceName(properties.getProperty("mobile.device.name"));
        options.setAutomationName(properties.getProperty("mobile.automation.name"));
        options.setAppPackage(properties.getProperty("mobile.app.package"));
        options.setAppActivity(properties.getProperty("mobile.app.activity"));
        options.setApp(properties.getProperty("mobile.app.path"));
        options.setNoReset(false);

        URL appiumServerUrl = new URL(properties.getProperty("mobile.appium.server.url"));
        driver = new AndroidDriver(appiumServerUrl, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}