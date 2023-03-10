package br.edu.ifpb.dac.arthur.house.exceptions;

public class LengthException extends Exception {

    @Override
    public String getMessage() {
        return "Please, enter the valid length";
    }
}
