package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    // Check group availability before verification of contact availability
    app.goTo().groupPage();
    if (!app.group().isGroupPresent()) {
      app.group().create(new GroupData().withName("TestGroup"));
    }
    // Check contact availability
    app.goTo().homePage();
    if (!app.contact().isContactPresent()) {
      app.contact().createContact(new ContactData().withFirstName("FirstName").withLastName("LastName").withGroup("TestGroup"), true);
    app.goTo().homePage();
    }
  }

  @Test
  public void testContactModification() {

    app.goTo().homePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("ModifiedFirstName").withLastName("ModifiedLastName").withGroup("TestGroup");
    app.contact().modification(contact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);

    assertThat(after, equalTo(before));
  }
}





