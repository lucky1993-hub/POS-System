package Pages;

import Base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EConsignmentNotePage extends BasePage {

    @FindBy(xpath = "(//div[contains(text(),'Sender Info')])[1]")
    private WebElement senderInfoSection;
    @FindBy(xpath = "(//div[contains(text(),'Receiver Info')])[1]")
    private WebElement receiverInfoSection;
    @FindBy(xpath = "(//div[contains(text(),'Parcel Info')])[1]")
    private WebElement parcelInfoSection;
    @FindBy(xpath = "(//div[contains(text(),'Summary')])[1]")
    private WebElement summarySection;

    public EConsignmentNotePage(WebDriver driver) {
        super(driver);
    }
    @Step("Verify that the e-Consignment Note page is loaded")
    public boolean isEConsignmentNotePageLoaded() {
        boolean isLoaded =  wait.until(ExpectedConditions.urlMatches("https://send.pos.com.my/home/e-connote\\?lg=en"));
        Allure.addAttachment("Page URL", driver.getCurrentUrl());
        return isLoaded;
    }
    @Step("Check if Sender Info section is visible")
    public boolean isSenderInfoSectionVisible() {
        boolean isVisible =  wait.until(ExpectedConditions.visibilityOf(senderInfoSection)).isDisplayed();
        Allure.addAttachment("Sender Info Section Visibility", String.valueOf(isVisible));
        return isVisible;
    }
    @Step("Check if Receiver Info section is visible")
    public boolean isReceiverInfoSectionVisible() {
        boolean isVisible =  wait.until(ExpectedConditions.visibilityOf(receiverInfoSection)).isDisplayed();
        Allure.addAttachment("Receiver Info Section Visibility", String.valueOf(isVisible));
        return isVisible;
    }
    @Step("Check if Parcel Info section is visible")
    public boolean isParcelInfoSectionVisible() {
        boolean isVisible =  wait.until(ExpectedConditions.visibilityOf(parcelInfoSection)).isDisplayed();
        Allure.addAttachment("Parcel Info Section Visibility", String.valueOf(isVisible));
        return isVisible;
    }
    @Step("Check if Summary section is visible")
    public boolean isSummarySectionVisible() {
        boolean isVisible = wait.until(ExpectedConditions.visibilityOf(summarySection)).isDisplayed();
        Allure.addAttachment("Summary Section Visibility", String.valueOf(isVisible));
        return isVisible;
    }

}
