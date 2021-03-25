package ui.selenide;


import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.io.File;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.open;
import static ui.selenide.pageObjects.UIPage.matchChekbox;
import static ui.selenide.pageObjects.UIPage.searchInput;


public class BaseTest {
    @BeforeClass
    public static void openUIpage() {
        open("file:///C:/Users/iakov/Downloads/ui/index.html");
    }


    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @After
    public void clearUserInputs() {
        if (matchChekbox.isSelected()) {
            matchChekbox.click();
        }
        searchInput.clear();
    }


    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
