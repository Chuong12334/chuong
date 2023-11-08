package BaiTap;

import POM.CartPage;
import POM.CheckOutPage;
import POM.ShoppingCartPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.openqa.selenium.OutputType.FILE;
@Test
public class TC09 {
    public static void testTC09() {
        int scc = 0;
        String code = "GURU50";

        WebDriver driver = driverFactory.getChromeDriver();
        try {
            CheckOutPage checkoutPage = new CheckOutPage(driver);
            CartPage cartPage = new CartPage(driver);
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org");
            Thread.sleep(1000);

            //Step 2. Go to Mobile and add IPHONE to cart
            shoppingCartPage.MobileClick();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            shoppingCartPage.IphoneAddToCartButton();
            Thread.sleep(1000);

            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            String firstTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']")).getText();

            //Step 3. Enter Coupon Code
            shoppingCartPage.enterDiscountCode(code);
            Thread.sleep(1000);

            shoppingCartPage.ApplyClick();
            Thread.sleep(1000);

            //Step 4. Verify the discount generated
            String afterTotal = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']")).getText();
            if (firstTotal.contains(afterTotal)){
                System.out.println("Total not discount");
            } else {
                System.out.println("Total has discount");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Quit browser session
        driver.quit();
    }
}
