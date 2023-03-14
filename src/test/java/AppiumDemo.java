import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class AppiumDemo
{
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AndroidDriver driver;

    @BeforeSuite
    public  void setupAppium() throws MalformedURLException
    {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability("appPackage","com.whatsapp");
        capabilities.setCapability("appActivity","Main");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        capabilities.setCapability("udid", "RFCNA0967YN");
        capabilities.setCapability("systemPort", 8205);
        driver = new AndroidDriver(new URL("http://10.0.10.5:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test (enabled=true) public void myFirstTest() throws InterruptedException {
        System.out.println("Test 1 Completed.");
    }
}