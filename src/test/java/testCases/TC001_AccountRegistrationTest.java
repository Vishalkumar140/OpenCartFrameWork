package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups={"Regression","Master"})
    public void verify_account_registration() {
        logger.info("**** Starting TC001_AccountRegistrationTest ****");
        try {
            HomePage hp = new HomePage(driver);
            hp.click_Myaccount();
            logger.info("Clicked on Myaccount Link..");
            hp.click_Register();
            logger.info("Clicked on Register Link..");
            AccountRegistration regpage = new AccountRegistration(driver);
            logger.info("Providing customer details..");
            //regpage.set_firstname("johan");
            regpage.set_firstname(randomeString().toUpperCase());
            //regpage.set_lastname("smith");
            regpage.set_lastname(randomeString().toUpperCase());
            //regpage.set_email("johan321@yopmail.com");
            regpage.set_email(randomeString() + "@yopmail.com");
            //regpage.set_telephoneno("2569874563");
            regpage.set_telephoneno(randomeNumber());
            String password = randomeAplhaNumeric();
            //regpage.set_password("Test@123");
            regpage.set_password(password);
            //regpage.set_confrmpassword("Test@123");
            regpage.set_confrmpassword(password);
            regpage.clickprivatepolicy();
            regpage.click_continuebtn();
            logger.info("Validating expected message..");
            String confmsg = regpage.getconfirmationMsg();
            if(confmsg.equals("Your Account Has Been Created!")){
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test failed..");
                logger.debug("Debug logs");
                Assert.assertTrue(false);
            }
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("**** finished TC001_AccountRegistrationTest ****");
    }

}
