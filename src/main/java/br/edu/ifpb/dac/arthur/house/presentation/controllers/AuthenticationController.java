package br.edu.ifpb.dac.arthur.house.presentation.controllers;


import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@RequestMapping("/api")
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class AuthenticationController {
}
