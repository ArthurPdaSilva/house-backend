package br.edu.ifpb.dac.arthur.house.exceptions;

public class EntityNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Entity not found";
    }
}
