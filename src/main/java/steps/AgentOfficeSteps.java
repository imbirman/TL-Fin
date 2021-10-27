package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.AgentOfficePage;

public class AgentOfficeSteps extends AgentOfficePage {

    AgentOfficePage page;

    @Step("Ожидание")
    public void wait_a_bit(){
        waitFor();
    }

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

    @Step("Ввод наименования отдела")
    public void set_name_department(String name){
        page.setNameDepartment(name);
    }

    @Step("Нажать кнопку")
    public void click_button(By button){
        page.clickButton(button);
    } // Нажать на кнопку

    @Step ("Навести курсор на пункт меню 'Кабинет агента'")
    public void mouse_hover(By element){
        page.mouseHover(element);
    } // Навести курсор на пункт меню "Кабинет агента"

    @Step ("Проверка, что кнопка для открытия кабинета агента отображается")
    public void is_visible_agent_office(){
        Assertions.assertThat(page.isVisibleAgentOfficeButton()).as("В левом меню отсутствует пункт 'Кабинет агента'").isTrue();
    }// Проверка, что кнопка для открытия кабинета агента отображается

    @Step ("Проверка, что меню кабинета агента отображается")
    public void is_visible_agent_office_menu_down(){
        Assertions.assertThat(page.isVisibleAgentOfficeMenuDown()).as("Меню кабинета агента не отобразилось").isTrue();
    }

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

    @Step ("Проверка, что блок для добавления сотрудника закрыт")
    public void is_visible_box_content_add_employees(){
        Assertions.assertThat(page.isVisibleBoxContentAddEmployees()).as("Блок для добавления сотрудника в отдел не закрылся").isFalse();
    }

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

    @Step ("Проверка, что название отдела, который добавили, соответствует ранее введенному")
    public void check_name_department(){
        Assertions.assertThat(page.getNameDepartmentByEditDepartment()).as("Название отдела некорректно").isEqualTo("Тестовый отдел");
    }

    @Step ("Проверка, что руководитель отдела, который добавили, соответствует ранее введенному")
    public void check_manager_department(){
        Assertions.assertThat(page.getManagerDepartmentByEditDepartment()).as("Руководитель отдела определился некорректно")
                .isEqualTo("ID: 34 - Гусев Павел Анатольевич");
    }

    @Step ("Проверка, что ФИО сотрудника, который добавили, соответствует ранее введенному")
    public void check_fio_employee(){
        Assertions.assertThat(page.getFIOEmployee()).as("ФИО добавленного сотрудника некорректно")
                .isEqualTo("Тестовый Сотрудник TlFin");
    }

    @Step("Проверка количества добавленных сотрудников")
    public void check_number_adding_employees(){
        Assertions.assertThat(page.getNumberAddingEmployees()).as("Количество добавленных сотрудников меньше или больше 2").isEqualTo(2);
    }

    @Step ("Удалить последний добавленный отдел")
    public void delete_adding_department(){
        page.deleteAddingDepartment();
    }

    @Step ("Нажать кнопку 'Сотрудники отдела' у последнего добавленного отдела")
    public void click_employees_office(){
        page.clickEmployeesOffice();
    }


}
