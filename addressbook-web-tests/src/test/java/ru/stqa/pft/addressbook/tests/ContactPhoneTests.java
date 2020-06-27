package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    ContactData contactData = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contactData);

    assertThat(contactData.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
  }

  private String mergePhones(ContactData contactData) {
    return Arrays.asList(contactData.getHomeNumber(), contactData.getMobilephone(), contactData.getWorkNumber())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
