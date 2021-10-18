package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.CreateRequestPage;
import steps.CreateRequestSteps;

@RunWith(SerenityRunner.class)
public class WhenCreateRequest  extends CreateRequestPage {

    @Steps
    CreateRequestSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Проверка создания заявки (Участие в конкурсе / Контракт)")
    public void checkCreateRequest(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.click_button(electronicFormatBg);
        steps.click_button(submitSelectBank);
        steps.click_button(tabParametersAfterCreateRequest);
        steps.check_is_equal_required_expired_guarantee();
        steps.check_is_selected_execution_guarantee_yes_rb();
        steps.check_sum_guarantee_after_create_request();
        steps.check_is_equal_sum_guarantee();
    }

    @Test
    @Title("Проверка ошибки при создании заявки без выбора типа БГ")
    public void checkErrorMessageEmptyTypeBg(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(getDataTender);
        steps.check_error_empty_type_bg();

    }

    @Test
    @Title("Проверка ошибки при создании заявки без указания реестрового номера")
    public void checkErrorMessageEmptyRegistryNumber(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.check_error_empty_registry_number();
        steps.check_fz_tender_button();
        steps.check_close_tender_button();
    }

    @Test
    @Title("Проверка заполнения полей по умолчанию после получения данных тендера")
    public void checkDefaultFields(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.check_full_source_link();
        steps.check_sum_guarantee();
        steps.check_ex_guarantee_yes_rb();
        steps.check_warranty_guarantee_no_rb();
        steps.check_prepayment_guarantee_no_rb();
        steps.check_date_bg_from();
    }

    @Test
    @Title("Проверка ошибки при незаполнении обязательного поля 'Срок БГ до *'")
    public void checkRequiredFieldExpired(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_error_message_expired();
    }

    @Test
    @Title("Проверка ошибки при не выборе значения 'Тип обеспечения контракта'")
    public void checkErrorMessageTypeEnsuringContract(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(createCard);
        steps.check_error_message_type_ensuring_contract();
    }

    @Test
    @Title("Проверка ошибки при незаполнении обязательного поля 'Срок выполнения работ/оказания услуг *'")
    public void checkRequiredFieldResponsibility(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_error_message_responsibility();
    }

