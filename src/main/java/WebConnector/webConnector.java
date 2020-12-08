package WebConnector;

import io.cucumber.core.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class webConnector {
    public static WebDriver driver;
    public static Action action;
    public static Properties prop = new Properties();

    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void closeDriver(Scenario scenario) throws IOException {
       if (scenario.isFailed()) {
            FileUtil.CaptureScreenShot("failedTest", ".png");
        }
        driver.close();
    }

    public static By getElementWithLocator(String WebElement) throws Exception {
        String[] locatorTypeAndValueArray = WebElement.split(",");
        String locatorType = locatorTypeAndValueArray[0].trim();
        String locatorValue = locatorTypeAndValueArray[1].trim();
        switch (locatorType.toUpperCase()) {
            case "ID":
                return By.id(locatorValue);
            case "NAME":
                return By.name(locatorValue);
            case "TAGNAME":
                return By.tagName(locatorValue);
            case "LINKTEXT":
                return By.linkText(locatorValue);
            case "PARTIALLINKTEXT":
                return By.partialLinkText(locatorValue);
            case "XPATH":
                return By.xpath(locatorValue);
            case "CSS":
                return By.cssSelector(locatorValue);
            case "CLASSNAME":
                return By.className(locatorValue);
        }
        return null;
    }

    public static WebElement FindAnElement(String WebElement) throws Exception {
        return driver.findElement(getElementWithLocator(WebElement));
    }

    public static void ClickLinkFromHover(String MainMenu, String SubMenu) throws Exception {
        Actions actions = new Actions(driver);
        WebElement Menu = FindAnElement(MainMenu);
        actions.moveToElement(Menu).moveToElement(FindAnElement(SubMenu)).click().build().perform();
    }

    public static void SelectFromDropDown(String MainMenu, Integer Offset) throws Exception {
        Actions actions = new Actions(webConnector.driver);
        WebElement Menu = FindAnElement(MainMenu);
        actions.moveToElement(Menu).click().perform();
        actions.moveByOffset(0, Offset).click().perform();
    }

    public static void PerformActionOnElement(String WebElement, String Action, String Text) throws Exception {
        if ("Click".equals(Action)) {
            FindAnElement(WebElement).click();
        } else if ("Type".equals(Action)) {
            FindAnElement(WebElement).sendKeys(Text);
        } else if ("Clear".equals(Action)) {
            FindAnElement(WebElement).clear();
        } else if ("WaitForElementDisplay".equals(Action)) {
            waitForCondition("Presence", WebElement, 60);
        } else if ("WaitForElementClickable".equals(Action)) {
            waitForCondition("Clickable", WebElement, 60);
        } else if ("ElementNotDisplayed".equals(Action)) {
            waitForCondition("NotPresent", WebElement, 60);
        } else {
            throw new IllegalArgumentException("Action \"" + Action + "\" isn't supported.");
        }
    }

    public static void waitForCondition(String TypeOfWait, String WebElement, int Time) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Time, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
            if ("PageLoad".equals(TypeOfWait)) {
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
            } else if ("Clickable".equals(TypeOfWait)) {
                wait.until(ExpectedConditions.elementToBeClickable(FindAnElement(WebElement)));
            } else if ("Presence".equals(TypeOfWait)) {
                wait.until(ExpectedConditions.presenceOfElementLocated(getElementWithLocator(WebElement)));
            } else if ("Visibility".equals(TypeOfWait)) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(getElementWithLocator(WebElement)));
            } else if ("NotPresent".equals(TypeOfWait)) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(getElementWithLocator(WebElement)));
            } else {
                Thread.sleep(Time * 1000);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("wait For Condition \"" + TypeOfWait + "\" isn't supported.");
        }
    }
}
