package testCases;
/*Data is valid -login success -test pass --logout
Data is valid --login failed --test failed

Data is invalid -login success -test fail --logout
Data is invalid --login failed --test pass
 */

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_Logindatadriventest extends BaseClass {

    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class,groups="DataDriven")//getting data provider from different class
    public void verify_loginDDT(String email, String pwd, String exp)
    {
        logger.info("*** Starting TC003_LoginDDT Test****");
        //HomePage
        try {
            HomePage hp = new HomePage(driver);
            hp.click_Myaccount();
            hp.click_Login();

            //LoginPage
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(pwd);
            lp.ClickloginBtn();

            //MyAccount
            MyAccount myaccnt = new MyAccount(driver);
            boolean targetPage = myaccnt.isMyAccountPageExists();
        /*Data is valid -login success -test pass --logout
        Data is valid --login failed --test failed

        Data is invalid -login success -test fail --logout
        Data is invalid --login failed --test pass
       */

            if (exp.equalsIgnoreCase("valid")) {
                if (targetPage == true) {
                    myaccnt.clicklogout();
                    Assert.assertTrue(true);

                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    myaccnt.clicklogout();
                    Assert.assertTrue(false);

                } else {
                    Assert.assertTrue(false);
                }

            }
        } catch(Exception e)
        {
            Assert.fail();
        }
        logger.info("*** Finished TC003_LoginDDT Test***");
    }
}
