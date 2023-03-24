package br.edu.ifpb.dac.arthur.house.presentation.controllers;

import br.edu.ifpb.dac.arthur.house.business.services.AddressService;
import br.edu.ifpb.dac.arthur.house.model.entities.House;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.business.services.ConverterService;
import br.edu.ifpb.dac.arthur.house.business.services.HouseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;

    private final AddressService addressService;

    private final ConverterService converterService;


    public HouseController(HouseService houseService, AddressService addressService, ConverterService converterService) {
        this.houseService = houseService;
        this.addressService = addressService;
        this.converterService = converterService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid HouseDto houseDto) {
        var houseModel = converterService.dtoToHouseModel(houseDto);
        try {
            houseModel.setAddress(addressService.findById(houseDto.getAddressId()));
            this.houseService.save(houseModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(houseModel.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed.");
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        try {
            var houseModel = this.houseService.findById(id);
            var houseDto = this.converterService.HouseModelToDto(houseModel);
            return ResponseEntity.status(HttpStatus.OK).body(houseDto);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("House not found.");
        }
    }

    @GetMapping
    public ResponseEntity<List<HouseDto>> findAll() {
        List<House> houses = houseService.findAll();
        List<HouseDto> housesDto = this.converterService.housesModelToDtos(houses);
        return ResponseEntity.status(HttpStatus.OK).body(housesDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid HouseDto houseDto) {
        try {
            var houseModel = this.houseService.update(id, houseDto.getOwner());
            return ResponseEntity.status(HttpStatus.OK).body(houseModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("House not found.");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") UUID id) {
        try {
            this.houseService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted house");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("House not found.");
        }
    }
}
