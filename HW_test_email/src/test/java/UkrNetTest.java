import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UkrNetTest {
    //тест 1 - успешный логин
    @Test
    public void loginEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\auto_hw\\chrome_webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ukr.net/");

        driver.switchTo().frame("mail widget");

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("email@ukr.net");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        WebElement button = driver.findElement(By.className("form__submit"));
        button.click();

        WebElement buttonExist = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.id("id-logout")))); // дожидаемся пока появится кнопка "Вийти" после удачного логина
                                                                                    // и получаем её текст
        System.out.println(buttonExist.getText());

        driver.quit();

    }
    //тест 2 - логин по некорректным данным
    @Test
    public void loginFailed() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\auto_hw\\chrome_webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ukr.net/");

        driver.switchTo().frame("mail widget");

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("failed_email@ukr.net");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");

        WebElement button = driver.findElement(By.className("form__submit"));
        button.click();

        WebElement errorMessage = (new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form__error form__error_wrong form__error_visible']"))));
        System.out.println(errorMessage.getText()); // дожидаемся появления элемента и проверяем сообщение "Неправильні дані"

        driver.quit();
    }
    // тест 3 - отправка письма
    @Test
    public void sendEmail() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\auto_hw\\chrome_webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ukr.net/");

        driver.get("https://www.ukr.net/");

        driver.switchTo().frame("mail widget");

        //логин в аккаунт

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("test@ukr.net");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");

        WebElement button = driver.findElement(By.className("form__submit"));
        button.click();

        WebElement emails = (new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='service__entry service__entry_mail']"))));
        emails.click();

        //отправка письма
       // переключение на новоё окно

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button primary compose']"))).click();

        // заполнение поля отправителя и тела письма
        WebElement recipient = driver.findElement(By.name("toFieldInput"));
        recipient.sendKeys("recipient@ukr.net");
        recipient.sendKeys(Keys.ENTER);

        driver.switchTo().frame("mce_0_ifr");

        WebElement emailBody = driver.findElement(By.id("tinymce"));
        emailBody.click();
        emailBody.sendKeys("test email 123");

        driver.switchTo().defaultContent();

        WebElement sendButton = driver.findElement(By.xpath("//*[@class='button primary send']"));
        sendButton.click();

        //проверяем, что после отправки появился элемент об успешной отправки письма

        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='sendmsg__ads-ready']")));

        System.out.println(driver.findElement(By.xpath("//*[@class='sendmsg__ads-ready']")).isDisplayed());

        driver.quit();
    }
    //тест 3 отправка письма без отправителья
    @Test
    public void sendFailedEmail() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Professional\\Desktop\\auto_hw\\chrome_webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ukr.net/");

        driver.get("https://www.ukr.net/");

        driver.switchTo().frame("mail widget");

        //логин в аккаунт

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("test@ukr.net");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123456");

        WebElement button = driver.findElement(By.className("form__submit"));
        button.click();

        WebElement emails = (new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='service__entry service__entry_mail']"))));
        emails.click();

        //отправка письма
        // переключение на новоё окно

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='button primary compose']"))).click();

        // заполнение поля тела письма

        driver.switchTo().frame("mce_0_ifr");

        WebElement emailBody = driver.findElement(By.id("tinymce"));
        emailBody.click();
        emailBody.sendKeys("test email 123");

        driver.switchTo().defaultContent();

        WebElement sendButton = driver.findElement(By.xpath("//*[@class='button primary send']"));
        sendButton.click();

        // проверка, что сообщение об ошибки появилось на странице
        new WebDriverWait(driver,Duration.ofSeconds(5)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal show']")));
        System.out.println(driver.findElement(By.xpath("//*[@class='modal show']")).isDisplayed());

        driver.quit();
    }
}
