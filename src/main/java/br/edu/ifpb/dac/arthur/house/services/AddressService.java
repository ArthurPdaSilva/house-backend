package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.exceptions.AddressNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.AddressModel;
import br.edu.ifpb.dac.arthur.house.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class AddressService {

    private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public AddressModel findById(UUID id) throws AddressNotFoundException {
		Optional<AddressModel> addressModel = addressRepository.findById(id);
		if(addressModel.isEmpty()) {
			throw new AddressNotFoundException();
		}
		return addressModel.get();
	}

	public List<AddressModel> findAll() {
		return addressRepository.findAll();
	}

	public AddressModel save(String street, String number, String city, String code, String country) {
		AddressModel addressModel = new AddressModel(street, number, city, code, country);
		return addressRepository.save(addressModel);
	}
}
