package steps;

import net.thucydides.core.annotations.Step;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.LoginMainPage;

public class LoginMainSteps{

    LoginMainPage page;

    @Step
    public void open_login_main_page(){
        page.open();
    }

    @Step
    public void type_email(String mail){
        page.typeEmail(mail);
    }

    @Step
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step
    public void click_button(By button){
        page.clickButton(button);
    }

    @Step
    public void check_login_admin(){
        Assertions.assertThat(page.getCuratorName()).isEqualTo("Ярцев Денис");
    }
    @Step
    public void check_login_admin_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("s.kosobutskiy▼");
    }

    @Step
    public void check_login_agent(){
        Assertions.assertThat(page.getCuratorName()).isEqualTo("Мишин Михаил");
    }

    @Step
    public void check_login_agent_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("broker-test▼");
    }

    @Step
    public void check_login_client_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("absolut▼");
    }

    @Step
    public void check_login_bank_menu(){
        Assertions.assertThat(page.getLoginMenu()).isEqualTo("psb-test▼");
    }


}
