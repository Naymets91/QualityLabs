import config.Values;
import listeners.AllureOnFailListener;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import pages.MailPage;
import pages.Page;
import pages.WriteLetterPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners({AllureOnFailListener.class})
@Title("MailMessageTest Test Suite")
public class MailMessageTest {

    LoginPage loginPg;
    MailPage mailPg;
    WriteLetterPage writeLetterPg;

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.savePageSource = false;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-tools");
        WebDriver myWebDriver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(myWebDriver);
        open("https://mail.ru");
        loginPg = new LoginPage();
        mailPg = new MailPage();
        writeLetterPg = new WriteLetterPage();
    }

    @Test()
    public void testMail() {
        loginPg.logIn();
        mailPg.clickWriteLetterButton();
        writeLetterPg.setTo(Values.email);
        writeLetterPg.setTheme("Test");
        writeLetterPg.setRandomBody();
        writeLetterPg.clickSendButton();
    }

    @AfterClass
    public void after () {
        getWebDriver().quit();
    }

}
