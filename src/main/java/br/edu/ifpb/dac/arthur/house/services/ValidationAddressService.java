package br.edu.ifpb.dac.arthur.house.services;

import br.edu.ifpb.dac.arthur.house.exceptions.ColorException;
import br.edu.ifpb.dac.arthur.house.exceptions.OwnerException;
import br.edu.ifpb.dac.arthur.house.exceptions.SizeException;
import br.edu.ifpb.dac.arthur.house.exceptions.StreetException;
import org.springframework.stereotype.Service;

@Service
public class ValidationAddressService {

    public boolean validationStreet(String street) throws Exception {
        if(street.length() <= 1) {
            throw new StreetException();
        }
        return true;
    }

    public boolean validationNumber(String number) throws Exception {
        if(number.length() <= 1) {
            throw new ColorException();
        }
        return  true;
    }

    public boolean validationCity(String city) throws Exception {
        if(city.length() <= 1) {
            throw new SizeException();
        }
        return  true;
    }
}
