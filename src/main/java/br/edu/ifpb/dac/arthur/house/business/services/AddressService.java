package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.model.entities.Address;
import br.edu.ifpb.dac.arthur.house.model.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public Address save(Address address) {
		return this.addressRepository.save(address);
    }

	public Address findById(Long id) throws EntityNotFoundException {
		Optional<Address> addressModelOptional = this.addressRepository.findById(id);
		if(addressModelOptional.isEmpty()) {
			throw new EntityNotFoundException();
		}

		return addressModelOptional.get();
	}

	public List<Address> findAll() {
		return this.addressRepository.findAll();
	}

	public Address update(Long id, String number) throws EntityNotFoundException  {
		Address address = this.findById(id);
		address.setNumber(number);
		return this.save(address);
	}

	public void delete(Long id) throws EntityNotFoundException {
		Address address = this.findById(id);
		this.addressRepository.delete(address);
	}
}
