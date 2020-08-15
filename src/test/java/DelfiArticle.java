import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DelfiArticle {

    @Test
public void articleCheck() {
        System.setProperty("webdriver.chrome.driver" , "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        String article = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();
        String comment = driver.findElement(By.xpath(".//a [contains (@class, 'comment-count')]")).getText();
        WebElement wholePage = driver.findElement(By.xpath(".//article [contains(@class, 'headline')]"));
        wholePage.findElement(By.xpath(".//a [contains (@class, 'comment-count')]"));
        List<WebElement>list = wholePage.findElements(By.xpath(".//a [contains (@class, 'comment-count')]"));
        Integer.valueOf(comment);

        comment = comment.replaceAll("[^a-zA-Z0-9]", " ");
            if (list.isEmpty()) {
                    System.out.println(0);
            }else {

                    System.out.println(article + comment + wholePage);
            }

    }
}
