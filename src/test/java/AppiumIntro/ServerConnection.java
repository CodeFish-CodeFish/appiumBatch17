package AppiumIntro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnection {

    @Test

    public void connectServer() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        //Set
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName","MyDevice");
        //set APK file
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        //Appium server connection
        URL appiumServerUrl = new URL("http://0.0.0.0:4723/wd/hub");

        AndroidDriver <AndroidElement> driver = new AndroidDriver<AndroidElement>(appiumServerUrl,desiredCapabilities);
    }
}
