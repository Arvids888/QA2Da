package Model;

public class Contact {
    //-PARAMS-
    private String firstName;
    private String lastName;
    private String phoneNumber;

    //---CONSTRUCTOR---
    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.phoneNumber= phoneNumber;

    }

    public Contact() {}

    //---GETTERS / SETTERS---


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        if (lastName ==null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = String.valueOf(phoneNumber);
    }

    //---ADDITIONAL METHODS---
    public String getFullInfo() {
        return firstName + " " + lastName + ": " + phoneNumber;
    }
}
