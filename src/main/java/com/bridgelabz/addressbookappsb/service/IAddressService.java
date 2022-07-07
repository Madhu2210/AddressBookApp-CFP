package com.bridgelabz.addressbookappsb.service;


import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;

import java.util.List;
import java.util.Optional;


public interface IAddressService {
    String getMessage();

//   AddressModel AddAddressBook(AddressDTO addressDTO);

    Optional<AddressModel> getContactById(int getId);

    List<AddressModel> getListOfContacts();

    void deleteContact(int id);

    AddressModel updateContact(int getId, AddressDTO addressBookDto);

    Optional<AddressModel> getAddressBookData(String token);

    String addData(AddressDTO addressBookDto);

}
