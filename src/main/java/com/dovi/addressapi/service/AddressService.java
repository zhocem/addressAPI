package com.dovi.addressapi.service;

import com.dovi.addressapi.dto.AddressDTO;
import com.dovi.addressapi.entity.Address;
import com.dovi.addressapi.mapper.AddressMapper;
import com.dovi.addressapi.repository.AddressRepository;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
  Logger logger = Logger.getLogger(AddressService.class.getName());

  AddressRepository addressRepository;

  @Resource
  AddressMapper addressMapper;

  @Autowired
  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  public List<AddressDTO> getAddresses() {
    return this.addressMapper.mapToAddressDtoList(this.addressRepository.findAll());
  }

  public AddressDTO getAddressById(Long addressId) {
    logger.info("Getting Address by id: " + addressId );
    Optional<Address> optionalAddress = this.addressRepository.findById(addressId);

    return this.addressMapper.mapToAddressDTO(optionalAddress.orElseThrow());
  }

  public AddressDTO createAddress(AddressDTO addressDTO) {
    Address address = this.addressRepository.save(this.addressMapper.mapToAddress(addressDTO));
    return addressMapper.mapToAddressDTO(address);
  }
}
