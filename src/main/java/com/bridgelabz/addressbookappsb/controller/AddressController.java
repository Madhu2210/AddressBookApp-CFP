package com.bridgelabz.addressbookappsb.controller;

import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.DTO.ResponseDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;
import com.bridgelabz.addressbookappsb.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AddressBookService")
public class AddressController {

    @Autowired
    IAddressService service;

    @GetMapping("/hello")
    public String hello(){
        String msg=service.getMessage();
        return msg;
    }

    @PostMapping("/AddContact")
    public ResponseEntity<ResponseDTO> AddContact(@RequestBody AddressDTO addressDTO){
        String AddContact=service.AddAddressBook(addressDTO);
        ResponseDTO responseDTO=new ResponseDTO("Contact added successfully", AddContact);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContact/{getId}")
    public ResponseEntity<ResponseDTO> getContact(@PathVariable int getId)
    {
        AddressModel addressModel=service.getContactById(getId);
        ResponseDTO responseDTO=new ResponseDTO("Getting contact by id successfully", addressModel);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getContacts")
    public ResponseEntity<ResponseDTO> getContacts()
    {
        List<AddressModel> addressModel=service.getListContacts();
        ResponseDTO responseDTO=new ResponseDTO("Got list of contacts successfully", addressModel);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestParam int id){
        service.deleteContact(id);
        ResponseDTO responseDTO= new ResponseDTO("Contact Deleted Successfully", id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);

    }

    @PutMapping("/updateContact/{getId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int getId,@RequestBody AddressDTO  addressDTO){
        AddressModel updateContact=service.updateAddressContact(getId,addressDTO);
        ResponseDTO responseDTO= new ResponseDTO("Contact Updated successfully", updateContact);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

}

