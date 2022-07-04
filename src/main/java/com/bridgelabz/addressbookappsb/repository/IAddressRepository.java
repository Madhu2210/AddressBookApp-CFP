package com.bridgelabz.addressbookappsb.repository;

import com.bridgelabz.addressbookappsb.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<AddressModel, Integer> {

}

