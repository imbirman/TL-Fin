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
        Assertions.assertThat(page.getErrorMessage())
                .as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Не выбран тип БГ");
    }

    @Step
    public void check_error_empty_registry_number(){
        Assertions.assertThat(page.getErrorMessage())
                .as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Введен некорректный реестровый номер");
    }

    @Step
    public void check_close_tender_button(){
        Assertions.assertThat(page.getVisibilityCloseTenderButton())
                .as("Кнопка 'Создать заявку на БГ (закрытый тендер)' отсутствует").isTrue();
    }

    @Step
    public void check_fz_tender_button(){
        Assertions.assertThat(page.getVisibilityFzTenderButton())
                .as("Кнопка 'Создать заявку на БГ по ФЗ-185, 615-ПП' отсутствует").isTrue();
    }

    @Step
    public void check_full_source_link(){
        Assertions.assertThat(page.getFullSourceLink()).as("Поле 'Ссылка на источник' не заполнена!!!").isFalse();
    }

    @Step
    public void check_sum_guarantee(){
        Assertions.assertThat(page.getSumGuarantee())
                .as("Поле 'Сумма банковской гарантии' не заполнена!!!").isFalse();
    }

    @Step
    public void check_ex_guarantee_yes_rb(){
        Assertions.assertThat(page.getExGuaranteeYesRB())
                .as("В блоке 'Исполнение обязательств' не выбрано значение 'Да' по умолчанию!!!").isTrue();
    }

    @Step
    public void check_warranty_guarantee_no_rb(){
        Assertions.assertThat(page.getWarrantyGuaranteeNoRB())
                .as("В блоке 'Гарантия гарантийного периода' не выбрано значение 'Нет' по умолчанию!!!").isTrue();
    }

    @Step
    public void check_prepayment_guarantee_no_rb(){
        Assertions.assertThat(page.getPrepaymentGuaranteeNoRB())
                .as("В блоке 'Возврат аванса' не выбрано значение 'Нет' по умолчанию!!!").isTrue();
    }


}
