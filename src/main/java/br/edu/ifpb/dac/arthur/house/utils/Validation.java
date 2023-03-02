package br.edu.ifpb.dac.arthur.house.utils;

import br.edu.ifpb.dac.arthur.house.exceptions.ColorException;
import br.edu.ifpb.dac.arthur.house.exceptions.OwnerException;
import br.edu.ifpb.dac.arthur.house.exceptions.SizeException;

public class Validation {

    public static boolean validationHouse(String owner, String color, Float height, Float width) throws Exception {
        if(owner.length() <= 1) {
            throw new OwnerException();
        } else if(color.length() <= 1) {
            throw new ColorException();
        } else if(height <= 10 || width <= 10) {
            throw new SizeException();
        }

        return true;
    }
}
