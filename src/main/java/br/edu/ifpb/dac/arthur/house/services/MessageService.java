package br.edu.ifpb.dac.arthur.house.services;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class MessageService {
    public Scanner response = new Scanner(System.in);

    public String getResponse() {
        return response.nextLine();
    }
}
