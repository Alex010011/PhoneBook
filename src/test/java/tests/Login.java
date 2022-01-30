package tests;


import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase{

    @BeforeMethod
    public void preCondition(){

        if(app.getUserHelper().isLogoutPresents())
            app.getUserHelper().logout();
        }


@Test
    public void loginSuccess(){

        app.getUserHelper().openLogRegForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test
    public void loginSuccessModel(){
    User user = new User().witnEmail("noa@gmail.com").witnPassword("Nnoa12345$");

        app.getUserHelper().openLogRegForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

}
//    WebDriver wd;
//
//
//    @BeforeMethod
//    public void preconditions(){
//
//        wd = new ChromeDriver();
//        wd.manage().window().maximize();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//
//    }
//
//    @Test
//    public void loginSuccessTest(){
//
//       // int index = (int)(System.currentTimeMillis()/1000)%3600;
//
//
//        click(By.cssSelector("[href= '/login']"));
//        type(By.cssSelector("[placeholder='Email']"), "mastertest@gmai.com");
//        type(By.cssSelector("[placeholder='Password']"), "masterTest1@");
//        click(By.cssSelector("div button:first-of-type"));
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
//
//    }


   // @AfterMethod
  //  public void postconditions(){

      //  wd.close();
      //  wd.quit();
  //  }


