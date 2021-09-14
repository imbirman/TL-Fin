package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginMainPage;
import steps.LoginMainSteps;

@RunWith(SerenityRunner.class)
public class WhenLoginMenuPage extends LoginMainPage {

    @Steps
    LoginMainSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Проверка корректного входа админа")
    public void checkCorrectLoginAdmin(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.check_login_admin();
        steps.check_login_admin_menu();
    }
}
