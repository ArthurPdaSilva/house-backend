package br.edu.ifpb.dac.arthur.house.business.interfaces;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface AuthenticateService{

    String login(String username, String password);

    SystemUser getLoggedUser();


}
