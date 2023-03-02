package br.edu.ifpb.dac.arthur.house.exceptions;

public class SizeException extends  Exception{
    @Override
    public String getMessage() {
        return "Please enter a valid size";
    }
}
