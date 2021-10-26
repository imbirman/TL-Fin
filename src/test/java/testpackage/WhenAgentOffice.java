package testpackage;

import net.serenitybdd.core.steps.ScenarioActor;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AgentOfficePage;
import steps.AgentOfficeSteps;

@RunWith(SerenityRunner.class)
public class WhenAgentOffice extends AgentOfficePage {

    AgentOfficePage page;


    @Managed(driver = "chrome", uniqueSession=true)
    WebDriver driver;


    @Steps
    AgentOfficeSteps steps;

    @Test
    @Title("Проверка, что кнопка для открытия кабинета агента отображается")
    public void checkVisibleAgentOffice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.is_visible_agent_office();
        steps.click_button(agentOfficeMenuButton);
    }

    @Test
    @Title("Проверка меню кабинета агента")
    public void checkVisibleMenuAgentOffice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
//        steps.click_button(agentOfficeMenuButton);
        steps.mouse_hover(agentOfficeMenuButton);
        steps.is_visible_agent_office_menu_down();
        steps.is_visible_menu_down_agent_office();
        steps.is_visible_menu_down_list_users();
        steps.is_visible_menu_down_reports();
        steps.check_text_menu_down_agent_office();
        steps.check_text_menu_down_list_users();
        steps.check_text_menu_down_reports();
    }

    @Test
    @Title("Проверка наименования и руководителя отдела после добавления")
    public void checkNameAndManagerDepartment(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(agentOfficeMenuButton);
        steps.click_button(tabDepartment);
        steps.click_button(addDepartment);
        steps.set_name_department("Тестовый отдел");
        steps.click_button(managerDepartmentByAddDepartment);
        steps.waitFor();
        steps.click_button(selectManagerDepartment34);
        steps.click_button(saveAddDepartment);
        steps.check_name_department();
        steps.check_manager_department();
        steps.delete_adding_department();
    }

}
