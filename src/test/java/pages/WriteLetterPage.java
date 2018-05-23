package pages;


import com.codeborne.selenide.Condition;
import config.Values;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WriteLetterPage extends Page {

    @Step("Ввод электронного адреса получателя {0} в поле \"Кому\"")
    public void setTo(String email) {
        $(byXpath("//textarea[@tabindex='4']")).setValue(email);
    }

    @Step("Ввод темы письма в поле \"Тема\": {0}")
    public void setTheme(String theme) {
        $(byXpath("//input[@class='b-input']")).setValue(theme);
    }

    @Step("Ввод случайного текста в поле \"Письмо\"")
    public void setRandomBody() {
        String letter = getRandomString(10);
        getWebDriver().switchTo().frame(1);
        $("#tinymce").clear();
        $("#tinymce").setValue(letter);
        report("Случайная текст: " + letter);
        getWebDriver().switchTo().defaultContent();
    }

    @Step("Нажать кнопку отправить")
    public void clickSendButton() {
        $(byXpath("//span[@class='b-toolbar__btn__text']")).click();
        $(byXpath("//div[@class='message-sent__wrap']")).shouldBe(Condition.visible);
    }

}
