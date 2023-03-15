import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class AppiumDemo extends BaseTest
{
    @Test (enabled=true) public void myFirstTest() throws InterruptedException {
        getDriver().get("https://inone.useinsider.com");
        System.out.println("Test 1 Completed.");
    }
}