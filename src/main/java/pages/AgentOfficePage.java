package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class AgentOfficePage extends PageObject {

    WebDriver driver = new ChromeDriver();
    Actions actions = new Actions(driver); // Переменная для выполнения сложных действий

    protected By signInButton = By.xpath("//input[@type='submit']"); // Кнопка входа
    protected By agentOfficeMenuButton = By.id("BrokerListItem"); // Кнопка меню для открытия кабинета агента
    protected By agentOfficeMenuDownButton = By.xpath("//ul[@class='sub-tab']/li[1]"); // меню кабинета агента - "кабинет агента"
    protected By listUsersAgentOfficeButton = By.xpath("//ul[@class='sub-tab']/li[2]"); // меню кабинета агента - "список пользователей"
    protected By reportsAgentOfficeButton = By.xpath("//ul[@class='sub-tab']/li[3]"); // меню кабинета агента - "отчеты"

    private By loginField = By.id("LoginForm_login"); // Поле логина
    private By passwordField = By.id("LoginForm_password"); // Поле пароля

    public void clickButton(By button){ // Клик по кнопке
        find(button).click();
    } // Кликнуть по кнопке / выбрать radiobutton или checkbox

    public AgentOfficePage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    } // Ввести е-мейл для входа

    public AgentOfficePage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    } // Ввести пароль для входа

    public AgentOfficePage openMenuDownAgentOffice(){
        actions.moveToElement(find(agentOfficeMenuButton).waitUntilVisible()).build().perform();
        return this;
    } // Открыть меню кабинета агента наведением курсора

    public boolean isVisibleAgentOfficeButton(){
        return find(agentOfficeMenuButton).isDisplayed();
    } // Проверка, что кнопка для открытия кабинета агента отображается

    public boolean isVisibleAgentOfficeMenuDownButton(){
        return find(agentOfficeMenuDownButton).isDisplayed();
    } // Проверка, что пункт в меню кабинета агента "кабинет агента" отображается

    public boolean isVisibleListUsersMenuDownButton(){
        return find(listUsersAgentOfficeButton).isDisplayed();
    } // Проверка, что пункт в меню кабинета агента "список пользователей" отображается

    public boolean isVisibleReportsAgentOfficeMenuDownButton(){
        return find(reportsAgentOfficeButton).isDisplayed();
    } // Проверка, что пункт в меню кабинета агента "отчеты" отображается

    public String getTextMenuDownAgentOfficeButton(){
        return find(agentOfficeMenuDownButton).getText();
    } // Получение названия кнопки "кабинет агента" меню кабинета агента

    public String getTextMenuDownListUsersAgentOfficeButton(){
        return find(listUsersAgentOfficeButton).getText();
    } // Получение названия кнопки "список пользователей" меню кабинета агента

    public String getTextMenuDownReportsAgentOfficeButton(){
        return find(reportsAgentOfficeButton).getText();
    } // Получение названия кнопки "отчеты" меню кабинета агента




}
