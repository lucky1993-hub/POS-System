package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void waitAndClick(WebElement element) {
        // Implement a method to wait until the element is clickable, then click
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    // Method to scroll to the specified text
    public void scrollToText(String text) {
        String script = "const scrollToText = (text) => { " +
                "const element = [...document.body.getElementsByTagName('*')].find(el => el.textContent.includes(text)); " +
                "if (element) { " +
                "element.scrollIntoView({ behavior: 'smooth', block: 'center' }); " +
                "return 'Success'; " +
                "} else { " +
                "return `Text \"${text}\" not found on the page.`; " +
                "}}; " +
                "scrollToText(arguments[0]);";

        ((JavascriptExecutor) driver).executeScript(script, text);

    }

}
