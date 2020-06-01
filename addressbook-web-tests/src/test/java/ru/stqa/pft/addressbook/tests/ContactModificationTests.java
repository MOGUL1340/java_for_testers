package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    // Check group availability before verification of contact availability
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("TestGroup", null, null));
    }
    // Check contact availability
    app.getNavigationHelper().returnToHomepage();
    if (!app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("Name", "MiddleName",
              "LastName", "Nickname", "Company",
              "+0123456789", "test@mail.com", "testpage.com",
              "1", "December", "1980",
              "TestGroup", "TestDrive 123", "123", "test notes"), true);
      app.getNavigationHelper().returnToHomepage();
    }
    app.getContactHelper().initFirstContactModification();
    app.getContactHelper().fillContactForm(new ContactData("ModifiedName", "ModifiedMiddleName",
            "ModifiedLastName", "Nickname", "Company",
            "+0123456789", "test@mail.com", "testpage.com",
            "1", "December", "1980",
            null, "TestDrive 123", "123", "test notes"), false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomepage();
  }
}





