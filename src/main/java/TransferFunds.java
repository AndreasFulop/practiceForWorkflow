import org.openqa.selenium.By;

public class TransferFunds {

    public static final By AMOUNT_FIELD= By.id("amount");
    public static final By ACCOUNT_FROM = By.id("fromAccountId");
    public static final By ACCOUNT_FROM_SELECT1 = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");

    public static final By ACCOUNT_TO = By.id("toAccountId");
    public static final By ACCOUNT_TO_SELECT2 = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
}
