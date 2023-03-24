package br.edu.ifpb.dac.arthur.house.presentation.controllers;

import br.edu.ifpb.dac.arthur.house.model.entities.House;
import br.edu.ifpb.dac.arthur.house.presentation.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.business.exceptions.EntityNotFoundException;
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

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/house")
public class HouseController {

    private final HouseService houseService;

    private final ConverterService converterService;


    public HouseController(HouseService houseService, ConverterService converterService) {
        this.houseService = houseService;
        this.converterService = converterService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid HouseDto houseDto) {
        var houseModel = converterService.dtoToHouseModel(houseDto);
        houseService.save(houseModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(houseModel.getId());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        try {
            var houseModel = this.houseService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(houseModel);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("House not found.");
        }
    }

    @GetMapping
    public ResponseEntity<Page<House>> findAll(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(houseService.findAll(pageable));
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

    public void delete(UUID id) throws EntityNotFoundException {
        this.houseService.delete(id);
    }
}
