package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.interfaces.PasswordEncoderService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PasswordEncoderServiceImpl extends BCryptPasswordEncoder implements PasswordEncoderService {

    @Override
    public void encrypt(SystemUser systemUser) {
        String encryptedPassword = encode(systemUser.getPassword());
        systemUser.setPassword(encryptedPassword);
    }

}
