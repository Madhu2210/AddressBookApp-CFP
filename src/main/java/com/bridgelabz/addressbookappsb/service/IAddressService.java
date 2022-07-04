package com.bridgelabz.addressbookappsb.service;


import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;

import java.util.List;

public interface IAddressService {
    public String getMessage();

    public String AddAddressBook(AddressDTO addressDTO);

    AddressModel getContactById(int getId);

    List<AddressModel> getListContacts();

    void deleteContact(int id);

    AddressModel updateAddressContact(int getId, AddressDTO addressDTO);
}

