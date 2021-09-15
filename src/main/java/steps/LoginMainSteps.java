package steps;

import net.thucydides.core.annotations.Step;

import net.thucydides.junit.annotations.UseTestDataFrom;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.LoginMainPage;

public class LoginMainSteps{

    LoginMainPage page;

    @Step
    public void open_login_main_page(){
        page.open();
    } // Открыть страницу сайта

    @Step
    public void type_email(String mail){
        page.typeEmail(mail);
    } // Ввести данные логина

    @Step
    public void type_password(String password){
        page.typePassword(password);
    } // Ввести данные пароля

    @Step
    public void click_button(By button){
        page.clickButton(button);
    } // Нажать на кнопку

    @Step
    public void check_login_admin(){ // Проверка имени админа после входа
        Assertions.assertThat(page.getCuratorName()).isEqualTo("Ярцев Денис");
    }
    @Step
    public void check_login_admin_menu(){
        Assertions.assertThat(page.getLoginMenu()).as("Логин несоответствует введенному при входе").isEqualTo("s.kosobutskiy▼");
    } // Проверка логина админа после входа

    @Step
    public void check_login_agent(){  // Проверка имени агента после входа
        Assertions.assertThat(page.getCuratorName()).isEqualTo("Мишин Михаил");
    }

    @Step
    public void check_login_agent_menu(){
            Assertions.assertThat(page.getLoginMenu()).as("Логин несоответствует введенному при входе").isEqualTo("broker-test▼");
    } // Проверка логина агента после входа

    @Step
    public void check_login_client_menu(){
        Assertions.assertThat(page.getLoginMenu()).as("Логин несоответствует введенному при входе").isEqualTo("absolut▼");
    } // Проверка логина клиента после входа

    @Step
    public void check_login_bank_menu(){
        Assertions.assertThat(page.getLoginMenu()).as("Логин несоответствует введенному при входе").isEqualTo("psb-test▼");
    } // Проверка логина банка после входа

    @Step
    public void check_enabled_sidebar(){
        Assertions.assertThat(page.getDisplayedSidebar()).isFalse();
    } // Проверка скрытия меню таблицы

    @Step
    public void check_number_elements_table(int number){

        switch (number) {
            case 10:
                Assertions.assertThat(page.getRows().size()).isEqualTo(10);
                break;
            case 25:
                Assertions.assertThat(page.getRows().size()).isEqualTo(25);
                break;
            case 50:
                Assertions.assertThat(page.getRows().size()).isEqualTo(50);
                break;
            case 100:
                Assertions.assertThat(page.getRows().size()).isEqualTo(100);
                break;
        }
    } // Проверка количества элементов в таблице

}
