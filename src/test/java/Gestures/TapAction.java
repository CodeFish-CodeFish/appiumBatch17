package Gestures;

import UTILS.CommonUtils;
import UTILS.DriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TapAction {

    @Test

    public void TapTest() throws MalformedURLException {

        //MAC-->Command+Shift+V
        //Windows --> Ctrl+Shift+V
        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"MyDevice");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,900);

        URL appiumServerURL = new URL("http://0.0.0.0:4723/wd/hub");
        AndroidDriver <AndroidElement> driver = new AndroidDriver<>(appiumServerURL,desiredCapabilities);

        AndroidElement appButton =
                driver.findElementByAndroidUIAutomator("text(\"App\")");

      TouchAction action = new TouchAction(driver);
      action.tap(TapOptions.tapOptions().withElement(ElementOption.element(appButton))).perform();

    }


    @Test

    public void longPress(){

        AndroidDriver <AndroidElement> driver = DriverUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk","MyDevice");

        AndroidElement viewsButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        CommonUtils.ElementTap(driver,viewsButton);

        AndroidElement expandableListButton = driver.findElementByAccessibilityId("Expandable Lists");
        CommonUtils.ElementTap(driver,expandableListButton);

        AndroidElement customAdaptpr = driver.findElementByAccessibilityId("1. Custom Adapter");
        CommonUtils.ElementTap(driver,customAdaptpr);

        AndroidElement PeopleNamesButton = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(PeopleNamesButton)).withDuration(Duration.ofSeconds(3))).perform();

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        AndroidElement fishNames = driver.findElement(By.xpath("//android.widget.TextView[@text='Fish Names']"));
        Assert.assertEquals("Fish Names", fishNames.getText());


        CommonUtils.elementLongPress(driver,fishNames,3);
        AndroidElement sampleAction =
                driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']"));
        Assert.assertEquals("Sample action",sampleAction.getText());








    }
}
