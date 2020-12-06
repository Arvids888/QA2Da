import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import java.util.List;

public class Tvnetfirst {

    private final By ARTICLE = By.tagName("article");
    private final String ARTICLE_BY_TITLE = "NBA zvaigzne Covid-19 dēļ zaudējis septiņus ģimenes locekļus";
    private final By TITLE = By.xpath(".//span[(@class = 'list-article__headline')]");
    private final By COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article__comment')]");

    private final By ARTICLE_TITLES = By.tagName("article");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[(@itemprop = 'headline name')]");
    private final By ARTICLE_COMMENTS_COUNT = By.xpath(".//span[(@class = 'article-share__item--count')]");
    private final By ARTICLE_COMMENTS_BUTTON = By.xpath(".//a[contains(@class, 'article-share__item--comments')]");

    private final By COMMENT_PAGE_BODY = By.tagName("a");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[(@class = 'article-headline')]");
    private final By COMMENT_PAGE_COMMENTS_COUNT = By.xpath(".//span[contains(@class, 'article-comments-heading')]");
    private final By COMMENT_PAGE_USER_COMMENT_COUNT = By.xpath(".//div[contains(@class, 'comments-block__comments')]");
    private final By COMMENT_PAGE_USER_COMMENT_COUNT_IND = By.xpath(".//li[contains(@class, 'article-comment')]");
    private final By COMMENT_PAGE_MENU_BUTTON = By.xpath(".//a[contains(@class, 'menu-item section')]");

    private WebDriver driver;

    @BeforeEach
    public void preconditions() {
        //open browser
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tvnet.lv/");
    }

    @Test
    public void threePagesTest() {

        //get all articles
        List<WebElement> articles = driver.findElements(ARTICLE);

        //get correct article
        WebElement article = articles.get(1);

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


        //get all articles
        List <WebElement> articleTitles = driver.findElements(ARTICLE_TITLES);

        //get correct article
        WebElement articleTitle = articleTitles.get(0);

        //get article
        String articlePageTitle = articleTitle.findElement(ARTICLE_PAGE_TITLE).getText();

        //press comments button
        WebElement commentsButton = driver.findElement(ARTICLE_COMMENTS_BUTTON);

        //get all comments
        List <WebElement> articleComments = driver.findElements(ARTICLE_COMMENTS_COUNT);

        //get correct comment
        WebElement articleComment = articleComments.get(1);

        //acquiring comments and turning into Integer
        String getArticleComment = articleComment.getText();

        //check title
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Titles are not equal!");

        //check if comments are empty
        if (!articleComment.findElements(ARTICLE_COMMENTS_COUNT).isEmpty()) {
            articleComment = (articleComment.findElement(ARTICLE_COMMENTS_COUNT));
            //check comments
            Assertions.assertEquals(homePageCommentsCount, getArticleComment, "Wrong comment amount");
        //open comments page
            articleComment.click();
        }
        else {
            commentsButton.click();
        }

        //wait for title
        WebDriverWait waitTwo = new WebDriverWait(driver, 10);
        waitTwo.until(ExpectedConditions.visibilityOfElementLocated(COMMENT_PAGE_TITLE));


        //get title
        String commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE).getText();

        //check title
        Assertions.assertTrue(homePageTitle.startsWith(commentPageTitle), "Titles are not equal!");

        //get comments
        WebElement commentPageComment = driver.findElement(COMMENT_PAGE_COMMENTS_COUNT);

        //get comment
        String getCommentPageComment = commentPageComment.getText();

        int getIntCommentPageComments = parseCommentCountFour(getArticleComment);

        //calculate comments if present
        if (!commentPageComment.isDisplayed()) {

            //back to main page if empty
            List <WebElement> logo = driver.findElements(COMMENT_PAGE_MENU_BUTTON);
            WebElement firstButton = logo.get(0);
            firstButton.click();
        } else {
            //check comments
            Assertions.assertEquals(homePageCommentsCount, getIntCommentPageComments, "Wrong comment amount");

            //get all posted comments
            WebElement userTab = driver.findElement(COMMENT_PAGE_USER_COMMENT_COUNT);
            userTab.getText();
            List<WebElement> usersCount = userTab.findElements(COMMENT_PAGE_USER_COMMENT_COUNT_IND);

            for (WebElement userCount : usersCount) {
                userCount.getText();
                Assertions.assertEquals(commentPageComment, userCount, "Wrong user amount");

                //back to main page
                List <WebElement> logo = driver.findElements(COMMENT_PAGE_MENU_BUTTON);
                WebElement firstButton = logo.get(0);
                firstButton.click();
            }
        }
        WebDriverWait waitThree = new WebDriverWait(driver, 10);
        waitThree.until(ExpectedConditions.visibilityOfElementLocated(TITLE));


        boolean isFound = false;
        for (WebElement textArticle : articles) {
            if (textArticle.findElement(TITLE).getText().equals(ARTICLE_BY_TITLE)) {
                textArticle.findElement(TITLE).click();
                isFound = true;
            }
        }


    }
    private int parseCommentCountTwo(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }

    private int parseCommentCountFour(String textToParse) {
        return Integer.parseInt(textToParse);
    }

    @AfterEach
    private void closeBrowser() {
        driver.close();
    }
}
