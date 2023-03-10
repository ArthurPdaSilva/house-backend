package br.edu.ifpb.dac.arthur.house.exceptions;

public class StreetException extends Exception{
    @Override
    public String getMessage() {
        return "Please enter a valid street";
    }
}
