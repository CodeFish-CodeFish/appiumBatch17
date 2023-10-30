package UTILS;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.time.Duration;

public class CommonUtils {

    public static void ElementTap(AndroidDriver driver, AndroidElement element){
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }

    public static void elementLongPress(AndroidDriver driver, AndroidElement element, int duration){

        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(duration))).perform();
    }

    public static AndroidElement scrollToElement(AndroidDriver<AndroidElement> driver, String locator){

        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+locator+"\"))");
    }
}
