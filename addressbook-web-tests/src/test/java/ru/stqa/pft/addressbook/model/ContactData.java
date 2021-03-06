package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String middlename;
  @Expose
  private String lastname;
  private String nickname;
  private String company;
  @Expose
  private String mobilephone;
  @Expose
  private String email;
  private String homepage;
  private String day_of_birth;
  private String month_of_birth;
  private String year_of_birth;
  private String group;
  @Expose
  private String address;
  @Expose
  private String homenumber;
  @Expose
  private String worknumber;
  private String notes;
  private String allPhones;
  private String allEmails;
  @Expose
  private String email2;
  @Expose
  private String email3;
  private File photo;


  public int getId() {
    return id;
  }
  public String getFirstname() {
    return firstname;
  }
  public String getMiddlename() {
    return middlename;
  }
  public String getLastname() {
    return lastname;
  }
  public String getNickname() {
    return nickname;
  }
  public String getCompany() {
    return company;
  }
  public String getMobilephone() {
    return mobilephone;
  }
  public String getEmail() {
    return email;
  }
  public String getHomepage() {
    return homepage;
  }
  public String getDay_of_birth() {
    return day_of_birth;
  }
  public String getMonth_of_birth() {
    return month_of_birth;
  }
  public String getYear_of_birth() {
    return year_of_birth;
  }
  public String getGroup() {
    return group;
  }
  public String getAddress() {
    return address;
  }
  public String getHomeNumber() {
    return homenumber;
  }
  public String getWorkNumber() {
    return worknumber;
  }
  public String getNotes() {
    return notes;
  }
  public String getAllPhones() {
    return allPhones;
  }
  public String getAllEmails() {
    return allEmails;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMidName(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickName(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withMobPhone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withHomeNum(String homenumber) {
    this.homenumber = homenumber;
    return this;
  }

  public ContactData withWorkNum(String worknumber) {
    this.worknumber = worknumber;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }
  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withDayOfBirth(String day_of_birth) {
    this.day_of_birth = day_of_birth;
    return this;
  }

  public ContactData withMonthOfBirth(String month_of_birth) {
    this.month_of_birth = month_of_birth;
    return this;
  }

  public ContactData withYearOfBirth(String year_of_birth) {
    this.year_of_birth = year_of_birth;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }
}
