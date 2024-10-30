package com.example.lw3;

import javafx.beans.property.*;

/**
 * Класс-модель для адресата (Person).
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty name;
    private final StringProperty size;
    private final StringProperty weight;
    private final StringProperty nameCompany;
    private final StringProperty country;
    private final StringProperty contactPerson;
    private final StringProperty phone;

    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this(null, null,null);
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param name
     *
     *
     */
    public Person(String name, String size, String weight) {
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleStringProperty(size);
        this.weight = new SimpleStringProperty(weight);

        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.nameCompany = new SimpleStringProperty("какая-то компания");
        this.country = new SimpleStringProperty("какая-то страна");
        this.contactPerson = new SimpleStringProperty("контактное лицо");
        this.phone = new SimpleStringProperty("+3800000000");
    }


    public String getName() {
        return name.get();
    }

    public void setName(String firstName) {
        this.name.set(firstName);
    }
    public StringProperty nameProperty() {
        return name;
    }


    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }
    public StringProperty sizeProperty() {
        return size;
    }


    public String getWeight() {return weight.get();}
    public void setWeight(String weight) {this.weight.set(weight);}
    public StringProperty weightProperty(){return weight;}



    public String getCompany() {
        return nameCompany.get();
    }

    public void setCompany(String street) {
        this.nameCompany.set(street);
    }

    public StringProperty companyProperty() {
        return nameCompany;
    }



    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public StringProperty CountryProperty() {
        return country;
    }


    public String getContactPerson() {
        return contactPerson.get();
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson.set(contactPerson);
    }

    public StringProperty contactPersonProperty() {
        return contactPerson;
    }


    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty PhoneProperty() {
        return phone;
    }
}