package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

import java.time.Duration;

public class TC002_LoginTest extends BaseClass {

@Test(groups={"Sanity","Master"})
    public void verify_Login(){
    logger.info("*** Starting TC002_LoginTest ***");
    try {
        //HomePage
        HomePage hp = new HomePage(driver);
        hp.click_Myaccount();
        hp.click_Login();

        //LoginPage
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.ClickloginBtn();
        Thread.sleep(5000);

        //MyAccount
        MyAccount myaccnt = new MyAccount(driver);
        boolean targetPage = myaccnt.isMyAccountPageExists();
        Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage,true,"Login failed");
    }
    catch(Exception e){

        Assert.fail("Login test failed");
    }
    logger.info("*** Finished TC002_LoginTest ***");

}
}
