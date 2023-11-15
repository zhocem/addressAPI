package com.dovi.addressapi.mapper;

import com.dovi.addressapi.dto.AddressDTO;
import com.dovi.addressapi.entity.Address;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface AddressMapper {

  AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

  @Mapping(target = "addressId", source = "address.id")
  AddressDTO mapToAddressDTO(Address address);

  @Mapping(target = "id", source = "addressDTO.addressId")
  Address mapToAddress(AddressDTO addressDTO);

  List<AddressDTO> mapToAddressDtoList(List<Address> addressList);
}
