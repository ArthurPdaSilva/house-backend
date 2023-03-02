package br.edu.ifpb.dac.arthur.house.exceptions;

public class ColorException extends  Exception{
    @Override
    public String getMessage() {
        return "Please, enter a valid color";
    }
}
