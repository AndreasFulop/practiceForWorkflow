import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Util {
    private  static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("incognito");
            options.addArguments("--disable-gpu","--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver () {
        driver.close();
    }

    public static void clickOnPage(By by) {
        Util.getDriver().findElement(by).click();
    }

    public static String getTextFromPage(By by) {
        return Util.getDriver().findElement(by).getText();
    }

    public static void sendKeysToField(By by, String string) {
        Util.getDriver().findElement(by).sendKeys(string);
    }

    public static String fileReader(String fieldName) {
        String credentials = "";
        try {
            File myObj = new File("paraReg.txt");
            Scanner scanner = new Scanner(myObj);
            while(scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] temp = data.split(":");
                if (temp[0].equals(fieldName)){
                    credentials = temp[1];
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {e.printStackTrace();}
        return credentials;
    }


    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)");
    }

    public static void refresh(WebDriver driver){
        driver.navigate().refresh();
    }

    public static void waitForMsec(int time) throws InterruptedException {
        Thread.sleep(time);
    }

}
