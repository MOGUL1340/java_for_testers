package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  NavigationHelper navigationHelper = new NavigationHelper(wd);

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());

//    click(By.name("bday"));
//    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay_of_birth());
//    click(By.xpath("//option[@value='1']"));
//
//    click(By.name("bmonth"));
//    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth_of_birth());
//    click(By.xpath("//option[@value='December']"));

    type(By.name("byear"), contactData.getYear_of_birth());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getAddress());
    type(By.name("phone2"), contactData.getHomeNumber());
    type(By.name("notes"), contactData.getNotes());
  }

  public void select(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initModificationsById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void modification(ContactData contact) {
    initModificationsById(contact.getId());
    fillContactForm(contact, false);
    submitContactUpdate();
    navigationHelper.homePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    pressDeleteButton();
    acceptAlert();
    navigationHelper.homePage();
  }

  public void submitContactUpdate() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void createContact(ContactData contact, boolean creation) {
    navigationHelper.homePage();
    initContactCreation();
    fillContactForm(contact, true);
    submitContact();
  }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void pressDeleteButton() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public boolean isContactPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initModificationsById(contact.getId());

    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homenumber = wd.findElement(By.name("home")).getAttribute("value");
    String mobilephone = wd.findElement(By.name("mobile")).getAttribute("value");
    String worknumber = wd.findElement(By.name("work")).getAttribute("value");

    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).
            withHomeNum(homenumber).withMobPhone(mobilephone).withWorkNum(worknumber);
  }
}