package pages;
import ru.yandex.qatools.allure.annotations.Step;

public class Page {

    @Step("{0}")
    public static void report(String s){}

    public static String getRandomString(int l) {
        StringBuilder tag = new StringBuilder();
        for (int i = 0; i < l; i++) {
            tag.append((char) ((int) (Math.random() * 25 + 97)));
        }
        return tag.toString();
    }

}
