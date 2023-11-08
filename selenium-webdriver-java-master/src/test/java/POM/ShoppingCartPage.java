package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    WebDriver driver;

    By mobileLink = By.xpath("//a[normalize-space()='Mobile']");

    By iphoneCart = By.xpath("(//button[@title='Add to Cart'])[1]");

    By discountCode = By.id("coupon_code");

    By applyButton = By.cssSelector("button[title='Apply'] span span");


    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void MobileClick(){
        driver.findElement(mobileLink).click();
    }

    public void IphoneAddToCartButton(){
        driver.findElement(iphoneCart).click();
    }

    public void ApplyClick(){
        driver.findElement(applyButton).click();
    }

    public void enterDiscountCode(String code) {
        WebElement codeElement = driver.findElement(discountCode);
        codeElement.clear();
        codeElement.sendKeys(code);
    }


}

