package com.bridgelabz.addressbookappsb.model;

import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
public class AddressModel {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String address;
    private String state;
    private String city;
    private String zip;
    private String phone;

    private String email;

    public AddressModel(AddressDTO addressDTO) {
        this.fullName = addressDTO.getFullName();
        this.address = addressDTO.getAddress();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zip = addressDTO.getZip();
        this.phone = addressDTO.getPhone();
        this.email=addressDTO.getEmail();
    }
}