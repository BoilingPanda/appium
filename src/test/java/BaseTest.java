import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public void setDriver(AppiumDriver driver){
        this.driver.set(driver);
    }

    public AppiumDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion", "portNumber", "udid", "systemPort"})
    public void initiateDriver(String deviceName, String platformVersion, String portNumber, String udid, String systemPort) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage","com.whatsapp");
        capabilities.setCapability("appActivity","Main");
        //capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("autoAcceptAlerts",true);
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("fullReset", false);
        capabilities.setCapability("autoGrantPermissions",true);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("systemPort", systemPort);
        System.out.println("Test Started");
        setDriver(new AndroidDriver(new URL("http://10.0.10.5:"+portNumber+"/wd/hub"), capabilities));
    }

    @AfterMethod
    public void closeDriver(){
        //getDriver().quit();
    }
}
