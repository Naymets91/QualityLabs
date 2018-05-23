package pages;


import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class MailPage extends Page{

    @Step("Нажать кнопку \"Написать письмо\"")
    public void clickWriteLetterButton() {
        $(byXpath("//a[@data-bem='b-toolbar__btn']")).click();
    }

}
