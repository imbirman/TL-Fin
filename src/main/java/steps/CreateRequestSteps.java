package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import pages.CreateRequestPage;


public class CreateRequestSteps{

    CreateRequestPage page;

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

    @Step("Нажать кнопку [0]")
    public void click_button(By button){
        page.clickButton(button);
    } // Нажать на кнопку

    @Step("Ввод реестрового номера")
    public void type_tender_number(String tender){
        page.typeTenderNumber(tender);
    } // Ввести номер тендера для БГ

    @Step("Выбор типа БГ")
    public void set_type_bg(){
        page.setTypeBG();
    } // Выбрать тип БГ

    @Step("Проверка ошибки при неуказанном типе БГ")
    public void check_error_empty_type_bg(){
        Assertions.assertThat(page.getErrorMessage())
                .as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Не выбран тип БГ");
    }

    @Step("Проверка ошибки при некорректном реестровом номере")
    public void check_error_empty_registry_number(){
        Assertions.assertThat(page.getErrorMessage())
                .as("Сообщение ошибки некорректно или отсутствует").isEqualTo("Введен некорректный реестровый номер");
    }

    @Step("Кнопка 'Создать заявку на БГ (закрытый тендер)' доступна при создании заявки без указания реестрового номера")
    public void check_close_tender_button(){
        Assertions.assertThat(page.getVisibilityCloseTenderButton())
                .as("Кнопка 'Создать заявку на БГ (закрытый тендер)' отсутствует").isTrue();
    }

    @Step("Кнопка 'Создать заявку на БГ по ФЗ-185, 615-ПП' доступна при создании заявки без указания реестрового номера")
    public void check_fz_tender_button(){
        Assertions.assertThat(page.getVisibilityFzTenderButton())
                .as("Кнопка 'Создать заявку на БГ по ФЗ-185, 615-ПП' отсутствует").isTrue();
    }

    @Step("Проверка на заполненность поля 'Ссылка на источник' по умолчанию")
    public void check_full_source_link(){
        Assertions.assertThat(page.getFullSourceLink())
                .as("Поле 'Ссылка на источник' не заполнена или некорректна!!!").isFalse();
    }

    @Step("Проверка на заполненность поля 'Сумма банковской гарантии' по умолчанию")
    public void check_sum_guarantee(){
        Assertions.assertThat(page.getSumGuarantee())
                .as("Поле 'Сумма банковской гарантии' не заполнена!!!").isFalse();
    }

    @Step("Проверка на выбор значения 'Да' блока 'Исполнение обязательств' по умолчанию")
    public void check_ex_guarantee_yes_rb(){
        Assertions.assertThat(page.getExGuaranteeYesRB())
                .as("В блоке 'Исполнение обязательств' не выбрано значение 'Да' по умолчанию!!!").isTrue();
    }

    @Step("Проверка на выбор значения 'Нет' блока 'Гарантия гарантийного периода' по умолчанию")
    public void check_warranty_guarantee_no_rb(){
        Assertions.assertThat(page.getWarrantyGuaranteeNoRB())
                .as("В блоке 'Гарантия гарантийного периода' не выбрано значение 'Нет' по умолчанию!!!").isTrue();
    }

    @Step("Проверка на выбор значения 'Нет' блока 'Возврат аванса' по умолчанию")
    public void check_prepayment_guarantee_no_rb(){
        Assertions.assertThat(page.getPrepaymentGuaranteeNoRB())
                .as("В блоке 'Возврат аванса' не выбрано значение 'Нет' по умолчанию!!!").isTrue();
    }

    @Step("Проверка на то, что чек-бокс 'Срок БГ с' проставлен по умолчанию")
    public void check_date_bg_from(){
        Assertions.assertThat(page.getDateBgFrom())
                .as("Не проставлен чек-бокс 'Срок БГ с'!!!").isTrue();
    }

    @Step("Ошибка: Необходимо заполнить поле «Срок БГ до».")
    public void check_error_message_expired(){
        Assertions.assertThat(page.getErrorMessageExpired())
                .as("Текст ошибки некорректен или отсутствует").isEqualTo("Необходимо заполнить поле «Срок БГ до».");
    }

