package br.edu.ifpb.dac.arthur.house.business.interfaces;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface SystemUserService extends UserDetailsService {

    SystemUser save(SystemUser systemUser);
    SystemUser update(SystemUser systemUser);
    void delete(UUID id);
    SystemUser findById(UUID id);
    SystemUser findByEmail(String email);
    SystemUser findByUsername(String username);
    Iterable<SystemUser> findAll();
    List<SystemUser> find(SystemUser filter);


}
