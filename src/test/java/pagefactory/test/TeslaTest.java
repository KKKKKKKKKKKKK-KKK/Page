package pagefactory.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.page.*;

public class TeslaTest {
    private WebDriver driver;
    @Before
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "C:/q/chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void testPayment(){
        String textFromPage = new TeslaHome(driver)
                .openPage()
                .choiseRegionOnMainPage()
                .choiseModelAndAddToOrder()
                .fillInAllInputs("Sasha","Kachan","test@gmail.com","+375297052890","5189967822379436","1021","123","210210")
                .confirm()
                .getTextFromConfirm();
        Assert.assertTrue("lol", textFromPage.equals("There was a problem processing your payment. Please check and try a different payment method or contact your card issuing bank."));
    }
    @After
    public void browserKill(){
        driver.quit();
        driver=null;
    }

    @Test
    public void testShop(){
        String textFromLink = new TeslaShop(driver).openPage().choiseRegion().findItem("Mode Onesie").getTextFromLink();
        Assert.assertTrue("lol", textFromLink.equals("Kids Insane Mode Onesie"));
    }

}
