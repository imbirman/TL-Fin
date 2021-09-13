package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.SignUpPage;

public class SignUpSteps {
    SignUpPage page;

    @Step
    public void open_signup_page(){
        page.open();
    }

    @Step// в скобках описание шага
    public void type_email(String mail){
        page.typeEmail(mail);
    }

    @Step
    public void type_password(String password){
        page.typePassword(password);
    }

    @Step
    public void set_chek_remember(boolean check){
        page.setCheckRemember(check);
    }

    @Step
    public void click_sign_button(){
        page.clickSignButton();
    }

    @Step
    public void error_login_visible(){
        Assertions.assertThat(page.errorLoginVisible()).as("Not visible error of invalid login").isTrue();

    }

    @Step
    public void error_password_visible(){
        Assertions.assertThat(page.errorPasswordVisible()).as("Not visible error of invalid password or sign in").isTrue();

    }

    @Step
    public void check_text_error_login(){
        Assertions.assertThat(page.getErrorLogin()).isEqualTo("Необходимо заполнить поле «Логин».");
    }

    @Step
    public void check_text_error_password(){
        Assertions.assertThat(page.getErrorPassword()).isEqualTo("Необходимо заполнить поле «Пароль».");
    }

    @Step
    public void check_text_invalid_sign(){
        Assertions.assertThat(page.getErrorPassword()).isEqualTo("Неправильный логин или пароль");
    }
}
