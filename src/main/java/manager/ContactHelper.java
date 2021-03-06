package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openAddContact() {
        click(By.cssSelector("[href='/add']"));
    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void submitForm() {
        click(By.xpath("//*[text()='Save']"));
    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }


    public boolean IsContactCrateByName(String name) {

        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
            }
            return false;
        }


    public boolean IsContactCrateByPhone(String phone) {

        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }
}

