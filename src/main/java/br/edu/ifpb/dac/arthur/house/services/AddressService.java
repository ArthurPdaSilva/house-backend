package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.models.AddressModel;
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

	public AddressModel save(AddressModel addressModel) {
		return this.addressRepository.save(addressModel);
    }

	public AddressModel findById(UUID id) {
		Optional<AddressModel> addressModelOptional = this.addressRepository.findById(id);
		return addressModelOptional.get();
	}

	public List<AddressModel> findAll() {
		return this.addressRepository.findAll();
	}

	public void update(UUID id, String number) {
		AddressModel addressModel = this.findById(id);
		addressModel.setNumber(number);
		this.save(addressModel);
	}

	public void delete(UUID id) {
		AddressModel addressModel = this.findById(id);
		this.addressRepository.delete(addressModel);
	}
}
