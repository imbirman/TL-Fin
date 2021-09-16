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
    @Pending
    @Title("Проверка создания заявки")
    public void checkCreateRequest(){

        steps.open_login_main_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("P5@Dst");
        steps.click_button(signInButton);
        steps.click_button(createRequestButton);
        steps.click_button(bank);
        steps.click_button(createNewCard);
        steps.type_tender_number("0158300043421000067");
        steps.set_type_bg();
        steps.click_button(getDataTender);


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
        steps.set_type_bg();
        steps.click_button(getDataTender);
        steps.check_error_empty_registry_number();
        steps.check_fz_tender_button();
        steps.check_close_tender_button();
    }
}
