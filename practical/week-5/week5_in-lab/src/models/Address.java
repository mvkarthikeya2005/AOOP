// File: src/models/Address.java
package models;

public class Address {
    private String city;
    private String state;
    private String country;

    // Constructor
    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}
