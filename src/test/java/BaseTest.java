import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

    public void setDriver(AndroidDriver driver){
        this.driver.set(driver);
    }

    public AndroidDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion", "portNumber", "udid"})
    public void initiateDriver(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage","com.whatsapp");
        capabilities.setCapability("appActivity","Main");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("systemPort", 8205);
        System.out.println("Test Started");
        setDriver(new AndroidDriver(new URL("http://10.0.10.5:"+portNumber+"/wd/hub"), capabilities));
    }

    @AfterMethod
    public void closeDriver(){
        getDriver().quit();
    }
}
