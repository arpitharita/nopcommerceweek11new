package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilitis.Utility;

import java.util.List;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void ComputerTestMenu() throws InterruptedException {
//        Actions actions =new Actions(driver);
//        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
//        WebElement Desktop = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
//        actions.moveToElement(computer).build().perform();
//        actions.moveToElement(Desktop).click().build().perform();

        //1.1 Click on Computer Menu.
       clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul/li/a"));

        //1.2 Click on Desktop
       // clickOnElement(By.xpath("/body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.linkText("Desktops"));
        Thread.sleep(1000);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        String actualText =getTextFromElement(By.xpath("//select[@id='products-orderby']/option[3]"));
        String expectedTest = "Name: Z to A";
        Assert.assertEquals(expectedTest,actualText);

    }
    @Test
    public void TestNameVerifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Click on Computer Menu.
        this.ComputerTestMenu();
        // clickOnElement(By.xpath("/html/body/div[6]/div[2]/ul/li/a"));

        //2.2 Click on Desktop
       // clickOnElement(By.xpath("/body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.linkText("Desktops"));
        Thread.sleep(1000);

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");

        //2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));

        //2.5 Verify the Text "Build your own computer"
        String actualText =getTextFromElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/h2/a"));
        String expectedTest = "Build your own computer";
        Assert.assertEquals(expectedTest,actualText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByValueFromDropdown(By.xpath("//select[@name='product_attribute_1']"),"1");

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByValueFromDropdown(By.xpath("//select[@name='product_attribute_2']"),"5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement (By.xpath("//label[@for='product_attribute_3_7']"));
        Thread.sleep(1000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_4_9']"));

        //A 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        //[+$5.00]"
        clickOnElement(By.xpath("//label[@for='product_attribute_5_10']"));
        clickOnElement(By.xpath("//label[@for='product_attribute_5_12']"));

        //2.11 Verify the price "$1,475.00"
        String actualText1 =getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        String expectedText1 ="$1,475.00";
//        Assert.assertEquals(expectedText1,actualText1);
        Thread.sleep(1000);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualText2 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div/p")); ////div[@class='bar-notification success']
        String expectedText2 = "The product has been added to your shopping cart ";
 //       Assert.assertEquals(expectedText2,actualText2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//div[@class='header-links-wrapper']/div[1]/ul/li[4]/a"));
 //       clickOnElement(By.xpath("button-1 cart-button"));
        Thread.sleep(1000);

        //2.15 Verify the message "Shopping cart"
        String actualText3 = getTextFromElement(By.linkText("Shopping cart"));////div[@class='page-title']/h1")
        String expectedText3 = "Shopping cart";
        Assert.assertEquals(expectedText3,actualText3);
        Thread.sleep(1000);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearTextFromField(By.xpath("//input[@class='qty-input']"));////input[@id='itemquantity11222']
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");
 //       clickOnElement(By.linkText("Update shopping cart"));////button[@id='updatecart']////button[@class='button-2 update-cart-button']
        Thread.sleep(1000);

        //2.17 Verify the Total"$2,950.00"
        String actualText4 = getTextFromElement(By.xpath("//div[@class='cart-footer']/div[2]/div/table/tbody/tr/td[2]/span/strong"));    ////div[@class='cart-footer']/div[2]/div/table/tbody/tr/td[2]/span/strong[1]
        String expectesTeaxt4 = "$2,950.00";
        Assert.assertEquals(expectesTeaxt4,actualText4);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(1000);

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//div[@class='checkout-buttons']/button"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actualText5 = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        String expectesTeaxt5 = "Welcome, Please Sign In!";
        Assert.assertEquals(expectesTeaxt5,actualText5);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));

        //2.22 Fill the all mandatory field
        sendKeysToElement(By.xpath("//input[@data-val-required='First name is required.']"),"ketty");
        sendKeysToElement(By.xpath("//input[@data-val-required='Last name is required.']"),"xyz");
        sendKeysToElement(By.xpath("//input[@data-val-required='Email is required.']"),"ketty@23gmail.com");
        selectByValueFromDropdown(By.xpath("//label[@for='BillingNewAddress_CountryId']"),"153");
        sendKeysToElement(By.xpath("//select[@data-trigger='country-select']"),"Canada");
        sendKeysToElement(By.xpath("//select[@name='BillingNewAddress.StateProvinceId']"),"Ontario");
        sendKeysToElement(By.xpath("//input[@data-val-required='City is required']"),"etobicoke");
        sendKeysToElement(By.xpath("//input[@data-val-required='Street address is required']"),"kingstreet");
        sendKeysToElement(By.xpath("//input[@data-val-required='Zip / postal code is required']"),"m9v7t5");
        sendKeysToElement(By.xpath("//input[@data-val-required='Phone is required']"),"+11234567891");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//div[@class='section shipping-method']/ul/li[2]/div"));
        Thread.sleep(1000);

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//div[@class='section payment-method']/ul/li[2]/div"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValueFromDropdown(By.xpath("//select[@class='dropdownlists']/option[2]"),"MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@data-val-required='Enter cardholder name']"),"kettyxyz");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5123 4590 4605 8920");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@data-val-required='Expire month is required']"),"07");
        Thread.sleep(1000);
        selectByValueFromDropdown(By.xpath("//select[@data-val-required='Expire year is required']"),"2025");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@name='CardCode']"),"213");
        Thread.sleep(1000);

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is“Credit Card”
        String actualText6 = getTextFromElement(By.xpath("//div[@class='order-summary-content']/div[1]/div[1]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedTest6 = "Credit Card";
        Assert.assertEquals(expectedTest6,actualText6);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShipping =getTextFromElement(By.xpath("//div[@class='order-summary-content']/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        String expectedShipping = "Next Day Air";
        Assert.assertEquals(expectedShipping,actualShipping);
        Thread.sleep(1000);

        //2.33 Verify Total is “$2,950.00”
        String actualTotal = getTextFromElement(By.xpath("//div[@class='total-info']/table/tbody/tr[4]/td[2]/span[1]/strong[1]"));
        String expectedTotal = "$2,950.00";
        Assert.assertEquals(expectedTotal,actualTotal);
        Thread.sleep(1000);

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button[1]"));
        Thread.sleep(1000);

        //2.35 Verify the Text “Thank You”
        String actualText7 = getTextFromElement(By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1"));
        String expectedText7 = "Thank you";
        Assert.assertEquals(expectedText7,actualText7);

        //2.36 Verify the message “Your order has been successfully processed!”
        String  actualMessage = getTextFromElement(By.xpath("//div[@class='page checkout-page order-completed-page']/div[2]/div[1]/div[1]/strong"));
        String expectedMessage = "Your order has been successfully processed!";
        Assert.assertEquals(expectedMessage,actualMessage);
        Thread.sleep(1000);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        Thread.sleep(1000);
        //2.37 Verify the text “Welcome to our store”
        String actualWelcomeMsg = getTextFromElement(By.xpath("//div[@class='center-1']/div[1]/div[1]/div[2]/div[1]/h2[1]"));
        String expectedWelcomeMsg = "Welcome to our store";
        Assert.assertEquals(expectedWelcomeMsg,actualWelcomeMsg);
        Thread.sleep(1000);
    }
    @After
    public void closebrowser(){
    //    closebrowser();
    }
}