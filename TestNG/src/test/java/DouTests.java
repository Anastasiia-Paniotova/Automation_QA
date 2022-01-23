package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DouTests {
    WebDriver driver;

    @DataProvider(name = "DataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {{"TestNg"},{"JUnit"}};
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpPrerequisites(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\auto_hw\\chrome_webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://dou.ua/");
    }

    // получаем цвет после наведения курсора на меню Форум
    @Test(groups = {"positive"})
    public void hoverMenu() {
        WebElement forumElement = driver.findElement(By.xpath("//*[text()='Форум']"));

        Actions moveMouse = new Actions(driver);
        moveMouse.moveToElement(forumElement).perform();

        System.out.println(forumElement.getCssValue("color"));
    }

    //клик на лого редиректит юзера на главную страницу
    @Test(groups = {"positive"})
    public void redirectByClickingLogo() {
        WebElement robotaElement = driver.findElement(By.xpath("//*[text()='Робота']"));
        robotaElement.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement logo = driver.findElement(By.className("logo"));
        logo.click();

        String URL = driver.getCurrentUrl();
        System.out.println(URL);

    }

    //получить автора и название первой статьи в разделе Технические статьи
    @Test(groups = {"positive"})
    public void getAuthorAndTitle() {
        WebElement firstArticle = driver.findElement(By.xpath("//div[@class='b-articles b-articles_tech']/ul/li/a[1]"));
        firstArticle.click();

        WebElement author = driver.findElement(By.className("name"));
        WebElement title = driver.findElement(By.xpath("//*[@class='b-typo b-typo_post']/h1"));

        System.out.println("Автор: " + author.getText());
        System.out.println("Название статьи: " + title.getText());

    }

    // тест с DataProvider, где проверяем, что наш поисковый запрос содержит ключевое слово
    @Test(dataProvider = "DataProvider", groups = {"negative"})
    public void searchWithDataProvider(String data) {
        WebElement searchField = driver.findElement(By.id("txtGlobalSearch"));
        searchField.sendKeys(data);
        searchField.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//*[@class='gs-bidi-start-align gs-snippet'][1]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        System.out.println(result.getText().contains(data));
    }

    //проверка что есть страница "Новий топік"
    @Test(groups = {"negative"})
    public void addNewTopic() {
        WebElement forumElement = driver.findElement(By.xpath("//*[text()='Форум']"));
        forumElement.click();

        WebElement addTopic = (new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='wrap add-content-link']/a"))));
        addTopic.click();

        System.out.println(driver.findElement(By.className("page-head")).getText().contains("Новий топік"));

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }


}
