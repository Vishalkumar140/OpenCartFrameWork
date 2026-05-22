package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{

    public AccountRegistration (WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txt_firstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txt_lastname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_email;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txt_telephone;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_password;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txt_confirmpsswrd;

    @FindBy(xpath="//input[@type='checkbox']")
    WebElement chkdpolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btn_continue;

    @FindBy(xpath="//h1[normalize-space()=\"Your Account Has Been Created!\"]")
    WebElement msgconfirmation;



    public void set_firstname(String fname) {
        txt_firstname.sendKeys(fname);
    }

    public void set_lastname(String lname) {
        txt_lastname.sendKeys(lname);
    }

    public void set_email(String email) {
        txt_email.sendKeys(email);
    }

    public void set_telephoneno(String tel){
        txt_telephone.sendKeys(tel);
    }

    public void set_password(String pwd){
        txt_password.sendKeys(pwd);
    }

    public void set_confrmpassword(String pwd){
        txt_confirmpsswrd.sendKeys(pwd);
    }

   public void clickprivatepolicy(){
       chkdpolicy.click();
   }

    public void click_continuebtn(){
        btn_continue.click();
    }

    public String getconfirmationMsg(){
        try{
            return(msgconfirmation.getText());
        }
        catch (Exception e){
            return(e.getMessage());
        }

    }

















}
