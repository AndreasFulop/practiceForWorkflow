import org.openqa.selenium.By;

public class Register {
   public static final By TITLE = By.xpath("//*[@id=\"rightPanel\"]/h1");

   public static final By FIRST_NAME_FIELD = By.id("customer.firstName");
   public static final By LAST_NAME_FIELD = By.id("customer.lastName");
   public static final By ADDRESS_FIELD = By.id("customer.address.street");
   public static final By CITY_FIELD = By.id("customer.address.city");
   public static final By STATE_FIELD = By.id("customer.address.state");
   public static final By ZIP_CODE_FIELD = By.id("customer.address.zipCode");
   public static final By PHONE_FIELD = By.id("customer.phoneNumber");
   public static final By SSN_FIELD = By.id("customer.ssn");
   public static final By USERNAME_FIELD = By.id("customer.username");
   public static final By PASSWORD_FIELD = By.id("customer.password");
   public static final By CONFIRM_FIELD = By.id("repeatedPassword");
   public static final By SUBMIT_BUTTON = By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input");
}
