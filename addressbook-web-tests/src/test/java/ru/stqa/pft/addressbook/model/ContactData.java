package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String mobilephone;
  private final String email;
  private final String homepage;
  private final String day_of_birth;
  private final String month_of_birth;
  private final String year_of_birth;
  private final String contact_group_name;
  private final String address;
  private final String homenumber;
  private final String notes;

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String mobilephone, String email, String homepage, String day_of_birth, String month_of_birth, String year_of_birth, String contact_group_name, String address, String homenumber, String notes) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.mobilephone = mobilephone;
    this.email = email;
    this.homepage = homepage;
    this.day_of_birth = day_of_birth;
    this.month_of_birth = month_of_birth;
    this.year_of_birth = year_of_birth;
    this.contact_group_name = contact_group_name;
    this.address = address;
    this.homenumber = homenumber;
    this.notes = notes;
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

  public String getContact_group_name() {
    return contact_group_name;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeNumber() {
    return homenumber;
  }

  public String getNotes() {
    return notes;
  }
}