package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.AgentOfficePage;
import steps.AgentOfficeSteps;

@RunWith(SerenityRunner.class)
public class WhenAgentOffice extends AgentOfficePage {

    @Steps
    AgentOfficeSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Проверка, что кнопка для открытия кабинета агента отображается")
    public void checkVisibleAgentOffice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.is_visible_agent_office();
    }

    @Test
    @Title("Проверка, что открывается меню кабинета агента")
    public void checkVisibleMenuAgentOffice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.open_menu_down_agent_office();
        steps.is_visible_menu_down_agent_office();
        steps.is_visible_menu_down_list_users();
        steps.is_visible_menu_down_reports();
    }

}
