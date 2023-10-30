package Locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aspectj.weaver.ast.And;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Xpath {

    @Test
    public void locateElement() throws MalformedURLException {
        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("devicePlatform","android");
        desiredCapabilities.setCapability("deviceName","MyDevice");

        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        URL appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(appiumServerURL,desiredCapabilities);


        AndroidElement AppButton =
                driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        AppButton.click();

        AndroidElement AlarmButton = driver.findElementByAccessibilityId("Alarm");
        AlarmButton.click();

        AndroidElement AlarmController = driver.findElementByAccessibilityId("Alarm Controller");
        AlarmController.click();

        AndroidElement OneShotAlarm = driver.findElementById("io.appium.android.apis:id/one_shot");

        Assert.assertEquals("ONE SHOT ALARM",OneShotAlarm.getText());



    }
}
