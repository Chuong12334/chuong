package BaiTap;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

/*

Test Steps

1. Go to http://live.techpanda.org/

2. Click on MOBILE menu

3. In the list of all mobile , click on ADD TO CART for Sony Xperia mobile

4. Change QTY value to 1000 and click UPDATE button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on EMPTY CART link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty

*/
@Test
public class TC03 {
    public static void testTC03() {
        int scc = 0;

        StringBuffer verificationError = new StringBuffer();
        //int web driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //Step 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            //Step 2. Click on MOBILE menu
            driver.findElement(By.linkText("MOBILE")).click();
            //timing
            Thread.sleep(2000);

            //Step 3. In the list of all mobile , click on ADD TO CART for Sony Xperia mobile
            String XPeriaPrice = driver.findElement(By.cssSelector("#product-price-1 > span.price")).getText();
            System.out.println(XPeriaPrice);
            //timing
            Thread.sleep(2000);

            //Step 4. Change QTY value to 1000 and click UPDATE button. Expected that an error is displayed
            WebElement Qty = driver.findElement(By.name("input[title='Qty']"));
            Qty.clear();
            Qty.sendKeys("1000");
            WebElement updateButton = driver.findElement(By.name("span[shub-ins='1']"));
            updateButton.click();
            //timing
            Thread.sleep(2000);

            //Step 5. Verify the error message
            String errorMessage = driver.findElement(By.cssSelector(".item-msg.error")).getText();
            System.out.println("Error Message: " + errorMessage);
            //timing
            Thread.sleep(2000);

            //Step 6. Then click on EMPTY CAR T link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.
            WebElement emptyCartLink = driver.findElement(By.linkText("span[shub-ins='1']"));
            emptyCartLink.click();
            //timing
            Thread.sleep(2000);

            //Step 7. Verify cart is empty
            scc = (scc + 1);

            File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png2 = ("" + scc + ".png");
            FileUtils.copyFile(scrFile, new File(png));
        }catch (Exception e){
            e.printStackTrace();
        }

        // end
            driver.quit();
    }
}
