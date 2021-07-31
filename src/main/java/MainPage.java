import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainPage {
    public static final By REGISTRATION_LINK = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
    public static final By SUBTITLE = By.xpath("//*[@id=\"topPanel\"]/p");
    public static final By ABOUT_US = By.xpath("//*[@id=\"headerPanel\"]/ul[1]/li[2]/a");
    public static final By USERNAME_FIELD = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    public static final By PASSWORD_FIELD = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    public static final By LOGIN_TITLE = By.xpath("//*[@id=\"leftPanel\"]/h2");
}
