package gmail.mrkvktrvch;

import com.codeborne.selenide.Condition;
import gmail.mrkvktrvch.steps.WebSteps;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SimpleSelenideTestWithAnnotatedSteps {

    private static final String REPOSITORY = "sberbank-ai/ru-dalle";
    private static final int ISSUE_NUMBER = 11;

    private WebSteps steps = new WebSteps();

    @Test
    public void issueSearchTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