    @Test
    @Title("Проверка ошибки при незаполнении обязательного поля 'Итоговая цена контракта/договора'")
    public void checkErrorMessageResultPrice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(createCard);
        steps.check_error_message_result_price();
    }

    @Test
    @Title("Проверка ошибки при не выборе пункта обязательного блока 'Вид контракта/договора *")
    public void checkRequiredFieldContract(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_error_message_contract();
    }

    @Test
    @Title("Проверка ошибки, если не заполнено поле 'Сумма' в блоке 'Исполнение обязательств'")
    public void checkRequiredExpiredGuarantee(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeYesRB);
        steps.click_button(createCard);
        steps.check_error_message_sum();
    }

    @Test
    @Title("Проверка наличия алерта с ошибками")
    public void checkErrorAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_error_message_alert();
    }

    @Test
    @Title("Проверка скрытия алерта с ошибками при нажатии на крестик")
    public void checkVisibleErrorMessageAlertForm(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.click_button(closeAlertButton);
        steps.check_visible_error_message_alert_form();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - ошибка поля 'Срок БГ до *'")
    public void checkErrorExpiredAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_text_error_message_expired_alert();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - содержит ошибку 'Не выбран тип обеспечения контракта'")
    public void checkErrorTypeEnsuringContractAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(createCard);
        steps.check_text_error_message_type_ensuring_contract_alert();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - содержит ошибку 'Не заполнено поле «Итоговая цена контракта/договора»")
    public void checkErrorResultPriceAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(createCard);
        steps.check_text_error_message_result_price_alert();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - ошибка поля 'Срок выполнения работ/оказания услуг *'")
    public void checkErrorResponsibilityAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_text_error_message_responsibility_alert();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - ошибка поля 'Вид контракта/договора *'")
    public void checkErrorContractAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(createCard);
        steps.check_text_error_message_contract_alert();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - ошибка поля 'Сумма' в блоке 'Исполнение обязательств'")
    public void checkErrorSumAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeYesRB);
        steps.click_button(createCard);
        steps.check_text_error_message_sum_alert();
    }

    @Test
    @Title("Проверка скрытия элементов при выборе в блоке 'Исполнение обязательств' значения 'Нет'")
    public void checkHideExGuarantee(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(executionGuaranteeNoRB);
        steps.check_hide_ex_guarantee();
    }

    @Test
    @Title("Проверка на некорректное значение в поле 'Сумма' в блоке 'Исполнение обязательств'")
    public void checkInvalidRequiredSum(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeYesRB);
        steps.set_invalid_text_required_sum();
        steps.click_button(createCard);
        steps.check_invalid_text_required_sum();
    }

    @Test
    @Title("Проверка на некорректное значение в поле 'Итоговая цена контракта/договора'")
    public void checkInvalidResultPrice(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(radioButtonSecurityGuarantee);
        steps.set_invalid_result_price();
        steps.click_button(createCard);
        steps.check_invalid_result_price();
    }

    @Test
    @Title("Проверка алерта при некорректном значении в поле 'Итоговая цена контракта/договора'")
    public void checkInvalidResultPriceAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(radioButtonSecurityGuarantee);
        steps.set_invalid_result_price();
        steps.click_button(createCard);
        steps.check_invalid_result_price_alert();
    }

    @Test
    @Title("Проверка алерта при некорректном значении в поле 'Срок (месяцев)' в блоке 'Исполнение обязательств'")
    public void checkInvalidRequiredSumAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeYesRB);
        steps.set_invalid_text_required_sum();
        steps.click_button(createCard);
        steps.check_invalid_error_message_time_alert();
    }

    @Test
    @Title("Проверка логики работы скрытия полей в блоке 'Исполнение обязательств'")
    public void checkSwitchExpiredGuarantee(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeYesRB);
        steps.set_invalid_text_required_sum();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.check_switch_expired_guarantee();
    }

    @Test
    @Title("Проверка текста алерта с ошибками - Необходимо отметить, требуется ли бумажная БГ")
    public void checkErrorFormatBgAlert(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.set_required_responsibility_guarantee();
        steps.set_required_expired_guarantee();
        steps.click_button(requiredContractGuarantee);
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.click_button(submitSelectBank);
        steps.check_text_error_message_format_bg_alert();
    }

    @Test
    @Title("Проверка отображения блока с выбором формата БГ")
    public void checkSelectFormatBG(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.set_required_expired_guarantee();
        steps.set_required_responsibility_guarantee();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.check_select_format_bg();
    }

    @Test
    @Title("Проверка отображения блока с выбором доставки оригинала")
    public void checkSelectDeliveryOriginal(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.set_required_expired_guarantee();
        steps.set_required_responsibility_guarantee();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.click_button(paperFormatBg);
        steps.check_select_delivery_original();
    }

    @Test
    @Title("Проверка отображения минимального тарифа доставки")
    public void checkMinimumTariffDelivery(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.set_required_expired_guarantee();
        steps.set_required_responsibility_guarantee();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.click_button(paperFormatBg);
        steps.click_button(deliveryYes);
        steps.check_minimum_tariff_delivery();
    }

    @Test
    @Title("Проверка скрытия минимального тарифа доставки")
    public void checkHideMinimumTariffDelivery(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.set_required_expired_guarantee();
        steps.set_required_responsibility_guarantee();
        steps.click_button(executionGuaranteeNoRB);
        steps.click_button(createCard);
        steps.click_button(bankToSelect);
        steps.click_button(paperFormatBg);
        steps.click_button(deliveryYes);
        steps.click_button(electronicFormatBg);
        steps.check_hide_minimum_tariff_delivery();
    }

    @Test
    @Title("Проверка сохранения суммы банковской гарантии при изменении типа БГ")
    public void checkNotEmptySumGuarantee(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.click_button(radioButtonExecutionGuarantee);
        steps.click_button(getDataTender);
        steps.click_button(requiredContractGuarantee);
        steps.click_button(radioButtonEnsuringTender);
        steps.click_button(radioButtonExecutionGuarantee);
        steps.check_sum_guarantee();

    }


}
