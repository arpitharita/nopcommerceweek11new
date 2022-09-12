package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilitis.Utility;

import java.util.List;

public class TopManuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type
    //string
    //1.2 This method should click on the menu whatever name is passed as parameter.

    public void selectMenu(String menu) {
        List<WebElement> topMenuname = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]"));

        for (WebElement name : topMenuname) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }

    //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
    //select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyComputerPageNavigation() {
        //1.3. create the @Test method name verifyPageNavigation.use selectMenu method to select the Menu and click on it and verify the page navigation.
        selectMenu("Computers");
        verifyText("Computers", By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a[1]"), "Computer");
    }
    @Test
    public void verifyElectronicsPageNavigation() {
        selectMenu("Electronics");
        verifyText("Electronics", By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a"), "Electronics");

    }
    @Test
    public void verifyApparelPageNavigation() {
        selectMenu("Apparel");
        verifyText("Apparel", By.xpath("//div[@class='header-menu']/ul[1]/li[3]/a"), "Apparel");

    }
    @Test
    public void verifyDigitaldownloadsPageNavigation() {
        selectMenu("Digital downloads");
        verifyText("Digital downloads", By.xpath("//div[@class='header-menu']/ul[1]/li[4]/a"), "Digital downloads");

    }
    @Test
    public void verifyBooksPageNavigation() {
        selectMenu("Books");
        verifyText("Books", By.xpath("//div[@class='header-menu']/ul[1]/li[5]/a"), "Books");

    }
    @Test
    public void verifyEJewelryPageNavigation() {
        selectMenu("Jewelry");
        verifyText("Jewelry", By.xpath("//div[@class='header-menu']/ul[1]/li[6]/a"), "Jewelry");

    }
    @Test
    public void GiftCardsPageNavigation() {
        selectMenu("Gift Cards");
        verifyText("Gift Cards", By.xpath("//div[@class='header-menu']/ul[1]/li[7]a"), "Gift Cards");

    }
    @After
    public void closebrowser(){
        closebrowser();
    }
}
