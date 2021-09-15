package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.CreateRequestPage;


public class CreateRequestSteps{

    CreateRequestPage page;

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
    public void type_tender_number(String tender){
        page.typeTenderNumber(tender);
    } // Ввести номер тендера для БГ

    @Step
    public void set_type_bg(){
        page.setTypeBG();
    } // Выбрать тип БГ

    @Step
    public void check_error_empty_type_bg(){
        Assertions.assertThat(page.getErrorMessage()).as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Не выбран тип БГ");
    }

    @Step
    public void check_error_empty_registry_number(){
        Assertions.assertThat(page.getErrorMessage()).as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Введен некорректный реестровый номер");
    }

    @Step
    public void check_close_tender_button(){
        Assertions.assertThat(page.getVisibilityCloseTenderButton()).as("Кнопка 'Создать заявку на БГ (закрытый тендер)' отсутствует").isTrue();
    }

    @Step
    public void check_fz_tender_button(){
        Assertions.assertThat(page.getVisibilityCloseTenderButton()).as("Кнопка 'Создать заявку на БГ по ФЗ-185, 615-ПП' отсутствует").isTrue();
    }



}
