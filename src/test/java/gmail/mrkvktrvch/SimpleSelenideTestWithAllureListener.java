package gmail.mrkvktrvch;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SimpleSelenideTestWithAllureListener {

    @Test
    public void issueSearchTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("sberbank-ai/ru-dalle");
        $(".header-search-input").submit();

        $(linkText("sberbank-ai/ru-dalle")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#11")).should(Condition.visible);
    }
}
