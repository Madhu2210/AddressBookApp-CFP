package com.bridgelabz.addressbookappsb.model;

import com.bridgelabz.addressbookappsb.DTO.AddressDTO;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressModel {

    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String address;
    private String state;
    private String city;
    private int zip;
    private long phone;

    public AddressModel(AddressDTO addressDTO) {
        this.fullName=addressDTO.getFullName();
        this.address=addressDTO.getAddress();
        this.state=addressDTO.getState();
        this.city=addressDTO.getCity();
        this.zip=addressDTO.getZip();
        this.phone=addressDTO.getPhone();

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public AddressModel(int id, String fullName, String address, String state, String city, int zip, long phone) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public AddressModel() {
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

