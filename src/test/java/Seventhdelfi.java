import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Seventhdelfi {
        private final By COOKIE = By.xpath(".//button[contains(@class, 'dvvOSu')]");

        private final By ARTICLE = By.tagName("article");
        private final By TITLE = By.xpath(".//h1[contains (@class, 'headline__title')]");
        private final By COMMENTS_COUNT = By.xpath(".//a[contains (@class, 'comment-count')]");

        private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains (@class, 'd-inline')]");
        private final By ARTICLE_COMMENTS_COUNT = By.xpath(".//a[contains(@href, '1&reg')]");

        private final By COMMENT_PAGE = By.tagName("main");
        private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
        private final By COMMENT_PAGE_COMMENTS_COUNT_ANON_1 = By.xpath(".//li[contains(@class, 'as-link show-anon')]");
        private final By COMMENT_PAGE_COMMENTS_COUNT_REG_1 = By.xpath(".//li[contains(@class, 'as-link is-active')]");


        private WebDriver driver;

        @BeforeEach
        public void preconditions() {
            //open browser
            System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://rus.delfi.lv");

            //wait for cookie
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIE));

            //get cookie
            String cookieTab = driver.findElement(COOKIE).getText();
            driver.findElement(COOKIE).click();

        }

        @Test
        public void titleTest() {

            //get all articles
            List<WebElement> articles = driver.findElements(ARTICLE);

            //get 3rd article
            WebElement article = articles.get(2);

            //get article
            String homePageTitle = article.findElement(TITLE).getText();

            //find comments count
            int homePageCommentsCount = 0;
            if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
                homePageCommentsCount = parseCommentCountTwo(article.findElement(COMMENTS_COUNT).getText());
            }

            //click on it
            article.findElement(TITLE).click();

            //wait for title
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

            //find title
            String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

            //find comment count
            int articlePageCommentCount = 0;
            if (!driver.findElements(ARTICLE_COMMENTS_COUNT).isEmpty()) {
                articlePageCommentCount = parseCommentCountTwo(driver.findElement(ARTICLE_COMMENTS_COUNT).getText());
            }
            //check it
            Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not equal!");
            Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong comment amount");

            //open comments page
            driver.findElement(ARTICLE_COMMENTS_COUNT).click();

            //wait for title
            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_PAGE));


            //find title and comments
            //List<WebElement> allElements = driver.findElements(COMMENT_PAGE);

            //get title
            String commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();

            //get all comments


            //get 1st comment
            //WebElement comments = allElements.get(0);

            //get 2nd comment
            //WebElement commentsTwo = allElements.get(1);

            //mergeComment


            //get comments
            int comment = 0;
            if (!driver.findElements(COMMENT_PAGE_COMMENTS_COUNT_ANON_1).isEmpty()) {
                comment = parseCommentCountOne(driver.findElement(COMMENT_PAGE_COMMENTS_COUNT_ANON_1).getText());

            }
            int comment2 = 0;
            if (!driver.findElements(COMMENT_PAGE_COMMENTS_COUNT_REG_1).isEmpty()) {
                comment2 = parseCommentCountThree(driver.findElement(COMMENT_PAGE_COMMENTS_COUNT_REG_1).getText());

            }

            //add comments
            int bothComments = comment + comment2;


            //end comments


            //check it
            Assertions.assertTrue(homePageTitle.startsWith(commentPageTitle), "Titles are not equal!");
            Assertions.assertEquals(homePageCommentsCount, bothComments, "Wrong comment amount");



        }
        private int parseCommentCountOne(String textToParse) {
            textToParse = textToParse.substring(11, textToParse.length() - 1);
            return Integer.parseInt(textToParse);
    }

        private int parseCommentCountTwo(String textToParse) {
            textToParse = textToParse.substring(1, textToParse.length() - 1);
            return Integer.parseInt(textToParse);
    }
        private int parseCommentCountThree(String textToParse) {
            textToParse = textToParse.substring(12, textToParse.length() - 1);
            return Integer.parseInt(textToParse);
    }



        @AfterEach
        private void closeBrowser() {
            driver.close();
        }
    }

