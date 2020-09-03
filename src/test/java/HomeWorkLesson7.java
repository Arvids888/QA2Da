import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HomeWorkLesson7 {
    private final By ARTICLE = By.tagName("article");
    private WebDriver driver;

    @BeforeEach
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver" , "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");
    }

    @Test

    public void nr3ArticleAndCommmentCount () {
        List<WebElement> articles = driver.findElements(ARTICLE);

        WebElement article = articles.get(2);

        String headLine = driver.findElement(By.xpath(".//h1[contains (@class, 'headline__title')]")).getText();
        String comment = driver.findElement(By.xpath(".//a[contains (@class, 'comment-count')]")).getText();
        String headInLine = driver.findElement(By.xpath(".//h1[contains (@class, 'd-inline')]")).getText();
        String inComment = driver.findElement(By.xpath(".//a [contains (@href, '1&reg')]")).getText();
        String commentHeadline = driver.findElement(By.xpath(".//a [contains (@href, '524')]")).getText();

        Integer.valueOf(comment + inComment);

        comment = comment.replaceAll("[^a-zA-Z0-9]", " ");
        if (comment + inComment.isEmpty()) {
            System.out.println(0);
        }else {
            System.out.println(headLine + comment);
        }
    }
}
