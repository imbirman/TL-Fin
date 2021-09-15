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



}
