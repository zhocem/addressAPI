package com.dovi.addressapi.dto;

import lombok.Data;

@Data
public class AddressDTO {

  private Long addressId;

  private String street;

  private String city;
}
