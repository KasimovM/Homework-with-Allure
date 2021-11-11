package gmail.mrkvktrvch.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открытие главной страницы")
    public void openMainPage () {
        open("https://github.com");
    }

    @Step("Поиск репозитория {repository}")
    public void searchForRepository (String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переход в репозиторий {repository}")
    public void goToRepository (String repository) {
        $(linkText("sberbank-ai/ru-dalle")).click();
    }

    @Step("Открытие таба Issues")
    public void openIssueTab () {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверка существования Issue с номером {number}")
    public void shouldSeeIssueWithNumber (int number) {
        $(withText("#" + number)).should(Condition.visible);
    }
}


