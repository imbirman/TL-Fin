package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("http://test.tl-fin.ru/auth/login")
public class SignUpPage extends PageObject {

    private By loginField = By.id("LoginForm_login");
    private By passwordField = By.id("LoginForm_password");
    private By checkRememberMe = By.id("LoginForm_rememberMe");
    private By signInButton = By.xpath("//input[@type='submit']");
    private By errorLoginField = By.id("LoginForm_login_em_");
    private By errorPasswordField = By.id("LoginForm_password_em_");


    public SignUpPage typeEmail(String email){ // Поиск поля емейла и ввод значения
        find(loginField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){ // Поиск поля пароля и ввод значения
        find(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage setCheckRemember(boolean check){ // установка (или нет) чек-бокса "Запомнить меня"
        if (!find(checkRememberMe).isSelected() == check) {
            find(checkRememberMe).click();
        }
        return this;
    }

    public void clickSignButton(){
        find(signInButton).click();
    } // Клик по кнопке

    public boolean errorLoginVisible(){ // Есть ли текст ошибки при пустом поле логин
        return find(errorLoginField).isDisplayed();
    }

    public String getErrorLogin(){ // текст ошибки при пустом поле логин
        WebElementFacade errorLogin;
        errorLogin = find(errorLoginField).waitUntilVisible();
        return errorLogin.getText();
    }

    public boolean errorPasswordVisible(){ // Есть ли текст ошибки при пустом поле логин
        WebElementFacade errorPassword;
        errorPassword = find(errorPasswordField).waitUntilVisible();
        return errorPassword.isDisplayed();
    }

    public String getErrorPassword(){ // текст ошибки при пустом поле пароль или неккоректной авторизации
        WebElementFacade errorPassword;
        errorPassword = find(errorPasswordField).waitUntilVisible();
        return errorPassword.getText();
    }

}
