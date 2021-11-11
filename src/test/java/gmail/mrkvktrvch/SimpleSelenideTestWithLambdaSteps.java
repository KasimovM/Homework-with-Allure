package gmail.mrkvktrvch;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SimpleSelenideTestWithLambdaSteps {

    private static final String REPOSITORY = "sberbank-ai/ru-dalle";
    private static final int ISSUE_NUMBER = 11;
    @Test
    public void issueSearchTest() {
        step("Открытие главной страницы", () -> {
                    open("https://github.com");
        });
        step("Поиск репозитория" + " " + REPOSITORY, () -> {
                    $(".header-search-input").click();
                    $(".header-search-input").sendKeys(REPOSITORY);
                    $(".header-search-input").submit();
        });
        step("Переход в репозиторий" + " " + REPOSITORY , () -> {
                    $(linkText("sberbank-ai/ru-dalle")).click();
        });
        step("Открытие таба Issues" , () -> {
                    $(partialLinkText("Issues")).click();
                });
        step("Проверка существования Issue с номером" + " " + ISSUE_NUMBER , () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
