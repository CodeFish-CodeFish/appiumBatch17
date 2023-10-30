package Gestures;

import UTILS.CommonUtils;
import UTILS.DriverUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.aspectj.weaver.ast.And;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;

public class Gestures {

    /*
-> Click Views
-> Click Gallery
-> Click 1 Photos
-> Assert first image is focus returns TRUE
-> Swipe to the left
-> Assert first image is focus returns False
 */
    @Test

    public void deviceRotate(){

        AndroidDriver<AndroidElement> driver =
                DriverUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk","Mydevice");

        DeviceRotation landScape = new DeviceRotation(0,0,90);
        driver.rotate(landScape);

        AndroidElement views = driver.findElementByAccessibilityId("App");
        views.click();
//driver.pressKey(new KeyEvent(AndroidKey.BACK));










    }



}
