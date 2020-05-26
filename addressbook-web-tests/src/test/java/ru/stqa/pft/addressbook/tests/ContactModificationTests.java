package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initFirstContactModification();
    app.getContactHelper().modifyContact(new ContactData("ModifiedName", "ModifiedMiddleName",
            "ModifiedLastName", "Nickname", "Company",
            "+0123456789", "test@mail.com", "testpage.com",
            "1", "December", "1980",
            "TestGroup", "TestDrive 123", "123", "test notes"));
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomepage();
  }
}





