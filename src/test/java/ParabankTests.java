import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.split;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParabankTests {
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

    public static void closeDriver () {
        driver.close();
    }

    public static void clickOnPage(By by) {
        getDriver().findElement(by).click();
    }

    public static String getTextFromPage(By by) {
        return getDriver().findElement(by).getText();
    }

    public static void sendKeysToField(By by, String string) {
        getDriver().findElement(by).sendKeys(string);
    }

    public static void waitForMsec(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void login() {
        String username = fileReader("username");
        String password = fileReader("password");
        sendKeysToField(MainPage.USERNAME_FIELD, username);
        sendKeysToField(MainPage.PASSWORD_FIELD, password);
        clickOnPage(MainPage.LOGIN_BUTTON);
    }

    public static void logout() {
        clickOnPage(Overview.LOGOUT_MENU);
    }

        @BeforeEach
    public void driverInit() {
        getDriver().get("https://parabank.parasoft.com/");
    }

    @Test
    @Order(1)
    @DisplayName("Main page is valid")
    public void testMainPageSubtitle() {
        Assertions.assertEquals("Experience the difference", getTextFromPage(MainPage.SUBTITLE));
    }

    @Test
    @Order(2)
    @DisplayName("Register page is valid")
    public void testRegister() {
        clickOnPage(MainPage.REGISTRATION_LINK);
        Assertions.assertEquals("Signing up is easy!", getTextFromPage(Register.TITLE));
    }

    @Test
    @Order(3)
    @DisplayName("About Us page is valid")
    public void testAboutUs() {
        clickOnPage(MainPage.ABOUT_US);
        Assertions.assertTrue(getTextFromPage(AboutUs.TEXT_ABOUT).contains("not a real bank"));
    }
/*
   @Test
    @Order(4)
    @DisplayName("Fill the registration form")
    public void testRegistration() {
        Util.clickOnPage(MainPage.REGISTRATION_LINK);
        Util.sendKeysToField(Register.FIRST_NAME_FIELD, "Pocak");
        Util.sendKeysToField(Register.LAST_NAME_FIELD, "Honte");
        Util.sendKeysToField(Register.ADDRESS_FIELD, "Marvel str. 666");
        Util.sendKeysToField(Register.CITY_FIELD, "New New York");
        Util.sendKeysToField(Register.SSN_FIELD, "123_4545_12");
        Util.sendKeysToField(Register.STATE_FIELD, "Hawaiii");
        Util.sendKeysToField(Register.CONFIRM_FIELD, "Codecool123");
        Util.sendKeysToField(Register.PASSWORD_FIELD, "Codecool123");
        Util.sendKeysToField(Register.PHONE_FIELD, "123456789");
        Util.sendKeysToField(Register.USERNAME_FIELD, "pocak");
        Util.sendKeysToField(Register.ZIP_CODE_FIELD, "12345");
        Util.clickOnPage(Register.SUBMIT_BUTTON);
    }

*/
        @Test
        @Order(5)
        @DisplayName("After registrating you can log in")
            public void testLogin() throws InterruptedException {
            login();
            String actual = getTextFromPage(Overview.TITLE);
            Assertions.assertEquals("Accounts Overview", actual);
            logout();
            waitForMsec(2000);
            Assertions.assertEquals("Customer Login", getTextFromPage(MainPage.LOGIN_TITLE));
        }

        @Test
        @Order(6)
        @DisplayName("The new account's starting balance")
        public void testBalance() throws InterruptedException {
            waitForMsec(2000);
            login();
            waitForMsec(2000);
            Assertions.assertEquals("$1692.67", getTextFromPage(Overview.BALANCE));

            logout();
        }

        @Test
        @Order(7)
        @DisplayName("Make a new account and find it's number")
        public void testNewAccount() throws InterruptedException {
            waitForMsec(2000);
            login();
         //   Util.clickOnPage(Overview.NEW_ACCOUNT_MENU);
         //   Util.clickOnPage(OpenAccount.NEW_ACCOUNT_BUTTON);
            waitForMsec(2000);
 //           String newAccountId = Util.getTextFromPage(OpenAccount.NEW_ACCOUNT_ID);
//            System.out.println(newAccountId);

            clickOnPage(Overview.ACCOUNTS_OVERVIEW_MENU);

            String oldAccountId = getTextFromPage(Overview.ACCOUNT_FIRST_NUMBER);
      //      if (newAccountId.equals(oldAccountId)) {
             String newAccountId = getTextFromPage(Overview.ACCOUNT_SECOND_NUMBER);
       //     }
            System.out.println(oldAccountId + ", " + newAccountId);
            waitForMsec(200);
            clickOnPage(Overview.TRANSFER_FUNDS_MENU);
            waitForMsec(2000);
            sendKeysToField(TransferFunds.AMOUNT_FIELD, "125");
            clickOnPage(TransferFunds.ACCOUNT_FROM);
            clickOnPage(TransferFunds.ACCOUNT_FROM_SELECT1);
            clickOnPage((TransferFunds.ACCOUNT_TO));
            clickOnPage((TransferFunds.ACCOUNT_TO_SELECT2));
            waitForMsec(2000);
            logout();
        }

        @Test
        @Order(8)
        @DisplayName("Try to write out the tablecols names")
        public void testTableNames() {
            login();
            clickOnPage(Overview.ACCOUNTS_OVERVIEW_MENU);
            String colNames = getTextFromPage(Overview.TABLE_COL_NAMES);
            String[] cols = split(colNames);
            for (String i:cols) {
            System.out.println(i);}

        }

    @AfterAll
    static void collapseAll() {
    closeDriver();
    }
}
