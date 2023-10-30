package EcommerceApp;

import UTILS.CommonUtils;
import UTILS.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class eCommerce {

    //  1.Fill the form details and verify Toast error message displayed appropriately wrong inputs
// - Select country -> Argentina
// - Select Radio button -> Female
// - Click on Let's Shop button
// - Verify Toast error message displayed appropriately wrong inputs
    @Test
    public void testCase_1(){
        AndroidDriver<AndroidElement> driver =
                DriverUtils.getDriver("src/test/resources/General-Store (1).apk","MyDevice");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        AndroidElement countrydropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']"));
        countrydropdown.click();

        CommonUtils.scrollToElement(driver,"Argentina");

        AndroidElement Argentina = driver.findElement(By.xpath("//\tandroid.widget.TextView[@text='Argentina']"));
        CommonUtils.ElementTap(driver,Argentina);

        AndroidElement enterName = driver.findElement(By.xpath("//android.widget.EditText[@index=3]"));
        enterName.sendKeys("MyName");

        AndroidElement femaleRadio = driver.findElementById("com.androidsample.generalstore:id/radioFemale");
        femaleRadio.click();

        AndroidElement letsShopButton = driver.findElement(By.xpath("//android.widget.Button[@index=6]"));
        CommonUtils.ElementTap(driver,letsShopButton);


//        AndroidElement toastMessage =
////                driver.findElement(By.xpath("//android.widget.Toast"));
////        Assert.assertEquals("Please enter your name",toastMessage.getText());

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        AndroidElement firstAddToCard =
                driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0);
       firstAddToCard.click();

       driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        AndroidElement secondAddToCard =
                driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0);
        secondAddToCard.click();

       // driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        AndroidElement cardIcon = driver.findElementById(
                ("com.androidsample.generalstore:id/appbar_btn_cart"));
        CommonUtils.ElementTap(driver,cardIcon);

        AndroidElement cardTitle =
                driver.findElementById(
                        ("com.androidsample.generalstore:id/toolbar_title"));
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.visibilityOf(cardTitle));











    }
}