    @Step("Ошибка: Необходимо заполнить поле «Срок выполнения работ/оказания услуг».")
    public void check_error_message_responsibility(){
        Assertions.assertThat(page.getErrorMessageResponsibility())
                .as("Текст ошибки некорректен или отсутствует").isEqualTo("Необходимо заполнить поле «Срок выполнения работ/оказания услуг».");
    }

    @Step("Ошибка: Необходимо заполнить поле «Вид контракта/договора».")
    public void check_error_message_contract(){
        Assertions.assertThat(page.getErrorMessageContract())
                .as("Текст ошибки некорректен или отсутствует").isEqualTo("Необходимо заполнить поле «Вид контракта/договора».");
    }

    @Step("Всплывающая ошибка содержит в себе: Необходимо заполнить поле «Срок БГ до».")
    public void check_text_error_message_expired_alert(){
        Assertions.assertThat(page.getTextErrorMessageAlert())
                .as("Всплывающая ошибка не содержит нужный текст").contains("Необходимо заполнить поле «Срок БГ до».");
    }

    @Step("Всплывающая ошибка содержит в себе: Необходимо заполнить поле «Срок выполнения работ/оказания услуг».")
    public void check_text_error_message_responsibility_alert(){
        Assertions.assertThat(page.getTextErrorMessageAlert())
                .as("Всплывающая ошибка не содержит нужный текст").contains("Необходимо заполнить поле «Срок выполнения работ/оказания услуг».");
    }

    @Step("Всплывающая ошибка содержит в себе: Необходимо заполнить поле «Вид контракта/договора».")
    public void check_text_error_message_contract_alert(){
        Assertions.assertThat(page.getTextErrorMessageAlert())
                .as("Всплывающая ошибка не содержит нужный текст").contains("Необходимо заполнить поле «Вид контракта/договора».");
    }

    @Step("Есть ли алерт ошибок при создании заявки")
    public void check_error_message_alert(){
        Assertions.assertThat(page.getErrorMessageAlert())
                .as("Всплывающая ошибка отсутствует").isTrue();
    }
    @Step("Скрытие полей в блоке 'Исполнение обязательств'")
    public void check_hide_ex_guarantee(){
        Assertions.assertThat(page.hideExGuarantee())
                .as("Блок 'Исполнение обязательств' не скрыт").isFalse();
    }

    @Step("Ввод срока БГ")
    public void set_required_expired_guarantee(){
        page.setRequiredExpiredGuarantee();
    }

    @Step("Ввод срока выполнения работ")
    public void set_required_responsibility_guarantee(){
        page.setRequiredResponsibilityGuarantee();
    }

    @Step("Ошибка: Не заполнено поле Сумма")
    public void check_error_message_sum(){
        Assertions.assertThat(page.getErrorMessageSum())
                .as("Текст ошибки некорректен или отсутствует").isEqualTo("Не заполнено поле Сумма");
    }

    @Step("Всплывающая ошибка содержит в себе: Не заполнено поле Сумма")
    public void check_text_error_message_sum_alert(){
        Assertions.assertThat(page.getTextErrorMessageAlert())
                .as("Всплывающая ошибка не содержит нужный текст").contains("Не заполнено поле Сумма");
    }

    @Step("Ввести значение в поле 'Сумма' в блоке 'Исполнение обязательств'")
    public void set_invalid_text_required_sum(){
        page.setInvalidRRequiredSum("test123/*");
    }

    @Step("Проверка на некорректное значение в поле 'Сумма' в блоке 'Исполнение обязательств'")
    public void check_invalid_text_required_sum(){
        Assertions.assertThat(page.getErrorMessageSum())
                .as("Текст ошибки некорректен или отсутствует").isEqualTo("Сумма должна быть числом");
    }

    @Step("Всплывающая ошибка содержит в себе: Сумма должна быть числом")
    public void check_invalid_error_message_sum_alert(){
        Assertions.assertThat(page.getTextErrorMessageAlert())
                .as("Всплывающая ошибка не содержит нужный текст").contains("Сумма должна быть числом");
    }

    @Step("Проверка продолжения создания заявки при отключении исполнения обязательств")
    public void check_switch_expired_guarantee(){
        Assertions.assertThat(page.isVisibleBoxSelectBank())
                .as("Ошибка в логике работы скрытия полей в блоке 'Исполнение обязательств'").isTrue();
    }


}
