package com.dovi.addressapi.controller;


import com.dovi.addressapi.dto.AddressDTO;
import com.dovi.addressapi.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

  @Autowired
  AddressService addressService;

  @GetMapping()
  public List<AddressDTO> getAllAddresses() {
    return this.addressService.getAddresses();
  }

  @GetMapping("/{id}")
  public AddressDTO getAddressById(@PathVariable Long id) {
    return addressService.getAddressById(id);
  }

  @PostMapping
  public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
    return addressService.createAddress(addressDTO);
  }


}
