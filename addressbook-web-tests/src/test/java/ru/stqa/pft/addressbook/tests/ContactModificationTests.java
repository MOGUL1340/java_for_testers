package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initFirstContactModification();
    ContactData contact = new ContactData("Name", "MiddleName",
            "LastName", "Nickname", "Company",
            "+0123456789", "test@mail.com", "testpage.com",
            "1", "December", "1980",
            "TestGroup", "TestDrive 123", "123", "test notes");
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactUpdate();
    app.getNavigationHelper().returnToHomepage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}





