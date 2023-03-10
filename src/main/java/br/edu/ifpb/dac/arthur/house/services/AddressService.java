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

	public List<AddressModel> findAll() {
		return this.addressRepository.findAll();
	}

	public AddressModel save(AddressModel addressModel) {
		return this.addressRepository.save(addressModel);
    }
}
