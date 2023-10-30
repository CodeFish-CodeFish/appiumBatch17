package Gestures;

import UTILS.CommonUtils;
import UTILS.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;

public class ScrollMethod {

    @Test
    public void ScrollTest(){

        AndroidDriver<AndroidElement> driver = DriverUtils.getDriver("src/test/resources/ApiDemos-debug-newVersion.apk","MyDevice");
        AndroidElement viewsButton = driver.findElementByAccessibilityId("Views");
        CommonUtils.ElementTap(driver,viewsButton);

        CommonUtils.scrollToElement(driver,"ImageView");

//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ImageView\"))");

        AndroidElement imageView = driver.findElementByAccessibilityId("ImageView");
        Assert.assertEquals("ImageView",imageView.getText());


        //HOME WORK: Create reusable method for scrolling in BaseClass
        // Practice scrolling calling that method
    }
}
