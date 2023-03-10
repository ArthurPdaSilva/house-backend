package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.exceptions.LengthException;
import br.edu.ifpb.dac.arthur.house.exceptions.SizeException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean validationSize(Float height, Float width) throws Exception {
        if(width == 0 || height == 0) {
            throw new SizeException();
        }
        return  true;
    }

    public boolean validationLength(String text) throws LengthException {
        if(text.length() == 4) {
            throw new LengthException();
        }
        return true;
    }

    public boolean validationCode(String text) throws LengthException {
        if(text.length() != 8) {
            throw new LengthException();
        }
        return true;
    }
}
