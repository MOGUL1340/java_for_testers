package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @Test
  public void testContactDeletion() {

    // Check group availability before verification of contact availability
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("TestGroup", null, null));
    }
    // Check contact availability
    app.getNavigationHelper().returnToHomepage();
    List<ContactData> before = app.getContactHelper().getContactList();
    if (! app.getContactHelper().isContactPresent()) {
      app.getContactHelper().createContact(new ContactData("Name", "MiddleName",
              "LastName", "Nickname", "Company",
              "+0123456789", "test@mail.com", "testpage.com",
              "1", "December", "1980",
              "TestGroup", "TestDrive 123", "123", "test notes"), true);
      app.getNavigationHelper().returnToHomepage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptAlert();
    app.getNavigationHelper().returnHomeAfterDeletion();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
