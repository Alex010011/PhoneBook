package tests;

import models.Contact;
import models.User;
import org.openqa.selenium.interactions.Pause;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (!app.getUserHelper().isLogoutPresents()) {
            app.getUserHelper().login(new User().witnEmail("Mastertest@gmail.com").witnPassword("Nnoa12345$"));
        }


    }

    @Test
    public void addNewContactSuccess(){


        int index = (int)(System.currentTimeMillis()/1000%3600);

        int countStart = app.getContactHelper().countOfContacts();
            System.out.println(countStart);

        Contact contact = Contact.builder()
                .name("Jordano"+index)
                .lastName("Bruno"+index)
                .email("adcd@efg.hi")
                .Address("Citywill")
                .phone("12345"+index+"67")
                .description("test")
                .build();

        app.getContactHelper().pause(5000);
        app.getContactHelper().openAddContact();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();


        int countEnd = app.getContactHelper().countOfContacts();

        Assert.assertEquals(countEnd-countStart,1);

        Assert.assertTrue(app.getContactHelper().IsContactCrateByName(contact.getName());
        Assert.assertTrue(app.getContactHelper().IsContactCrateByPhone(contact.getPhone());

    }
}
