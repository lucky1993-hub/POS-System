package Pages;

import Base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'I drive a car')]")
    private WebElement driveCarButton;

    @FindBy(xpath = "(//div[@class='motor'])[2]")
    private WebElement driveMotorCycleButton;

    @FindBy(xpath = "//h5[contains(text(),\"Ok, let's get to know you\")]")
    private WebElement pageTitleLabel;

    @FindBy(name = "regNo")
    private WebElement vehicleRegistrationNoTextBox;

    @FindBy(name = "postcode")
    private WebElement postalCodeTextBox;

    @FindBy(id = "floatingInput")
    private WebElement idTypeTextBox;

    @FindBy(name = "newIc")
    private WebElement idNumberTextBox;

    @FindBy(id = "marital-single")
    private WebElement maritalStatusCheckBox;

    @FindBy(name = "mobileNumber")
    private WebElement mobileNumberTextBox;

    public InsurancePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'I drive a car' button")
    public InsurancePage clickByDriveCarButton(){
        click(driveCarButton);
        return new InsurancePage(driver);
    }

    @Step("Click 'I ride a motorcycle' button")
    public InsurancePage clickByDriveMotorCycleButton(){
        click(driveMotorCycleButton);
        return new InsurancePage(driver);
    }

    @Step("Verify page title is visible")
    public boolean isVisibleyPageTitle(){
         return pageTitleLabel.isDisplayed();
    }
    @Step("Verify vehicle registration number field is visible")
    public boolean isVisibleyVehicleRegistrationNumber(){
        return vehicleRegistrationNoTextBox.isDisplayed();
    }

    @Step("Verify postal code field is visible")
    public boolean isVisibleyPostalCode(){
        return postalCodeTextBox.isDisplayed();
    }

    @Step("Verify ID type field is visible")
    public boolean isVisibleyIdType(){
        return idTypeTextBox.isDisplayed();
    }
    @Step("Verify ID number field is visible")
    public boolean isVisibleyIdNumber(){
        return idNumberTextBox.isDisplayed();
    }
    @Step("Verify marital status checkbox is visible")
    public boolean isVisibleyMaritalStatus(){
        return maritalStatusCheckBox.isDisplayed();
    }
    @Step("Verify mobile number field is visible")
    public boolean isVisibleyMobileNumber(){
        return mobileNumberTextBox.isDisplayed();
    }

}
