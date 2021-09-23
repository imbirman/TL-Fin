package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class CreateRequestPage extends PageObject {

    protected By signInButton = By.xpath("//input[@type='submit']"); // Кнопка входа
    protected By createRequestButton = By.xpath("//li[@id='ClientListItem']"); // Кнопка меню "Создать заявку"
    protected By bank = By.xpath("//a[@href='/client/11']"); // Ссылка выбора банка для создания заявки
    protected By createNewCard = By.id("createNewCard"); // Кнопка "Создать заявку на БГ" в главном меню
    protected By createCard = By.xpath("//input[@name='createCardBtn']"); // Кнопка "Создать заявку"
    protected By getDataTender = By.id("GetTenderInfoBtn"); // Кнопка "Получить данные" (получение данные для заявки из тендера)
    protected By executionGuaranteeNoRB = By.id("Card_need_exec_guarantee_1"); // radiobutton "исполнение обязательств" - нет
    protected By requiredContractGuarantee = By.id("Card_contract_type_0"); // radiobutton "Вид контракта/договора *" - Контракт
    protected By bankToSelect = By.id("bank_18"); // чек-бокс выбора тестового банка
    protected By submitSelectBank = By.id("selectBanksBtn");// Кнопка подтверждения выбора тестового банка
    protected By paperFormatBg = By.id("CardToBank_18_format_bg_0"); // radiobutton - бумажный формат БГ
    protected By electronicFormatBg = By.id("CardToBank_18_format_bg_1"); // radiobutton - электронный формат БГ
    protected By deliveryYes = By.id("CardToBank_18_need_delivery_0");
    protected By deliveryNo = By.id("CardToBank_18_need_delivery_1");



    private By loginField = By.id("LoginForm_login"); // Поле логина
    private By passwordField = By.id("LoginForm_password"); // Поле пароля
    private By cardRegNumber = By.id("Card_regnumber"); // Поле для ввода реестрового номера
    private By radioButtonEnsuringTender = By.id("Card_bg_type_0"); // Выбор типа БГ
    private By errorMessage= By.xpath("//p[@class='errorMessage']");
    private By createRequestCloseTenderButton = By.xpath("//a[text()='Создать заявку на БГ (закрытый тендер)']");
    private By createRequestFz = By.xpath("//a[text()='Создать заявку на БГ по ФЗ-185, 615-ПП']");
    private By sourceLink = By.id("Card_link"); // Поле "Ссылка на источник"
    private By executionGuaranteeYesRB = By.id("Card_need_exec_guarantee_0"); // radiobutton "исполнение обязательств" - да
    private By warrantyGuaranteeNoRB = By.id("Card_need_warr_guarantee_1"); // radiobutton "Гарантия гарантийного периода" - нет
    private By prepaymentGuaranteeNoRB = By.id("Card_need_avans_guarantee_1"); // radiobutton "Возврат аванса" - нет
    private By sumGuarantee = By.id("Card_guarantee_sum"); // Поле "Сумма банковской гарантии"
    private By card_ExecutionGuaranteeSum = By.id("Card_exec_guarant_sum"); // Поле "Сумма" в блоке "Исполнение обязательств"
    private By card_ExecutionGuaranteeTime = By.id("Card_exec_guarant_time"); // Поле "Срок(месяцев)" в блоке "Исполнение обязательств"
    private By dateBgFromChB = By.id("from_cur_date"); // Чек-бокс "Срок БГ с даты выдачи"
    private By errorMessageExpired = By.id("Card_guarantee_expired_em_"); //Сообщение об ошибке "Необходимо заполнить поле «Срок БГ до»."
    private By errorMessageResponsibility = By.id("Card_responsibility_to_em_"); //Сообщение об ошибке "Необходимо заполнить поле «Срок выполнения работ/оказания услуг»."
    private By errorMessageContract = By.id("Card_contract_type_em_"); //Сообщение об ошибке "Необходимо заполнить поле «Вид контракта/договора»."
    private By errorMessageSum = By.id("Card_exec_guarant_sum_em_"); //Сообщение об ошибке "Не заполнено поле Сумма" или "Сумма должна быть числом"
    private By errorMessageAlert = By.xpath("//div[@class='message']"); // Алерт с ошибками при создании заявки и незаполнении обязательных полей
    private By requiredExpiredGuarantee = By.id("Card_guarantee_expired"); // Поле "Срок БГ до *"
    private By requiredResponsibilityGuarantee = By.id("Card_responsibility_to"); // Поле "Срок выполнения работ/оказания услуг *"
    private By boxToSelectBank = By.id("colorbox"); // окно для выбора тестового банка при создании заявки
    private By selectFormatBg = By.id("format_bg_for_18"); // Блок с выбором формата БГ
    private By deliveryOriginal = By.id("BankParams_18"); // Блок с выбором доставки
    private By minimumTariff = By.id("BankDeliveryParams_18");

    public static String valueSumGuarantee;
//    = find(sumGuarantee).getText();




    public void clickButton(By button){ // Клик по кнопке
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public CreateRequestPage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    } // Ввести е-мейл для входа

    public CreateRequestPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    } // Ввести пароль для входа

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
        return find(sourceLink).getValue().isEmpty();
