package testpackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import steps.SignUpSteps;

import java.net.URL;


@RunWith(SerenityRunner.class)
public class WhenSignUp {

    @Steps
    SignUpSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;


//    @Before
//    public void setUp(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prog\\Desktop\\test.tl-fin\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("http://test.tl-fin.ru/auth/login");
//    }

    @Test
    @Pending
    @Title("Проверка появления ошибки при пустом поле 'Логин'")
    public void checkErrorEmptyLogin(){
        steps.open_signup_page();
        steps.type_email("");
        steps.type_password("123");
        steps.set_chek_remember(true);
        steps.click_sign_button();
        steps.error_login_visible();

//        Assert.assertTrue(page.errorLoginVisible());
//        Assert.assertFalse(page.errorPasswordVisible());
    }

    @Test
    @Pending
    @Title("Проверка появления ошибки при пустом поле 'Пароль'")
    public void checkErrorEmptyPassword(){
        steps.open_signup_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("");
        steps.set_chek_remember(false);
        steps.click_sign_button();
        steps.error_password_visible();
//        Assert.assertTrue(page.errorPasswordVisible());
    }

    @Test
    @Pending
    @Title("Проверка появления ошибки при попытке входа с некорректными логин/пароль")
    public void checkInvalidSignIn(){
        steps.open_signup_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("123");
        steps.set_chek_remember(false);
        steps.click_sign_button();
        steps.error_password_visible();
//        Assert.assertTrue(page.errorPasswordVisible());
    }

    @Test
    @Pending
    @Title("Проверка текста ошибки при пустом поле 'Логин'")
    public void checkTextEmptyLogin(){
        steps.open_signup_page();
        steps.type_email("");
        steps.type_password("123");
        steps.set_chek_remember(false);
        steps.click_sign_button();
        steps.check_text_error_login();
//        Assert.assertEquals(page.getErrorLogin(), "Необходимо заполнить поле «Логин».");
    }

    @Test
    @Pending
    @Title("Проверка текста ошибки при пустом поле 'Пароль'")
    public void checkTextEmptyPassword(){
        steps.open_signup_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("");
        steps.set_chek_remember(false);
        steps.click_sign_button();
        steps.check_text_error_password();
//        Assert.assertEquals(page.getErrorPassword(), "Необходимо заполнить поле «Пароль».");
    }

    @Test
    @Pending
    @Title("Проверка текста ошибки при попытке входа с некорректными логин/пароль")
    public void checkTextInvalidSignIn(){
        steps.open_signup_page();
        steps.type_email("s.kosobutskiy");
        steps.type_password("123");
        steps.click_sign_button();
        steps.check_text_invalid_sign();
//        Assert.assertEquals(page.getErrorPassword(), "Неправильный логин или пароль");
    }


//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}
