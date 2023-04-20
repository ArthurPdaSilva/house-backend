package br.edu.ifpb.dac.arthur.house.presentation.controllers;

import br.edu.ifpb.dac.arthur.house.business.services.AddressService;
import br.edu.ifpb.dac.arthur.house.business.services.ConverterService;
import br.edu.ifpb.dac.arthur.house.model.entities.Address;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.AddressDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    private final ConverterService converterService;

    public AddressController(AddressService addressService, ConverterService converterService) {
        this.addressService = addressService;
        this.converterService = converterService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AddressDto addressDto) {
        var addressModel = converterService.addressDtoToAddressModel(addressDto);
        this.addressService.save(addressModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressModel.getId());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        try {
            var addressModel = this.addressService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(addressModel);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found.");
        }
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody @Valid AddressDto addressDto) {
        try {
            var addressModel = this.addressService.update(id, addressDto.getNumber());
            return ResponseEntity.status(HttpStatus.OK).body(addressModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Address not found or is a foreign key.");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        try {
            this.addressService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted address");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found.");
        }
    }
}
