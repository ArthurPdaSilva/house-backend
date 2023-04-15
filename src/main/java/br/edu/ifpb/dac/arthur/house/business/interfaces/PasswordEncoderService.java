package br.edu.ifpb.dac.arthur.house.business.interfaces;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface PasswordEncoderService extends PasswordEncoder {
    void encrypt(SystemUser systemUser);
}
