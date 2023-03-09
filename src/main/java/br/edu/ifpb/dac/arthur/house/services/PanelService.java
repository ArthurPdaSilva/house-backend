package br.edu.ifpb.dac.arthur.house.services;

import org.springframework.stereotype.Service;

@Service
public class PanelService {
    public void print(String text) {
        System.out.println(text);
    }

    public void printError(String text) {
        System.err.println(text);
    }
}
