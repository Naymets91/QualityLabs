package pages;

import config.Values;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {

    @Step("Ввод логина и пароля")
    public void logIn() {
        $(byXpath("//input[@id='mailbox:login']")).setValue(Values.login);
        $(byXpath("//input[@id='mailbox:password']")).setValue(Values.password);
        $(byXpath("//label[@id='mailbox:submit']")).click();
    }

}