//        return find(sourceLink).getText().isEmpty();
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
        return find(sumGuarantee).getValue().isEmpty();
    } // Проверка, что поле "Сумма банковской гарантии" заполнено

    public boolean getDateBgFrom(){
        return find(dateBgFromChB).isSelected();
    } // Проверка, что по умолчанию стоит чек-бокс "Срок БГ с даты выдачи"

    public String getErrorMessageExpired(){
        return find(errorMessageExpired).getText();
    } // Получение текста ошибки при незаполнении поля "Срок БГ до *"

    public String getErrorMessageResponsibility(){
        return find(errorMessageResponsibility).getText();
    } // Получение текста ошибки при незаполнении поля "Срок выполнения работ/оказания услуг *"

    public String getErrorMessageContract(){
        return find(errorMessageContract).getText();
    } // Получение текста ошибки при не выборе значения в блоке "Вид контракта/договора *"

    public String getTextErrorMessageAlert(){
        return find(errorMessageAlert).waitUntilVisible().getText();
    } // Получение текста алерта ошибок

    public boolean getErrorMessageAlert(){
        return find(errorMessageAlert).waitUntilVisible().isDisplayed();
    } // Получение наличия алерта ошибок

    public boolean hideExGuarantee(){
        return find(card_ExecutionGuaranteeSum).isDisplayed() | find(card_ExecutionGuaranteeTime).isDisplayed();
    } // Проверка скрытия элементов при выборе в блоке "Исполнение обязательств" значения "Нет"

    public CreateRequestPage setRequiredExpiredGuarantee(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, 1);
        find(requiredExpiredGuarantee).sendKeys(dateFormat.format(calendar.getTime()));
        valueSumGuarantee = find(sumGuarantee).getText();
        return this;
    } // Ввести срок БГ до

    public boolean isEqualRequiredExpiredGuarantee(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, 1);
        String calendarNow = dateFormat.format(calendar.getTime());
//        find(requiredExpiredGuarantee).sendKeys(dateFormat.format(calendar.getTime()));
        return  calendarNow.equals(find(requiredExpiredGuarantee).getValue());
    } // Получить значение поля "Срок БГ до"

    public boolean isSelectedExecutionGuaranteeNoRB(){
        return find(executionGuaranteeNoRB).isSelected();
    } // Проверка выбрано ли значение "Нет" в блоке "Исполнение обязательств"

    public CreateRequestPage setRequiredResponsibilityGuarantee(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, 2);
        find(requiredResponsibilityGuarantee).sendKeys(dateFormat.format(calendar.getTime()));
        return this;
    } // Ввести срок выполнения работ

    public String getErrorMessageSum(){
        return find(errorMessageSum).getText();
    } // Получение текста ошибки, если не заполнено поле 'Сумма' в блоке 'Исполнение обязательств'

    public CreateRequestPage setRequiredSum(String invalid){
        find(card_ExecutionGuaranteeSum).sendKeys(invalid);
        return this;
    } // Ввести данные в поле "Сумма" блока "Исполнение обязательств"

    public boolean isVisibleBoxSelectBank(){
        try {
            find(boxToSelectBank).waitUntilVisible();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return find(boxToSelectBank).isDisplayed();
    } // Проверка на продолжение создания заявки

    public boolean isVisibleBoxFormatBg(){
        return find(selectFormatBg).isDisplayed();
    } // Проверка появления блока с выбором формата БГ

    public boolean isVisibleDeliveryOriginal(){
        return find(deliveryOriginal).isDisplayed();
    } // Проверка появления блока с выбором формата БГ

    public boolean isVisibleMinimumTariff(){
        return find(minimumTariff).isDisplayed();
    } // Проверка появления текста минимального тарифа доставки

}
