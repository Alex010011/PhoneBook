package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registr extends TestBase {

    @BeforeMethod
    public void preCondition(){

        if(app.getUserHelper().isLogoutPresents())
            app.getUserHelper().logout();
    }

@Test
    public void registrationSuccess() {

        int index = (int)(System.currentTimeMillis()/1000%3600);
        app.getUserHelper().openLogRegForm();
        app.getUserHelper().fillRegistrationForm("Mastertest"+index+"@gmail.com","Nnoa12345$");
        app.getUserHelper().submitRegForm();

        Assert.assertTrue(app.getUserHelper().isRegistrSuccess());
    }

    @Test
    public void registrationSuccessModel() {

        int index = (int)(System.currentTimeMillis()/1000%3600);

        User user = new User().witnEmail("Mastertest"+index+"@gmail.com").witnPassword("Nnoa12345$");

        app.getUserHelper().openLogRegForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().submitRegForm();

        Assert.assertTrue(app.getUserHelper().isRegistrSuccess());
    }

}

//    WebDriver wd;
//
//    @BeforeMethod
//    public void peconditions(){
//
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/login");
//    }
//
//    @Test
//    public void Test1(){
//
//        click(By.cssSelector("[href= '/login']"));
//        click(By.cssSelector("[placeholder='Email']"));
//        type(By.cssSelector("[placeholder='Email']"),"Mastertest@gmail.com");
//
//        click(By.cssSelector("[placeholder='Password']"));
//        type(By.cssSelector("[placeholder='Password']"), "masterTest1$");
//
//        click(By.cssSelector("div button:last-of-type"));
//    }
//
//    @Test
//    public void loginXPath(){
//
//        click(By.xpath("//*[@placeholder='Email']"));
//        type(By.xpath("//*[@placeholder='Email']"), "noa@gmail.com");
//
//        click(By.xpath("//*[@placeholder='Password']"));
//        type(By.xpath("//*[@placeholder='Password']"), "Nnoa12345$");
//
//        click(By.xpath("//*[text()=' Login']"));
//
//    }
//
//    public void type(By locator, String text) {
//        click(locator);
//        wd.findElement(locator).clear();
//        wd.findElement(locator).sendKeys(text);
//    }
//
//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }
//
//    @Test
//
//    public void fillRegistrationTest(){
//
//        List <WebElement> list = wd.findElements(By.tagName("input"));
//        WebElement inputEmail = list.get(0);
//        WebElement inputPass = list.get(1);
//
//        inputEmail.click();
//        inputEmail.clear();
//        inputEmail.sendKeys("noa101100@gmail.com");
//
//        inputPass.click();
//        inputPass.clear();
//        inputPass.sendKeys("Nnoa12345$");
//
//        List <WebElement> buttons = wd.findElements(By.tagName("button"));
//        WebElement buttonReg = buttons.get(1);
//        buttonReg.click();
//
//    }
//
//    @AfterMethod
//    public void close(){
//
//        // wd.quit();//closing all tabs
//        // wd.close();//focus on page
//    }

