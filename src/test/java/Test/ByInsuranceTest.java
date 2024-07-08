package Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.InsurancePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ByInsuranceTest extends BaseTest {

    private HomePage homePage;
    private InsurancePage insurancePage;

    @Test(description = "Verify that Pos website offers to buy Insurance", priority = 1)
    public void Test1() throws InterruptedException {

        homePage = new HomePage(driver);

        Thread.sleep(2000);

        //check whether Advertisement popup box might appear
        homePage.closeAdvertisementIfPresent();

        //Scroll down to the section
        homePage.scrollToText("What can Pos Malaysia do for you, today?");

        //click by insurance button
        insurancePage = homePage.clickByInsuranceButton();

        //Get the current window handles
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //Switch to the new tab
        driver.switchTo().window(tabs.get(1));

        //Verify the URL of the new tab
        String expectedUrl = "https://insurance.pos.com.my/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The URL of the new tab is incorrect.");

        insurancePage = new InsurancePage(driver);

        //Verify that the button "I drive a car" can be clicked
        insurancePage.clickByDriveCarButton();

        //Verify page title is display
        Assert.assertTrue(insurancePage.isVisibleyPageTitle(),"Ok, let's get to know you title is not displayed");

        //Verify five different fields display
        Assert.assertTrue(insurancePage.isVisibleyVehicleRegistrationNumber(),"Vehicle Register Number Textbox is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyPostalCode(),"Postal Code Textbox is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyIdType(),"Id Type is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyIdNumber(),"Id number is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyMaritalStatus(),"Marital status is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyMobileNumber(),"Mobile Number is not displayed");

        ///Verify that the button "I ride a motorcycle" can be clicked
        insurancePage.clickByDriveMotorCycleButton();

        //Verify page title is display
        Assert.assertTrue(insurancePage.isVisibleyPageTitle(),"Ok Let's go test is not displayed");

        //Verify five different fields display
        Assert.assertTrue(insurancePage.isVisibleyVehicleRegistrationNumber(),"Vihicle Register Number Text Box is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyPostalCode(),"Postal Code Textbox is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyIdType(),"Id Type is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyIdNumber(),"Id number is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyMaritalStatus(),"Marital status is not displayed");
        Assert.assertTrue(insurancePage.isVisibleyMobileNumber(),"Mobile Number is not displayed");

    }

}
