import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParabankTests {

    @Test
    public void testRegistration() {
        Util.getDriver().get("https://parabank.parasoft.com/");
        Registation.registrationClick();
        Assertions.assertEquals("Experience the difference", Registation.getSubtitle().getText());
    }
}
