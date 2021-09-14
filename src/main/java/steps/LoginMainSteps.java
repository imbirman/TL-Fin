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
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("s.kosobutskiy▼");
    } // Проверка логина админа после входа

    @Step
    public void check_login_agent(){  // Проверка имени агента после входа
        Assertions.assertThat(page.getCuratorName()).isEqualTo("Мишин Михаил");
    }

    @Step
    public void check_login_agent_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("broker-test▼");
    } // Проверка логина агента после входа

    @Step
    public void check_login_client_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("absolut▼");
    } // Проверка логина клиента после входа

    @Step
    public void check_login_bank_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("psb-test▼");
    } // Проверка логина банка после входа

    @Step
    public void check_enabled_sidebar(){
        Assertions.assertThat(page.getDisplayedSidebar()).isTrue();
    }

    @Step
    public void check_number_elements_table(){
        Assertions.assertThat(page.getRows().size()).isEqualTo(10);
    }

}
