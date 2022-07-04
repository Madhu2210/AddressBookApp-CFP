package com.bridgelabz.addressbookappsb.DTO;

public class AddressDTO {

    private String fullName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public AddressDTO(String fullName, String address, String state, String city, int zip, long phone) {
        this.fullName = fullName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public AddressDTO() {
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zip +
                ", phone=" + phone +
                '}';
    }
}

