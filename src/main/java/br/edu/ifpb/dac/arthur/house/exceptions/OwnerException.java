package br.edu.ifpb.dac.arthur.house.exceptions;

public class OwnerException extends  Exception{
    @Override
    public String getMessage() {
        return "Please, enter a longer owner name";
    }
}
