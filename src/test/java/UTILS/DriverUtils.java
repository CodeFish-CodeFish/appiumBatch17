package UTILS;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    public static AndroidDriver getDriver(String apk, String device){
        File apkFile = new File(apk);
        //File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,device);
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,900);

        try{
            URL appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver<>(appiumServerURL,desiredCapabilities);
            return driver;
        }catch (MalformedURLException ex){
            throw new RuntimeException();
        }
    }
}
