package br.edu.ifpb.dac.arthur.house.controllers;

import br.edu.ifpb.dac.arthur.house.dtos.HouseDto;
import br.edu.ifpb.dac.arthur.house.exceptions.EntityNotFoundException;
import br.edu.ifpb.dac.arthur.house.models.HouseModel;
import br.edu.ifpb.dac.arthur.house.services.ConverterService;
import br.edu.ifpb.dac.arthur.house.services.HouseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id, @RequestBody @Valid HouseDto houseDto) throws EntityNotFoundException {
        var houseModel = this.houseService.update(id, houseDto.getOwner());
        return ResponseEntity.status(HttpStatus.OK).body(houseModel);
    }

    public void delete(UUID id) throws EntityNotFoundException {
        this.houseService.delete(id);
    }
}
