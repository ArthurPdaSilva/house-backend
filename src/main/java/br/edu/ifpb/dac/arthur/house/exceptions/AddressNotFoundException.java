package br.edu.ifpb.dac.arthur.house.exceptions;

public class AddressNotFoundException extends  Exception{
    @Override
    public String getMessage() {
        return "Address not found";
    }
}
