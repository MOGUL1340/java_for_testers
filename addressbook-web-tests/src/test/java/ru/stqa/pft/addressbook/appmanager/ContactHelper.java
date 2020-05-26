package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void addNewContact(ContactData contactData) {
    click(By.linkText("add new"));

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());

    click(By.name("bday"));
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay_of_birth());
    click(By.xpath("//option[@value='1']"));

    click(By.name("bmonth"));
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth_of_birth());
    click(By.xpath("//option[@value='December']"));

    type(By.name("byear"), contactData.getYear_of_birth());

    click(By.name("new_group"));
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getContact_group_name());
    click(By.xpath("(//option[@value='5'])[3]"));

    type(By.name("address2"), contactData.getAddress());
    type(By.name("phone2"), contactData.getHomeNumber());
    type(By.name("notes"), contactData.getNotes());
  }
}
