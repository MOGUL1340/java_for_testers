package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreationTests() throws Exception {

    // Check group availability before contact creation
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("TestGroup", null, null));
    }
    app.getContactHelper().createContact(new ContactData("Name", "MiddleName",
            "LastName", "Nickname", "Company",
            "+0123456789", "test@mail.com", "testpage.com",
            "1", "December", "1980",
            "TestGroup", "TestDrive 123", "123", "test notes"), true);
    app.getNavigationHelper().returnToHomepage();
  }
}
