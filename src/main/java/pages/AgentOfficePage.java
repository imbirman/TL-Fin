package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class AgentOfficePage extends PageObject{


    protected By signInButton = By.xpath("//input[@type='submit']"); // Кнопка входа
    protected By agentOfficeMenuButton = By.xpath("//li[@id='BrokerListItem']"); // Кнопка меню для открытия кабинета агента
    protected By agentOfficeMenuDown = By.xpath("//li[@id='BrokerListItem']//ul[@class='sub-tab']"); // Меню кабинета агента
    protected By agentOfficeMenuDownButton = By.xpath("//ul[@class='sub-tab']/li[1]"); // меню кабинета агента - "кабинет агента"
    protected By listUsersAgentOfficeButton = By.xpath("//ul[@class='sub-tab']/li[2]"); // меню кабинета агента - "список пользователей"
    protected By reportsAgentOfficeButton = By.xpath("//ul[@class='sub-tab']/li[3]"); // меню кабинета агента - "отчеты"
    protected By tabDepartment = By.id("ui-id-6"); // Вкладка "Отделы" в кабинете агента
    protected By addDepartment = By.xpath("//a[text()='Добавить отдел']"); // Кнопка "Добавить отдел" в кабинете агента
    protected By saveAddDepartment = By.xpath("(//input[@name='yt0'])[2]"); // Кнопка "Сохранить" при добавлении отдела
    protected By deleteDepartment = By.xpath("//a[text()='Удалить отдел']"); // Кнопка "Удалить отдел" - любая кнопка
    protected By quitFromTabDepartment = By.xpath("//form//div//a[text()='Выйти']"); // Кнопка "Выйти" в кабинете агента
    protected By managerDepartmentByAddDepartment = By.id("BrokerDepartment_admin_id"); // Раскрывающийся список для выбора руководителя отдела при добавлении отдела
    protected By managerDepartmentByEditDepartment = By.xpath("//table[@class='broker-table-item']//option[@selected]"); // Раскрывающийся список для выбора руководителя отдела при редактировании отдела
    protected By selectManagerDepartment1 = By.xpath("//option[@value='1']"); // Выбор руководителя отдела "ID: 1 - Гусев Павел Анатольевич"
    protected By selectManagerDepartment34 = By.xpath("//select[@id='BrokerDepartment_admin_id']//option[@value='34']"); // Выбор руководителя отдела "ID: 34 - Гусев Павел Анатольевич"



    private By loginField = By.id("LoginForm_login"); // Поле логина
    private By passwordField = By.id("LoginForm_password"); // Поле пароля
    private By nameDepartment = By.id("BrokerDepartment_name"); // Поле "Наименование отдела" при добавлении нового отдела
    private By nameDepartmentByEdit = By.xpath("//table[@class='broker-table-item']//input[@type='text']"); // Поле "Наименование отдела" во вкладке "Отделы"


    public void waitFor(){
        waitABit(1000);
    } // Ожидание

    public AgentOfficePage mouseHover(By element){ moveTo(element);
        return this;
    } // Наведение курсора на элемент

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

    public boolean isVisibleAgentOfficeButton(){
        return find(agentOfficeMenuButton).isDisplayed();
    } // Проверка, что кнопка для открытия кабинета агента отображается

    public boolean isVisibleAgentOfficeMenuDown(){
        return find(agentOfficeMenuDown).isDisplayed();
    } // Проверка, что меню кабинета агента открылось

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

    public String getNameDepartmentByEditDepartment(){

        List<WebElementFacade> nameDepartments = findAll(nameDepartmentByEdit);
        return nameDepartments.get(nameDepartments.size()-1).getValue();
    } // Получение наименования отдела, который был добавлен

    public String getManagerDepartmentByEditDepartment(){

        List<WebElementFacade> managerDepartments = findAll(managerDepartmentByEditDepartment);
//        System.out.println(managerDepartments.get(managerDepartments.size()-1).getText());
        return managerDepartments.get(managerDepartments.size()-1).getText();
    } // Получение наименования руководителя отдела, который был добавлен

    public AgentOfficePage setNameDepartment(String name){
         find(nameDepartment).sendKeys(name);
        return this;
    } // Ввести наименование отдела при создании нового отдела

    public void deleteAddingDepartment(){
        List<WebElementFacade> deleteDepartmentButton = findAll(deleteDepartment);
        deleteDepartmentButton.get(deleteDepartmentButton.size()-1).click();
    } // Удалить последний добавленный отдел


}
