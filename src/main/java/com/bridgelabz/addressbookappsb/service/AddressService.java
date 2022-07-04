package com.bridgelabz.addressbookappsb.service;

import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;
import com.bridgelabz.addressbookappsb.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    @Autowired
    IAddressRepository repo;

    @Override
    public String getMessage() {

        return "Welcome to Address Book";
    }


    @Override
    public String AddAddressBook(AddressDTO addressDTO) {
        AddressModel addressModel=new AddressModel(addressDTO);
        repo.save(addressModel);
        return addressModel.toString();
    }

    @Override
    public AddressModel getContactById(int getId) {
        Optional<AddressModel> addressModel = repo.findById(getId);
        return addressModel.get();

    }

    @Override
    public List<AddressModel> getListContacts() {
        List<AddressModel> addressModels = repo.findAll();
        return addressModels;
    }

    @Override
    public void deleteContact(int id) {
        repo.deleteById(id);
    }


    @Override
    public AddressModel updateAddressContact(int getId, AddressDTO addressDTO) {
        Optional<AddressModel> newContact = repo.findById(getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressDTO.getFullName());
            newContact.get().setAddress(addressDTO.getAddress());
            newContact.get().setCity(addressDTO.getCity());
            newContact.get().setState(addressDTO.getState());
            newContact.get().setZip(addressDTO.getZip());
            newContact.get().setPhone(addressDTO.getPhone());
            repo.save(newContact.get());
            return newContact.get();
        } else {
            return null;
        }
    }
}

