import org.openqa.selenium.By;

public class Overview {
    public static final By TITLE = By.xpath("//*[@id=\"rightPanel\"]/div/div/h1");
    public static final By LOGOUT_MENU = By.cssSelector("#leftPanel > ul > li:nth-child(8) > a");
    public static final By BALANCES = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]");
    public static final By BALANCES2 = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]");
    public static final By BALANCES4 = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[4]");
    public static final By BALANCE = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[2]/b");
    public static final By NEW_ACCOUNT_MENU = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    public static final By TRANSFER_FUNDS_MENU = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    public static final By ACCOUNTS_OVERVIEW_MENU = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");

    public static final By ACCOUNT_NUMBERS = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[i]/td[1]/a");
    public static final By ACCOUNT_FIRST_NUMBER = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    public static final By ACCOUNT_SECOND_NUMBER = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a");

}

