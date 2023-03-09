package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.exceptions.ColorException;
import br.edu.ifpb.dac.arthur.house.exceptions.OwnerException;
import br.edu.ifpb.dac.arthur.house.exceptions.SizeException;
import org.springframework.stereotype.Service;

@Service
public class ValidationHouseService {

    public boolean validationOwner(String owner) throws Exception {
        if(owner.length() <= 1) {
            throw new OwnerException();
        }
        return true;
    }

    public boolean validationColor(String color) throws Exception {
        if(color.length() <= 1) {
            throw new ColorException();
        }
        return  true;
    }

    public boolean validationSize(Float height, Float width) throws Exception {
        if(width == 0 || height == 0) {
            throw new SizeException();
        }
        return  true;
    }
}
