package Test;

import Base.BaseTest;
import Pages.EConsignmentNotePage;
import Pages.HomePage;
import Pages.ParcelPage;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class eConsignmentTest extends BaseTest {

    private HomePage homePage;
    private ParcelPage parcelPage;
    private EConsignmentNotePage eConsignmentNotePage;


    @Test(description = "Verify that Pos website has links to create e-Consignment note", priority = 1)
    public void Test2() throws InterruptedException {

        homePage = new HomePage(driver);
        Thread.sleep(5000);

        //check whether Advertisement popup box might appear
        homePage.closeAdvertisementIfPresent();

        //Navigate to send parcel page
        homePage.navigateToParcelpage();

        //Scroll down to the section
        homePage.scrollToText("Cash");

        parcelPage = new ParcelPage(driver);

        // Verify that the cash title is visible
        parcelPage.isVisibleyCashTitle();

        // Click on "Create shipment now" button on parcel page
        parcelPage.clickByCreateShipmentButton();

        eConsignmentNotePage = new EConsignmentNotePage(driver);

        // Verify that e-Consignment Note page is loaded
        Assert.assertTrue(eConsignmentNotePage.isEConsignmentNotePageLoaded(),"E-Consignment Note page did not load successfully.");

        // Verify that the sections are visible
        Assert.assertTrue(eConsignmentNotePage.isSenderInfoSectionVisible(),"Sender Info section is not visible");
        Assert.assertTrue(eConsignmentNotePage.isReceiverInfoSectionVisible(),"Receiver Info section is not visible");
        Assert.assertTrue(eConsignmentNotePage.isParcelInfoSectionVisible(),"Parcel Info section is not visible");
        Assert.assertTrue(eConsignmentNotePage.isSummarySectionVisible(),"Summary section is not visible");

    }

}
