package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public  HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//span[text()='My Account']")
        WebElement lnkMy_account;

    @FindBy(xpath="//a[text()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath="//a[text()='Login']")
    WebElement lnkLogin;


    public void click_Myaccount()
    {
        lnkMy_account.click();
    }

    public void click_Register(){
        lnkRegister.click();
    }

    public void click_Login(){
        lnkLogin.click();
    }


}
