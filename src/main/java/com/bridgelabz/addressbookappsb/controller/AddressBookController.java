package com.bridgelabz.addressbookappsb.controller;


import com.bridgelabz.addressbookappsb.DTO.AddressDTO;
import com.bridgelabz.addressbookappsb.DTO.ResponseDTO;
import com.bridgelabz.addressbookappsb.model.AddressModel;
import com.bridgelabz.addressbookappsb.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AddressBookService")
public class AddressBookController {
    @Autowired
    IAddressService service;


    @GetMapping("/hello")
    public String hello() {
        String msg = service.getMessage();
        return msg;
    }

//     @PostMapping("/AddContact")
//      public ResponseEntity<ResponseDTO> AddContact(@Valid @RequestBody AddressDTO addressDTO) {
//         AddressModel addressModel = service.AddAddressBook(addressDTO);
//         ResponseDTO responseDTO = new ResponseDTO("Contact added Successfully", addressModel);
//         return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//     }

    /** creating insert API, to insert Data
     *
     * @param addressBookDto
     * @return
     */
    @PostMapping(value = "/insert")
    public ResponseEntity<ResponseDTO> addEmployeePayRollData(@Valid @RequestBody AddressDTO addressBookDto)
    {
        String addData = service.addData(addressBookDto);
        ResponseDTO response = new ResponseDTO("Contact added successfully",addData);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /** Creating retrieve API,to retrieve a data
     *
     * @param token
     * @return
     */
    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable String token)
    {
        Optional<AddressModel> addressBook = service.getAddressBookData(token);
        ResponseDTO response = new ResponseDTO("Contact retrieved successfully",addressBook);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /** Creating getContact to retrieve data
     *
     * @param getId
     * @return
     */
    @GetMapping("/getContact/{getId}")
    public ResponseEntity<ResponseDTO> getContact(@PathVariable int getId) {
        Optional<AddressModel> contactId = service.getContactById(getId);
        ResponseDTO response = new ResponseDTO("Contact retrieved successfully by id:" +" " +getId,contactId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**Creating getContacts Api, to get the list of contacts
     *
     * @return ResponseDto
     */
    @GetMapping("/getContacts")
    public ResponseEntity<ResponseDTO> getContacts() {
        List<AddressModel> contacts = service.getListOfContacts();
        ResponseDTO response = new ResponseDTO("retrieved list of contacts all data Successfully", contacts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**Creating delete Api, to delete the contact by id
     *
     * @param id
     * @return ResponseDto
     */
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestParam int id) {
        service.deleteContact(id);
        ResponseDTO response = new ResponseDTO("deleted contact successfully", id );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**Creating updateContact Api,to update the contact by id
     *
     * @param getId
     * @param addressBookDto
     * @return ResponseDto
     */
    @PutMapping("/updateContact/{getId}")
    public ResponseEntity<ResponseDTO> updateContact(@PathVariable int getId, @Valid @RequestBody AddressDTO addressBookDto) {
        AddressModel updateContact = service.updateContact(getId, addressBookDto);
        ResponseDTO response = new ResponseDTO("updated contact successfully", updateContact);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

