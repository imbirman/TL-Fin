package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://test.tl-fin.ru/card/index")
public class LoginMainPage extends PageObject {

    private By loginField = By.id("LoginForm_login");
    private By passwordField = By.id("LoginForm_password");
    protected By signInButton = By.xpath("//input[@type='submit']");
    private By curatorName = By.id("curator_name");
    private By loginMenu = By.xpath("//span[@class='drop-down']");

    public void clickButton(By button){
        find(button).click();
    } // Клик по кнопке

    public LoginMainPage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    }

    public LoginMainPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    }

    public String getCuratorName(){
        WebElementFacade name;
        name = find(curatorName).waitUntilVisible();
        return name.getText();
    }

    public String getLoginMenu(){
        WebElementFacade login;
        login = find(loginMenu).waitUntilVisible();
        return login.getText();
    }

}
