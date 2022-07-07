package com.bridgelabz.addressbookappsb.service;

import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;
import com.bridgelabz.addressbookappsb.repository.IAddressRepository;
import com.bridgelabz.addressbookappsb.util.EmailSenderService;
import com.bridgelabz.addressbookappsb.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {


    @Autowired
    IAddressRepository repo;

    @Autowired
    TokenUtil tokenutil;

    @Autowired
    EmailSenderService sender;
    @Override
    public String getMessage() {

        return "Hello welcome to AddressBook";
    }

//    @Override
//    public AddressModel AddAddressBook(AddressDTO addressDTO) {
//        AddressModel addressModel = new AddressModel(addressDTO);
//        repo.save(addressModel);
//        return addressModel;
//    }

    @Override
    public String addData(AddressDTO addressBookDto) {
        AddressModel addressModel = new AddressModel(addressBookDto);
        repo.save(addressModel);
        String token=tokenutil.createToken(addressModel.getId());
        sender.sendEmail(addressModel.getEmail(), "Test Email",
                "Registered Successfully :click here-> " +
                        " "+"http://localhost:8080/AddressBookService/retrieve/"+token);
        return token;
    }
    @Override
    public Optional<AddressModel> getAddressBookData(String token) {
        int id=tokenutil.decodeToken(token);
        Optional<AddressModel> addressBook=repo.findById(id);
        if(addressBook.isPresent()) {
            sender.sendEmail(addressBook.get().getEmail(),"TestMail",
                    "Retrieved Contact successfully :click here->"+
                            "http://localhost:8080/AddressBookService/retrieve/"+token);
            return addressBook;
        }else {
            return null;
        }
    }


    /**
     * getting contact details by id
     *
     * @param getId
     * @return
     */
    @Override
    public Optional<AddressModel> getContactById(int getId) {
        Optional<AddressModel> addressBook = repo.findById(getId);
        if (addressBook.isPresent()) {
            return addressBook;
        } else {
            return null;
        }
    }
    /**
     * getting list of contact details
     *
     * @return
     */
    @Override
    public List<AddressModel> getListOfContacts() {
        List<AddressModel> contacts = repo.findAll();
        return contacts;
    }

    /**
     * delete contact by id
     *
     * @param id
     */
    @Override
    public void deleteContact(int id) {
        Optional<AddressModel> addressBook = repo.findById(id);
        repo.deleteById(id);
        sender.sendEmail(addressBook.get().getEmail(),"TestMail",
                "Contact deleted Successfully"+addressBook.toString());
    }
    /**
     * update contact details by id
     *
     * @param getId
     * @param addressBookDto
     * @return
     */
    @Override
    public AddressModel updateContact(int getId, AddressDTO addressBookDto) {
        Optional<AddressModel> newContact = repo.findById(getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressBookDto.getFullName());
            newContact.get().setAddress(addressBookDto.getAddress());
            newContact.get().setCity(addressBookDto.getCity());
            newContact.get().setState(addressBookDto.getState());
            newContact.get().setZip(addressBookDto.getZip());
            newContact.get().setPhone(addressBookDto.getPhone());
            newContact.get().setEmail(addressBookDto.getEmail());
            repo.save(newContact.get());
            sender.sendEmail(newContact.get().getEmail(),"Test Mail",
                    "To get Updated Contact: click here->"+
                            "http://localhost:8080/AddressBookService/getContact/"+getId);
            return newContact.get();
        } else {
            return null;
        }
    }
}

