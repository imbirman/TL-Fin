package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.AgentOfficePage;

public class AgentOfficeSteps {

    AgentOfficePage page;

    @Step("Открытие страницы")
    public void open_login_main_page(){
        page.open();
    } // Открыть страницу сайта

    @Step("Ввод логина")
    public void type_email(String mail){
        page.typeEmail(mail);
    } // Ввести данные логина

    @Step("Ввод пароля")
    public void type_password(String password){
        page.typePassword(password);
    } // Ввести данные пароля

    @Step("Нажать кнопку")
    public void click_button(By button){
        page.clickButton(button);
    } // Нажать на кнопку

    @Step ("Навести курсор на пункт меню 'Кабинет агента'")
    public void open_menu_down_agent_office(){page.openMenuDownAgentOffice();} // Навести курсор на пункт меню "Кабинет агента"

    @Step ("Проверка, что кнопка для открытия кабинета агента отображается")
    public void is_visible_agent_office(){
        Assertions.assertThat(page.isVisibleAgentOfficeButton()).as("В левом меню отсутствует пункт 'Кабинет агента'").isTrue();
    }// Проверка, что кнопка для открытия кабинета агента отображается

    @Step ("Проверка, что пункт 'Кабинет агента' в меню кабинета агента отображается")
    public void is_visible_menu_down_agent_office(){
        Assertions.assertThat(page.isVisibleAgentOfficeMenuDownButton()).as("Отсутствует пункт 'Кабинет агента' в меню кабинета агента").isTrue();
    }// Проверка, что пункт 'Кабинет агента' в меню кабинета агента отображается

    @Step ("Проверка, что пункт 'Список пользователей' в меню кабинета агента отображается")
    public void is_visible_menu_down_list_users(){
        Assertions.assertThat(page.isVisibleListUsersMenuDownButton()).as("Отсутствует пункт 'Список пользователей' в меню кабинета агента").isTrue();
    }// Проверка, что пункт 'Список пользователей' в меню кабинета агента отображается

    @Step ("Проверка, что пункт 'Отчеты' в меню кабинета агента отображается")
    public void is_visible_menu_down_reports(){
        Assertions.assertThat(page.isVisibleReportsAgentOfficeMenuDownButton()).as("Отсутствует пункт 'Отчеты' в меню кабинета агента").isTrue();
    }// Проверка, что пункт 'Отчеты' в меню кабинета агента отображается

    @Step ("Проверка, что название пункта меню кабинета агента 'Кабинет агента' корректно")
    public void check_text_menu_down_agent_office(){
        Assertions.assertThat(page.getTextMenuDownAgentOfficeButton()).as("Название некорректно").isEqualTo("Кабинет агента");
    } // Проверка, что название пункта меню кабинета агента "Кабинет агента" корректно

    @Step ("Проверка, что название пункта меню кабинета агента 'Список пользователей' корректно")
    public void check_text_menu_down_list_users(){
        Assertions.assertThat(page.getTextMenuDownListUsersAgentOfficeButton()).as("Название некорректно").isEqualTo("Список пользователей");
    } // Проверка, что название пункта меню кабинета агента "Список пользователей" корректно

    @Step ("Проверка, что название пункта меню кабинета агента 'Отчеты' корректно")
    public void check_text_menu_down_reports(){
        Assertions.assertThat(page.getTextMenuDownReportsAgentOfficeButton()).as("Название некорректно").isEqualTo("Отчеты");
    } // Проверка, что название пункта меню кабинета агента "Отчеты" корректно


}
