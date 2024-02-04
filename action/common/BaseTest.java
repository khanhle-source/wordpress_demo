package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    //chua cac ham dung chung cho tcs

    protected WebDriver driverBaseTest;
    private String projectPath = System.getProperty("user.dir");

    public WebDriver getDriverInstant () {
        return this.driverBaseTest;
    }
    protected WebDriver getBrowerDriver (String browserName, String getURL) {
        if (browserName.equals("firefox")) {
            driverBaseTest =  WebDriverManager.firefoxdriver().create();
            //System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver");

            // Add extension to Firefox
            FirefoxProfile profile = new FirefoxProfile();
            File translate = new File(GlobalConstants.PROJECT_PATH + "/browserExtensions/google_translate.crx");
            profile.addExtension(translate);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
           // driverBaseTest = new FirefoxDriver(options);

        }
        else if (browserName.equals("chrome")) {
            //driverBaseTest = WebDriverManager.chromedriver().create();
            System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver");
            Map<String, Object> prefs = new HashMap<String, Object>();
            //Add Extension to Chrome
            File file = new File(GlobalConstants.PROJECT_PATH + "/browserExtensions/google_translate.crx");
            ChromeOptions options = new ChromeOptions();
            //change language
            options.addArguments("--lang=vi");
            //disable notification popup
            options.addArguments("--disable-notifications");
            //disable location popup
            options.addArguments("--disable-geolocation");
            //close automation info bar
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            //dont save password popup
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enable", false);
            //incognito mode
            options.addArguments("--incognito");

            //download Files location
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("download.default_directory", GlobalConstants.PROJECT_PATH + "/downloadFiles");
            options.setExperimentalOption("prefs", prefs);



            options.addExtensions(file);
            driverBaseTest = new ChromeDriver(options);
        }
        else if (browserName.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("window-size=1920x1080");
            driverBaseTest = new ChromeDriver(options);
        }
        else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driverBaseTest = new EdgeDriver();
        }
        else if (browserName.equals("IE")) {
            WebDriverManager.iedriver().arch64().setup();

        }
        else {
            throw new RuntimeException("Browser name invalid");
        }
        driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driverBaseTest.get(getURL);
        return driverBaseTest;

    }

    public void closeBrowserDriver(WebDriver driver) {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            String driverInstanceName = driver.toString().toLowerCase();

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected String getCurrentDay () {
        DateTime nowUTC = new DateTime ();
        int day = nowUTC.getDayOfMonth();
        if (day < 10) {
            String dayValue = "0" + day;
            return  dayValue;
        }
        return String.valueOf(day);
    }

    protected String getCurrentMonth() {
        DateTime now = new DateTime();
        int month = now.getMonthOfYear();
        if (month < 10) {
            String monthValue = "0" + month;
            return monthValue;
        }
        return  String.valueOf(month);
    }

    protected String getCurrentMonthByName () {
        String monthByName ="";
        if (getCurrentMonth() == "1") {
            monthByName = "Jan";
        }
        if (getCurrentMonth() == "2") {
            monthByName = "Feb";
        }
        if (getCurrentMonth() == "3") {
            monthByName = "Mar";
        }
        if (getCurrentMonth() == "4") {
            monthByName = "Apr";
        }
        if (getCurrentMonth() == "5") {
            monthByName = "May";
        }
        if (getCurrentMonth() == "6") {
            monthByName = "Jun";
        }
        if (getCurrentMonth() == "7") {
            monthByName = "Jul";
        }
        if (getCurrentMonth() == "8") {
            monthByName = "Aug";
        }
        if (getCurrentMonth() == "9") {
            monthByName = "Sep";
        }
        if (getCurrentMonth() == "10") {
            monthByName = "Oct";
        }
        if (getCurrentMonth() == "11") {
            monthByName = "Nov";
        }
        if (getCurrentMonth() == "12") {
            monthByName = "Dec";
        }
        return monthByName;
    }

    protected String getCurrentYear () {
        DateTime now = new DateTime();
        return String.valueOf(now.getYear());
    }
    protected  String getToday () {
        return getCurrentMonthByName() + " " + getCurrentDay() + ", " + getCurrentYear() ;
    }


    public int random () {
        Random rnd = new Random();
        return rnd.nextInt(999);
    }
}
