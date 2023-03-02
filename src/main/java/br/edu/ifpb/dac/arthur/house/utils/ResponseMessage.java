package br.edu.ifpb.dac.arthur.house.utils;

import java.util.Scanner;

public class ResponseMessage {
    public static Scanner response = new Scanner(System.in);

    public static String message() {
        return response.nextLine();
    }
}
