package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class CreateRequestPage extends PageObject {

    private By loginField = By.id("LoginForm_login");
    private By passwordField = By.id("LoginForm_password");
    protected By signInButton = By.xpath("//input[@type='submit']"); // Кнопка входа
    protected By createRequestButton = By.xpath("//li[@id='ClientListItem']"); // Кнопка меню "Создать заявку"
    protected By bank = By.xpath("//a[@href='/client/11']"); //
    protected By createNewCard = By.id("createNewCard"); // Кнопка "Создать заявку на БГ"
    private By cardRegNumber = By.id("Card_regnumber"); // Поле для воода реестрового номера
    private By radioButtonEnsuringTender = By.id("Card_bg_type_0"); // Выбор типа БГ
    protected By getDataTender = By.id("GetTenderInfoBtn"); // Кнопка "Получить данные" (получение данные для заявки из тендера)
    private By errorMessage= By.xpath("//p[@class='errorMessage']");
    private By createRequestCloseTenderButton = By.xpath("//a[text()='Создать заявку на БГ (закрытый тендер)']");
    private By createRequestFz = By.xpath("//a[text()='Создать заявку на БГ по ФЗ-185, 615-ПП']");
    private By sourceLink = By.id("Card_link"); // Поле "Ссылка на источник"
    private By executionGuaranteeYesRB = By.id("Card_need_exec_guarantee_0"); // radiobutton "исполнение обязательств" - да
    private By warrantyGuaranteeNoRB = By.id("Card_need_warr_guarantee_1"); // radiobutton "Гарантия гарантийного периода" - нет
    private By prepaymentGuaranteeNoRB = By.id("Card_need_avans_guarantee_1"); // radiobutton "Возврат аванса" - нет
    private By sumGuarantee = By.id("Card_guarantee_sum"); // Поле "Сумма банковской гарантии"
    private By dateBgFromChB = By.id("from_cur_date"); // Чек-бокс "Срок БГ с даты выдачи"



    public void clickButton(By button){ // Клик по кнопке
        find(button).click();
    }

    public CreateRequestPage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    }

    public CreateRequestPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    }

    public CreateRequestPage typeTenderNumber(String tender){
        find(cardRegNumber).sendKeys(tender);
        return this;
    } // Поиск поля реестрового номера и ввод значения

    public CreateRequestPage setTypeBG(){
        find(radioButtonEnsuringTender).click();
        return this;
    } // Выбор типа БГ

    public String getErrorMessage(){
        return find(errorMessage).getText();
    } // Получение текста ошибки

    public boolean getVisibilityCloseTenderButton(){
        return find(createRequestCloseTenderButton).isDisplayed();
    } // Проверка доступности кнопки для создания заявки на БГ для закрытого тендера

    public boolean getVisibilityFzTenderButton(){
        return find(createRequestFz).isDisplayed();
    } // Проверка доступности кнопки для создания заявки на БГ по ФЗ-185, 615-ПП

    public boolean getFullSourceLink(){
        String fullSourceLink;
        fullSourceLink = find(sourceLink).getText();
        return fullSourceLink.isEmpty();
    } // Проверка, что в поле есть ссылка

    public boolean getExGuaranteeYesRB(){
        return find(executionGuaranteeYesRB).isSelected();
    } // Проверка, что по умолчанию выбрано "Да" в блоке "Исполнение обязательств"

    public boolean getWarrantyGuaranteeNoRB(){
        return find(warrantyGuaranteeNoRB).isSelected();
    } // Проверка, что по умолчанию выбрано "Нет" в блоке "Гарантия гарантийного периода"

    public boolean getPrepaymentGuaranteeNoRB(){
        return find(prepaymentGuaranteeNoRB).isSelected();
    } // Проверка, что по умолчанию выбрано "Нет" в блоке "Возврат аванса"

    public boolean getSumGuarantee(){
        String sumGuarantee;
        sumGuarantee = find(prepaymentGuaranteeNoRB).getText();
        return sumGuarantee.isEmpty();
    } // Проверка, что поле "Сумма банковской гарантии" заполнено



}
