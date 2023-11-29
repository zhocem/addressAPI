package com.dovi.addressapi.controller;


import com.dovi.addressapi.dto.AddressDTO;
import com.dovi.addressapi.service.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
@RefreshScope
public class AddressController {

  @Value("${address.test}")
  private String test;

  @Autowired
  AddressService addressService;

  @GetMapping("/test")
  public String test() {
    return test;
  }

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
