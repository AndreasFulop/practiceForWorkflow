import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParabankTests {

    public static void login() {
        String username = Util.fileReader("username");
        String password = Util.fileReader("password");
        Util.sendKeysToField(MainPage.USERNAME_FIELD, username);
        Util.sendKeysToField(MainPage.PASSWORD_FIELD, password);
        Util.clickOnPage(MainPage.LOGIN_BUTTON);
    }

    public static void logout() {
        Util.clickOnPage(Overview.LOGOUT_MENU);
    }

        @BeforeEach
    public void driverInit() {
        Util.getDriver().get("https://parabank.parasoft.com/");
    }

    @Test
    @Order(1)
    @DisplayName("Main page is valid")
    public void testMainPageSubtitle() {
        Assertions.assertEquals("Experience the difference", Util.getTextFromPage(MainPage.SUBTITLE));
    }

    @Test
    @Order(2)
    @DisplayName("Register page is valid")
    public void testRegister() {
        Util.clickOnPage(MainPage.REGISTRATION_LINK);
        Assertions.assertEquals("Signing up is easy!", Util.getTextFromPage(Register.TITLE));
    }

    @Test
    @Order(3)
    @DisplayName("About Us page is valid")
    public void testAboutUs() {
        Util.clickOnPage(MainPage.ABOUT_US);
        Assertions.assertTrue(Util.getTextFromPage(AboutUs.TEXT_ABOUT).contains("not a real bank"));
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
            String actual = Util.getTextFromPage(Overview.TITLE);
            Assertions.assertEquals("Accounts Overview", actual);
            logout();
            Util.waitForMsec(2000);
            Assertions.assertEquals("Customer Login", Util.getTextFromPage(MainPage.LOGIN_TITLE));
        }

        @Test
        @Order(6)
        @DisplayName("The new account's starting balance")
        public void testBalance() throws InterruptedException {
            Util.waitForMsec(2000);
            login();
            Util.waitForMsec(2000);
            Assertions.assertEquals("$1692.67", Util.getTextFromPage(Overview.BALANCE));

            logout();
        }

        @Test
        @Order(7)
        @DisplayName("Make a new account and find it's number")
        public void testNewAccount() throws InterruptedException {
            Util.waitForMsec(2000);
            login();
         //   Util.clickOnPage(Overview.NEW_ACCOUNT_MENU);
         //   Util.clickOnPage(OpenAccount.NEW_ACCOUNT_BUTTON);
            Util.waitForMsec(2000);
 //           String newAccountId = Util.getTextFromPage(OpenAccount.NEW_ACCOUNT_ID);
//            System.out.println(newAccountId);

            Util.clickOnPage(Overview.ACCOUNTS_OVERVIEW_MENU);

            String oldAccountId = Util.getTextFromPage(Overview.ACCOUNT_FIRST_NUMBER);
      //      if (newAccountId.equals(oldAccountId)) {
             String newAccountId = Util.getTextFromPage(Overview.ACCOUNT_SECOND_NUMBER);
       //     }
            System.out.println(oldAccountId + ", " + newAccountId);
            Util.waitForMsec(200);
            Util.clickOnPage(Overview.TRANSFER_FUNDS_MENU);
            Util.waitForMsec(2000);
            Util.sendKeysToField(TransferFunds.AMOUNT_FIELD, "125");
            Util.clickOnPage(TransferFunds.ACCOUNT_FROM);
            Util.clickOnPage(TransferFunds.ACCOUNT_FROM_SELECT1);
            Util.clickOnPage((TransferFunds.ACCOUNT_TO));
            Util.clickOnPage((TransferFunds.ACCOUNT_TO_SELECT2));
            Util.waitForMsec(2000);
            logout();

        }

    @AfterAll
    static void collapseAll() {
    Util.closeDriver();
    }
}
