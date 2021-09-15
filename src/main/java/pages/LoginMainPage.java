package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class LoginMainPage extends PageObject {

    private By loginField = By.id("LoginForm_login");
    private By passwordField = By.id("LoginForm_password");
    protected By signInButton = By.xpath("//input[@type='submit']");
    private By curatorName = By.id("curator_name");
    private By loginMenu = By.xpath("//span[@class='drop-down']");
    protected By buttonToggleMenu = By.id("toogleCardMenu");
    private By sidebar = By.xpath("//div[@class='flat-tab']");
    private By tableElement = By.xpath("//table[@class='items']");
    protected By selectNumberElementsTable = By.id("pageSize");
    protected By setOption25 = By.xpath("//option[@value='25']");
    protected By setOption50 = By.xpath("//option[@value='50']");
    protected By setOption100 = By.xpath("//option[@value='100']");

    public void clickButton(By button){ // Клик по кнопке
        find(button).click();
    }

    public LoginMainPage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    }

    public LoginMainPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    }

    public String getCuratorName(){ // Получение имени пользователя (для админа и агента)
        WebElementFacade name;
        name = find(curatorName).waitUntilVisible();
        return name.getText();
    }

    public String getLoginMenu(){ // Получение логина пользователя при успешном входе
        WebElementFacade login;
        login = find(loginMenu).waitUntilVisible();
        return login.getText();
    }

    public boolean getDisplayedSidebar(){ // Возвращает отображается ли меню таблицы
        return find(sidebar).isEnabled();
    }

    public List<WebElementFacade> getRows(){ // Получение списка строк элементов таблицы
        find(tableElement).waitUntilVisible();
        List<WebElementFacade> rows = findAll(By.xpath("//tr"));
        rows.remove(0);
        rows.remove(1);
        return rows;
    }

}
