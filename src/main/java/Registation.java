import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Registation {
   private static final By REGISTRATION_LINK = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");

   public static void registrationClick() {
      Util.getDriver().findElement(REGISTRATION_LINK).click();
   }

   public static WebElement getSubtitle() {
      WebElement subtitle = Util.getDriver().findElement(By.xpath("//*[@id=\"topPanel\"]/p"));
      return subtitle;
   }
}
