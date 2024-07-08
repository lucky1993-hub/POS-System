package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParcelPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Create shipment now')]")
    private WebElement createShipmentButton;
    @FindBy(xpath = "//div[contains(text(),'Cash')]")
    private WebElement cashLabel;

    public ParcelPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify 'Cash' title is visible")
    public boolean isVisibleyCashTitle(){
        return cashLabel.isDisplayed();
    }

    @Step("Click 'Create shipment now' button")
    public ParcelPage clickByCreateShipmentButton(){
        click(createShipmentButton);
        return new ParcelPage(driver);
    }

}
